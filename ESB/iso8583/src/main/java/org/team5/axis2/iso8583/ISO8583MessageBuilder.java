package org.team5.axis2.iso8583;

import java.io.InputStream;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axiom.om.impl.OMNamespaceImpl;
import org.apache.axiom.soap.SOAPEnvelope;
import org.apache.axiom.soap.SOAPFactory;
import org.apache.axis2.AxisFault;
import org.apache.axis2.builder.Builder;
import org.apache.axis2.context.MessageContext;
import org.apache.commons.io.IOUtils;

public class ISO8583MessageBuilder implements Builder {

	@Override
	public OMElement processDocument(InputStream inputStream, String arg1,
			MessageContext messageContext) throws AxisFault {
		System.out.println("***** ISO8583 message builder running *****");
		SOAPFactory soapFactory = OMAbstractFactory.getSOAP12Factory();
		SOAPEnvelope soapEnvelope = soapFactory.getDefaultEnvelope();
		OMNamespace omNamespace = soapFactory.createOMNamespace(
				"http://iso8583.org/payload", "ns");
		OMNamespaceImpl ns = new OMNamespaceImpl("http://iso8583.org/payload",
				"ns");

		OMElement payLoadElement = soapFactory.createOMElement("payLoad",
				omNamespace);

		StringWriter writer = new StringWriter();
		try {
			IOUtils.copy(inputStream, writer, null);

			String payLoadDataStr = writer.toString();
			String action = null;
			String simpleReturn = null; // status
			String status = null;
			boolean resultMap = false;
			System.out.println("***** Received ISO8583 message (CSV) : "
					+ payLoadDataStr + " *****");
			Map<String, String> params = new LinkedHashMap<String, String>();

			String[] keyValuePairs = payLoadDataStr.split(",");
			for (String keyValuePair : keyValuePairs) {
				String key = keyValuePair.split("=")[0];
				String value = keyValuePair.split("=")[1];
				if ("action".equals(key)) {
					action = value;
				} else if ("return".equals(key)) {
					simpleReturn = value;
				} else if ("sys:status".equals(key)) {
					status = value;
				} else if ("sys:resultType".equals(key)) {
					if ("map".equalsIgnoreCase(value))
						resultMap = true;
				} else {
					params.put(key, value);
				}
			}

			if (action != null && !action.trim().isEmpty()) {
				payLoadElement.setLocalName(action);

				payLoadElement.setNamespace(ns);
				payLoadElement.setText("");
				OMFactory omFactory = OMAbstractFactory.getOMFactory();
				if (resultMap) {
					Map<Integer, Map<String, String>> returnMap = new HashMap<Integer, Map<String, String>>();
					for (Map.Entry<String, String> entry : params.entrySet()) {
						String value = entry.getValue();
						value = value.replaceAll("\\[", "").replaceAll("\\]",
								"");
						String values[] = value.split("::");
						for (int i = 0; i < values.length; i++) {
							Map<String, String> payloadData = new HashMap<String, String>();
							if (returnMap.containsKey(i)) {
								payloadData = returnMap.get(i);
							}
							payloadData.put(entry.getKey(), values[i]);
							returnMap.put(i, payloadData);

						}
					}

					for (Map.Entry<Integer, Map<String, String>> entry : returnMap
							.entrySet()) {
						OMElement returnElement = omFactory.createOMElement(
								"return", ns);
						for (Map.Entry<String, String> payloadEle : entry
								.getValue().entrySet()) {
							OMElement element = omFactory.createOMElement(
									payloadEle.getKey(), ns);
							element.setText(payloadEle.getValue());
							returnElement.addChild(element);
						}

						payLoadElement.addChild(returnElement);
					}

				} else {
					OMElement returnElement = omFactory.createOMElement(
							"return", ns);
					if (status.equalsIgnoreCase("success")) {
						if (params.size() == 0) {
							returnElement.setText(simpleReturn);
						}
					} else {
						OMElement element = omFactory.createOMElement("status",
								ns);
						element.setText(status);
						returnElement.addChild(element);
					}
					for (Map.Entry<String, String> entry : params.entrySet()) {
						OMElement element = omFactory.createOMElement(
								entry.getKey(), ns);
						element.setText(entry.getValue());
						returnElement.addChild(element);
					}
					payLoadElement.addChild(returnElement);
				}
			} else {
				payLoadElement.setNamespace(ns);
				payLoadElement.setLocalName("Error");
				payLoadElement.setText("message format not recognized");
			}

		} catch (Exception e) {
			payLoadElement.setNamespace(ns);
			payLoadElement.setLocalName("Error");
			payLoadElement.setText("An unhandled error occurred " + e);
		}

		soapEnvelope.getBody().addChild(payLoadElement);

		return soapEnvelope;
	}

}
