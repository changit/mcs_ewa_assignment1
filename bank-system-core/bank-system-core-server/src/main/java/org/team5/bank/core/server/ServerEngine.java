/**
 * 
 */
package org.team5.bank.core.server;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import javax.net.ServerSocketFactory;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

import org.apache.commons.configuration.XMLConfiguration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ServerEngine {
	
	private static Log log = LogFactory.getLog(ServerEngine.class); 
	private XMLConfiguration config;
	
	public ServerEngine(XMLConfiguration config){
		this.setConfig(config);
	}

	public void setConfig(XMLConfiguration config) {
		this.config = config;
	}

	public XMLConfiguration getConfig() {
		return config;
	}
	
	public void start() throws NoSuchAlgorithmException, CertificateException,
			KeyStoreException, IOException, UnrecoverableKeyException,
			KeyManagementException {
		SSLContext sslContext = getSSLContext();
		ServerSocketFactory sslSocketFactory = sslContext.getServerSocketFactory();

		ServerSocket listener = sslSocketFactory.createServerSocket(config.getInt("server[@port]",2001));
		int maxConnections = config.getInt("server[@max]", 100);
		log.info("Waiting for connections.....");
		int i = 0;
		while ((i++ < maxConnections) || (maxConnections == 0)) {

			Socket connection = listener.accept();
			ServerWorker worker = new ServerWorker(connection);
			Thread workerThread = new Thread(worker);
			workerThread.start();
		}

	}
	
	private SSLContext getSSLContext() throws NoSuchAlgorithmException,
			CertificateException, IOException, KeyStoreException,
			UnrecoverableKeyException, KeyManagementException {
		SSLContext context = SSLContext.getInstance("TLSv1");
		KeyManagerFactory keyFac = KeyManagerFactory
				.getInstance(KeyManagerFactory.getDefaultAlgorithm());
		
		KeyStore keyStore = KeyStore.getInstance(config.getString("server.keyStore.type","JKS"));
		InputStream keyInput = getClass().getClassLoader().getResourceAsStream(config.getString("server.keyStore.file"));
		
		log.info("Loading keyStore.....");
		keyStore.load(keyInput, config.getString("server.keyStore.password").toCharArray());
		log.info("Initializing KeyManagerFactory.....");
		keyFac.init(keyStore, config.getString("server.keyStore.password").toCharArray());
		
		TrustManagerFactory trustFac = TrustManagerFactory
				.getInstance(TrustManagerFactory.getDefaultAlgorithm());
		InputStream trustInput = getClass().getClassLoader().getResourceAsStream(config.getString("server.trustStore.file"));
		
		KeyStore trustStore = KeyStore.getInstance(config.getString("server.trustStore.type","JKS"));
		log.info("Loading trustStore.....");
		trustStore.load(trustInput, null);
		log.info("Initializing TrustManagerFactory.....");
		trustFac.init(trustStore);
		
		log.info("Initializing SSLContext.....");
		context.init(keyFac.getKeyManagers(), trustFac.getTrustManagers(), null);
		return context;
	}

}
