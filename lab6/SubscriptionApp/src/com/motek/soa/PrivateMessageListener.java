package com.motek.soa;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class PrivateMessageListener implements MessageListener {
	private final String id;

	public PrivateMessageListener(String id) {
		this.id = id;
	}

	@Override
	public void onMessage(Message message) {
		try {	
			System.out.println("New private message for [" + id + "] : " + ((TextMessage) message).getText());
		} catch (JMSException e) {
			e.printStackTrace();
		} 
	}
}
