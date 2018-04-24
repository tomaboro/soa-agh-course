package com.motek.soa;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class NotificationListener implements MessageListener {

	@Override
	public void onMessage(Message message) {
        TextMessage msg=(TextMessage) message;  
        try {
			System.out.println("following message is received:"+msg.getText());
		} catch (JMSException e) {
			System.out.println("Received Message but error occured: " + e.getMessage());
		}  
		
	}

}
