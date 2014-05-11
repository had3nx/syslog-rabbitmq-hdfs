package org.haden.training.spring.springintegration.syslogingester;

import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.springframework.integration.Message;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Component;


@Component
public class SyslogTransformer {

	public static final String FACILITY = "FACILITY";
	public static final String SEVERITY = "SEVERITY";
	public static final String TIMESAMP = "TIMESTAMP";
	public static final String HOST = "HOST";
	public static final String TAG = "TAG";
	public static final String MESSAGE = "MESSAGE";
	public static final String UNDECODED = "UNDECODED";	

	
	
	private final Pattern pattern = Pattern.compile("<([^>]+)>(.{15}) ([^ ]+) ([^:]+): (.*)");

	static Logger logger = Logger.getLogger(SyslogTransformer.class);
	
	@Transformer
	public Message<String> transform(Message<byte[]> message) {
		
		String payload = "";
		int facility = 0;
		String host = "";
		int severity = 0;
		String timestamp ="";
		String tag ="";
		
		
		try {
			payload = new String(message.getPayload(), "UTF-8");
			logger.debug("Received Message with payload : " + payload);
			//System.out.println("Payload "+payload);
		}
		catch (UnsupportedEncodingException e) {
			payload = new String(message.getPayload());
		}
		Matcher matcher = pattern.matcher(payload);
		if (matcher.matches()) {
			String facilityString = matcher.group(1);
			facility = Integer.parseInt(facilityString);
			severity = facility & 0x7;
			facility = facility >> 3;
			
			timestamp = matcher.group(2);
			
			host = matcher.group(3);
			tag = matcher.group(4);		
					
		}	
		return MessageBuilder.withPayload(payload)
				.setHeader("HOST", host)
				.setHeader("SEVERITY", severity)
				.setHeader("TAG", tag)
				.setHeader("FACILITY",facility)
				.setHeader("TIMESTAMP", timestamp)
				.copyHeaders(message.getHeaders())
				.build();
	}
}
