
	package com.motek.soa;

	import javax.jms.JMSException;
	import javax.jms.Message;
	import javax.jms.MessageListener;
	import javax.jms.TextMessage;

	public class SubscriptionMessageListener implements MessageListener {
		private final String topic;

		public SubscriptionMessageListener (String topic) {
			this.topic = topic;
		}

		@Override
		public void onMessage(Message message) {
			try {	
				System.out.println("New message in topic [" + topic + "] : " + ((TextMessage) message).getText());
			} catch (JMSException e) {
				e.printStackTrace();
			} 
		}
		
		
	}
