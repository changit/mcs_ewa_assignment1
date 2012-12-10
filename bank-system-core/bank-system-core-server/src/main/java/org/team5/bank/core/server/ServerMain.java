package org.team5.bank.core.server;


import org.apache.commons.configuration.XMLConfiguration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ServerMain {
	
	private static Log log = LogFactory.getLog(ServerMain.class); 

	public static void main(String[] args) {
		
		log.info("Starting Core Banking Server...");
		log.info("Operating System : " + System.getProperty("os.name"));
		log.info("Java Version : " + System.getProperty("java.version"));
		
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			public void run() {
				log.info("Shutting-down Core Banking Server...");
			}
		}));

		try {
			log.info("Loading configuration.....");
			XMLConfiguration config = new XMLConfiguration("server.xml");
			
			log.info("Initializing server.....");
			ServerEngine engine = new ServerEngine(config);
			engine.start();
		} catch (Exception e) {
			log.error("An error has occurred : ", e);
		}

	}

}
