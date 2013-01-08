package org.team5.axis2.iso8583;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.Iterator;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMOutputFormat;
import org.apache.axis2.AxisFault;
import org.apache.axis2.context.MessageContext;
import org.apache.axis2.transport.MessageFormatter;

public class ISO8583MessageFormatter implements MessageFormatter {

	@Override
	public String formatSOAPAction(MessageContext mc, OMOutputFormat format,
			String soapAction) {
		return soapAction;
	}

	@Override
	public byte[] getBytes(MessageContext mc, OMOutputFormat format)
			throws AxisFault {
		if("out".equals(mc.getAxisMessage().getDirection())){
			return mc.getEnvelope().toString().getBytes();
		} else{
			System.out.println("***** ISO8583 message formatter running *****");
			String localName = mc.getEnvelope().getSOAPBodyFirstElementLocalName();
			@SuppressWarnings("rawtypes")
			Iterator childrenWithLocalName = mc.getEnvelope().getBody().getChildrenWithLocalName(localName);
			StringBuffer buffer = new StringBuffer("action=" + localName + ",");
			while(childrenWithLocalName.hasNext()){
				OMElement firstChildWithName =(OMElement) childrenWithLocalName.next();
				@SuppressWarnings("rawtypes")
				Iterator childElements = firstChildWithName.getChildElements();
				while (childElements.hasNext()) {
					OMElement el =(OMElement) childElements.next();
					buffer.append(el.getLocalName());
					buffer.append("=");
					buffer.append(el.getText());
					buffer.append(",");
				}
			}
			String out = buffer.toString().replaceAll(",$","");
			System.out.println("***** Formatted ISO8583 message (CSV) : " + out + " *****");
			return out.getBytes();
		}
	}

	@Override
	public String getContentType(MessageContext msgCtxt, OMOutputFormat format,
			String soapActionString) {
	        return "application/iso8583";
	}

	@Override
	public URL getTargetAddress(MessageContext arg0, OMOutputFormat arg1,
			URL url) throws AxisFault {
		return url;
	}

	@Override
	public void writeTo(MessageContext mc, OMOutputFormat format,
			OutputStream out, boolean arg3) throws AxisFault {
		try {
			out.write(getBytes(mc,format));
		} catch (IOException e) {
			throw new AxisFault(e.toString());
		}
	}

}
