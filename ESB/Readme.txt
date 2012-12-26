
=== Setup ESB ===

1. Download WSO2 ESB 4.5.0 from 
   http://dist.wso2.org/products/enterprise-service-bus/4.5.0/wso2esb-4.5.0.zip (patches may not work with other versions)
2. Extract wso2esb-4.5.0.zip file to local dir (eg. $CARBON_HOME)
3. Copy patches/axis2_1.6.1.wso2v6.jar to $CARBON_HOME/repository/components/plugins/
4. Copy patches/iso8583.jar to $CARBON_HOME/repository/components/lib/
5. Copy all content of repository/conf to $CARBON_HOME/repository/conf
6. Copy all content of repository/deployment to $CARBON_HOME/repository/deployment
7. cd to $CARBON_HOME and run bin/wso2server.sh


==core banking service ==
file location : $CARBON_HOME/repository/deployment/server/synapse-configs/default/proxy-services/CoreService.xml

Endpoints
https://<IP>:8243/services/CoreService
http://<IP>:8280/services/CoreService

WSDL's 
http://<IP>:8280/services/CoreService?wsdl
http://<IP>:8280/services/CoreService?wsdl2
