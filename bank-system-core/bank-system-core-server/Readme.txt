
== Setup Core Banking Server ==

1. build the project with maven
2. Extract target/core-banking-server.zip file to local dir (eg. $CORE_HOME)
3. Configuration files are available in conf directory
	|-- conf
	|   |-- client-truststore.jks
	|   |-- hibernate.cfg.xml
	|   |-- keystore.jks
	|   |-- log4j.properties
	|   `-- server.xml

	== server.xml ==

	<?xml version="1.0" encoding="ISO-8859-1" ?>
	<configuration>
		<server port="2001" max="500">
			<keyStore>
				<file>keystore.jks</file>
				<type>JKS</type>
				<password>wso2carbon</password>
			</keyStore>
			<trustStore>
				<file>client-truststore.jks</file>
				<type>JKS</type>
				<password>wso2carbon</password>
			</trustStore>
		</server>
	</configuration>

	port = TCP Port
	max = maximum allowed connections

4. running server (UNIX)
   cd $CORE_HOME
   chmod +x start.sh
   ./start.sh

    -or- (Any)
   java -jar core-banking-server.jar

5. Sample CSV request/response

	1.	request : action=withdraw,accountNo=012345678900001,amount=2000
		response: action=withdrawResponse,status=success,return=true

	2.	request : action=withdraw,accountNo=012345678900001,amount=200000000
		response: action=withdrawResponse,status=failed,error=Account has insufficient funds


