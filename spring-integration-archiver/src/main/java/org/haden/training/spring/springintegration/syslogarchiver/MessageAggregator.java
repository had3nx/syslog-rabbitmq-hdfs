package org.haden.training.spring.springintegration.syslogarchiver;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.integration.Message;
import org.springframework.integration.MessageHandlingException;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class MessageAggregator {
	
	
	

	private static  Logger logger = Logger.getLogger(MessageAggregator.class);
	
	//Method to aggregate all messages and create one message
	public Message<String> aggregate(List<Message> msgList) {
		
	
		StringBuilder sb = new StringBuilder();		
		 for (Message msg: msgList) {
			 
			 Object payload = msg.getPayload();
			 
			 if (payload instanceof String) {
				 sb.append((String)payload);
				 sb.append("\n\r");
			 }
			 else{
				 new MessageHandlingException(msg,
							"Expects " +
							"a  String payload, but received: " + payload.getClass());
			 }
			
		 }
		 
		 //
		 
		 Message<String> message = MessageBuilder.withPayload(sb.toString()).build();		 
		 
		return message;	

	}
	
	//Need more information
	public int correlate(Message<?> message) {
		return 1;
	}

	
	
	

}
