/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */


package org.apache.axis2.transport.tcp;

import org.apache.axis2.AxisFault;
import org.apache.axis2.description.OutInAxisOperation;
import org.apache.axis2.engine.AxisEngine;
import org.apache.axis2.context.MessageContext;
import org.apache.axis2.transport.MessageFormatter;
import org.apache.axis2.transport.OutTransportInfo;
import org.apache.axis2.transport.TransportUtils;
import org.apache.axis2.transport.base.AbstractTransportSender;
import org.apache.axiom.soap.SOAPEnvelope;
import org.apache.axis2.transport.base.BaseUtils;
import org.apache.axiom.om.OMOutputFormat;

import java.io.IOException;
import java.net.*;
import java.util.Map;
import java.util.HashMap;
import java.io.OutputStream;

import javax.net.ssl.SSLSocketFactory;

public class TCPTransportSender extends AbstractTransportSender {
	
	
	public TCPTransportSender() {
		String carbonHome = System.getProperty("user.dir");
		System.setProperty("javax.net.ssl.keyStore", carbonHome + "/repository/resources/security/wso2carbon.jks");
		System.setProperty("javax.net.ssl.keyStorePassword", "wso2carbon");
		System.setProperty("sun.security.ssl.allowUnsafeRenegotiation", "true");
		System.setProperty("javax.net.ssl.trustStore", carbonHome + "/repository/resources/security/client-truststore.jks");
	}
	

    public void sendMessage(MessageContext msgContext, String targetEPR,
                            OutTransportInfo outTransportInfo) throws AxisFault {

        if (targetEPR != null) {
        	boolean secure = false;
            Map<String,String> params = getURLParameters(targetEPR);
            int timeout = -1;
            if (params.containsKey("timeout")) {
                timeout = Integer.parseInt(params.get("timeout"));
            }
			Object property = msgContext.getProperty("tcp.secure");
			if (property != null) {
				if ("true".equals(property))
					secure = true;
			}
			
			String contentType = (String) msgContext.getProperty("contentType");
			
            Socket socket = openTCPConnection(targetEPR, timeout, secure);
            msgContext.setProperty(TCPConstants.TCP_OUTPUT_SOCKET, socket);

            try {
                writeMessageOut(msgContext, socket.getOutputStream());
                if (!msgContext.getOptions().isUseSeparateListener() && !msgContext.isServerSide()){
                    waitForReply(msgContext, socket, /*params.get("contentType")!=null?params.get("contentType"):*/contentType);
                }
            } catch (IOException e) {
                handleException("Error while sending a TCP request", e);
            }

        } else if (outTransportInfo != null && (outTransportInfo instanceof TCPOutTransportInfo)) {
            TCPOutTransportInfo outInfo = (TCPOutTransportInfo) outTransportInfo;
            try {
                 writeMessageOut(msgContext, outInfo.getSocket().getOutputStream());
            } catch (IOException e) {
                handleException("Error while sending a TCP response", e);
            } finally {
                closeConnection(outInfo.getSocket());
            }
        }
    }

	private void writeMessageOut(MessageContext msgContext,
			OutputStream outputStream) throws AxisFault, IOException {
		MessageFormatter messageFormatter = BaseUtils
				.getMessageFormatter(msgContext);
		OMOutputFormat format = BaseUtils.getOMOutputFormat(msgContext);

		messageFormatter.writeTo(msgContext, format, outputStream, true);
	}

    @Override
    public void cleanup(MessageContext msgContext) throws AxisFault {
        Object socketObj = msgContext.getProperty(TCPConstants.TCP_OUTPUT_SOCKET);
        if (socketObj != null) {
            closeConnection((Socket) socketObj);
        }
    }

    private void waitForReply(MessageContext msgContext, Socket socket,
                              String contentType) throws AxisFault {

        if (!(msgContext.getAxisOperation() instanceof OutInAxisOperation) &&
                msgContext.getProperty(org.apache.axis2.Constants.PIGGYBACK_MESSAGE) == null) {
            return;
        }

        if (contentType == null) {
            contentType = TCPConstants.TCP_DEFAULT_CONTENT_TYPE;
        }

        try {
            MessageContext responseMsgCtx = createResponseMessageContext(msgContext);
            SOAPEnvelope envelope = TransportUtils.createSOAPMessage(msgContext,
                        socket.getInputStream(), contentType);
            
            responseMsgCtx.setEnvelope(envelope);
            AxisEngine.receive(responseMsgCtx);
        } catch (Exception e) {
            handleException("Error while processing response", e);
        }
    }

    private Map<String,String> getURLParameters(String url) throws AxisFault {
        try {
            Map<String,String> params = new HashMap<String,String>();
            URI tcpUrl = new URI(url);
            String query = tcpUrl.getQuery();
            if (query != null) {
                String[] paramStrings = query.split("&");
                for (String p : paramStrings) {
                    int index = p.indexOf('=');
                    params.put(p.substring(0, index), p.substring(index+1));
                }
            }
            return params;
        } catch (URISyntaxException e) {
            handleException("Malformed tcp url", e);
        }
        return null;
    }

    private Socket openTCPConnection(String url, int timeout, boolean secure) throws AxisFault {
        try {
            URI tcpUrl = new URI(url);
            if (!tcpUrl.getScheme().equals("tcp")) {
                throw new Exception("Invalid protocol prefix : " + tcpUrl.getScheme());
            }
            SocketAddress address = new InetSocketAddress(tcpUrl.getHost(), tcpUrl.getPort());
            Socket socket = null;
            
            if(secure){
            	SSLSocketFactory sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            	socket = sslSocketFactory.createSocket();
            } else{
            	socket = new Socket();	
            }
            
            if (timeout != -1) {
                socket.setSoTimeout(timeout);
            }
            socket.connect(address);
            return socket;
        } catch (Exception e) {
            handleException("Error while opening TCP connection to : " + url, e);
        }
        return null;
    }

    private void closeConnection(Socket socket) {
        try {
            socket.close();
        } catch (IOException e) {
            log.error("Error while closing a TCP socket", e);
        }
    }
}
