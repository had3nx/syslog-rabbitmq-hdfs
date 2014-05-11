package com.oreilly.springdata.hadoop.streaming;

import org.apache.hadoop.fs.FileSystem;
import org.haden.training.spring.springintegration.syslogarchiver.hdfsutils.HdfsTextFileWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.Message;
import org.springframework.integration.support.MessageBuilder;


//@ContextConfiguration(locations = { "classpath:/META-INF/spring/hadoop-context.xml" })
public class HdfsTextFileWriterIntegrationTests {


	private FileSystem hadoopFs;
	

	public void test() throws Exception {
		HdfsTextFileWriter fileWriter = new HdfsTextFileWriter(hadoopFs);
		Message<?> message = MessageBuilder.withPayload("Hello World!").build();
		fileWriter.write(message);		
	}

}
