syslog-rabbitmq-hdfs
===============

Read data from Syslog , send to RabbitMQ and then push to HDFS . Tested on RabbitMQ 3.3.1 and PivotalHD  VM 1.1.0 . 



# Checking out and Building

To check out the project from Github and build from source using Maven

	git https://github.com/had3nx/syslog-rabbitmq-hdfs.git

Build and run the syslog ingester . Make sure to update the relevant syslog ports and RabbitMQ server parameters in the properties file.

	cd spring-integration-ingester
	mvn install
	java -jar target/spring-integration-ingester-*.jar

Build and run the archiver . Make sure to update the relevant HDFS and RabbitMQ server parameters in the properties file. Archiver should be running on a Hadoop client or node.
	
	cd spring-integration-archiver
	mvn install
	java -jar target/spring-integration-archiver-*.jar
