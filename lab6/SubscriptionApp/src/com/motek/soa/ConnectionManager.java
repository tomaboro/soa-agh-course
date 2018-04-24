package com.motek.soa;

import java.util.Properties;

import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.naming.InitialContext;

public class ConnectionManager {
	private final String id; 
	
	public ConnectionManager(String id) {
		this.id = id;
		try {
			Properties props = new Properties();
	        props.put("java.naming.factory.url.pkgs","org.jboss.ejb.client.naming");
	        InitialContext ctx = new InitialContext(props);
	        
	        TopicConnectionFactory factory = (TopicConnectionFactory)ctx.lookup("jms/RemoteConnectionFactory");  
	        
	        TopicConnection connection = factory.createTopicConnection("iza","obidowa1721");  
	        //connection.setClientID(id);
	        connection.start(); 
	        
	        TopicSession session = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
	        
	        Topic topic =(Topic)ctx.lookup("jms/topic/test");  
	       
	        MessageConsumer receiver = session.createConsumer(topic,"USER = '" + this.id +"'");
	        
	        PrivateMessageListener listener = new PrivateMessageListener(this.id); 
	        
	        receiver.setMessageListener(listener);
	        
		} catch (Exception e) {
			e.printStackTrace();
		}  
	}
	
	public void addTopic(String topicName) {
		try {
			Properties props = new Properties();
	        props.put("java.naming.factory.url.pkgs","org.jboss.ejb.client.naming");
	        InitialContext ctx = new InitialContext(props);
	        
	        TopicConnectionFactory factory = (TopicConnectionFactory)ctx.lookup("jms/RemoteConnectionFactory");  
	        
	        TopicConnection connection = factory.createTopicConnection("iza","obidowa1721");  
	        //connection.setClientID(id + "-" + topicName);
	        connection.start(); 
	        
			TopicSession session = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
			
			Topic topic =(Topic)ctx.lookup("jms/topic/test");
			
	        MessageConsumer receiver = session.createConsumer(topic,"TOPIC = '" + topicName + "'");   
	        
	        SubscriptionMessageListener listener = new SubscriptionMessageListener(topicName);
	        
	        receiver.setMessageListener(listener); 
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void sendPrivateMessage(String userID, String msg) {
		try {
			Properties props = new Properties();
	        props.put("java.naming.factory.url.pkgs","org.jboss.ejb.client.naming");
	        InitialContext ctx = new InitialContext(props);
	        
	        TopicConnectionFactory factory = (TopicConnectionFactory)ctx.lookup("jms/RemoteConnectionFactory");  
	        
	        TopicConnection connection = factory.createTopicConnection("iza","obidowa1721");  
	        //connection.setClientID(id + userID + msg);
	        connection.start();
	        
	        TopicSession session = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
	        
			Message m = session.createTextMessage(msg);
			m.setStringProperty("USER", userID);
			
			Topic topic =(Topic)ctx.lookup("jms/topic/test");
			
			TopicPublisher publisher = session.createPublisher(topic);
			
			publisher.publish(m);
			
			connection.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void sendTopicMessage(String topicName, String msg) {
		try {
			Properties props = new Properties();
	        props.put("java.naming.factory.url.pkgs","org.jboss.ejb.client.naming");
	        InitialContext ctx = new InitialContext(props);
	        
	        TopicConnectionFactory factory = (TopicConnectionFactory)ctx.lookup("jms/RemoteConnectionFactory");  
	        
	        TopicConnection connection = factory.createTopicConnection("iza","obidowa1721");  
	        //connection.setClientID(id + topicName + msg);
	        connection.start(); 
	        
			TopicSession session = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
			
			Message m = session.createTextMessage(msg);
			m.setStringProperty("TOPIC", topicName);
			
			Topic topic =(Topic)ctx.lookup("jms/topic/test");
			
			TopicPublisher publisher = session.createPublisher(topic);
			
			publisher.publish(m);
			
			connection.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
