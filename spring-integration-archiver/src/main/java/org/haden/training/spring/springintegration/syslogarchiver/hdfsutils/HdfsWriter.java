package org.haden.training.spring.springintegration.syslogarchiver.hdfsutils;

import java.io.IOException;

import org.springframework.integration.Message;

public interface HdfsWriter {

	void write(Message<?> message) throws IOException;
	
	void close();
}
