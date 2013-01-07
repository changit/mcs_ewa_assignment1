package com.sri.service.impl;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;
import localhost._8080.bank_system_core_auth.AuthService;

/**
 * This class was generated by Apache CXF 2.6.1
 * 2013-01-05T17:56:28.040+05:30
 * Generated source version: 2.6.1
 * 
 */
@WebServiceClient(name = "AuthServiceImplService", 
                  wsdlLocation = "http://ec2-67-202-56-114.compute-1.amazonaws.com:20080/bank-system-core-auth/AuthSer?wsdl",
                  targetNamespace = "http://impl.service.sri.com/") 
public class AuthServiceImplService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://impl.service.sri.com/", "AuthServiceImplService");
    public final static QName AuthServiceImplPort = new QName("http://impl.service.sri.com/", "AuthServiceImplPort");
    static {
        URL url = null;
        try {
            url = new URL("http://ec2-67-202-56-114.compute-1.amazonaws.com:20080/bank-system-core-auth/AuthSer?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(AuthServiceImplService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://ec2-67-202-56-114.compute-1.amazonaws.com:20080/bank-system-core-auth/AuthSer?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public AuthServiceImplService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public AuthServiceImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public AuthServiceImplService() {
        super(WSDL_LOCATION, SERVICE);
    }
    

    /**
     *
     * @return
     *     returns AuthService
     */
    @WebEndpoint(name = "AuthServiceImplPort")
    public AuthService getAuthServiceImplPort() {
        return super.getPort(AuthServiceImplPort, AuthService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns AuthService
     */
    @WebEndpoint(name = "AuthServiceImplPort")
    public AuthService getAuthServiceImplPort(WebServiceFeature... features) {
        return super.getPort(AuthServiceImplPort, AuthService.class, features);
    }

}
