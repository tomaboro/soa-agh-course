package com.motek.soa.jms;


import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.QueueConnectionFactory;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.jms.Session;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class JMSNewBookTopicService implements JMSService {
	private InitialContext context;
	private TopicConnectionFactory factory;
	private Topic topic;
	private TopicConnection connection;
	private TopicSession session;

	private TopicPublisher publisher;

	public void init() throws JMSException, NamingException {  
        context = new InitialContext(); 
        factory = (TopicConnectionFactory) context.lookup("ConnectionFactory"); 
        connection = factory.createTopicConnection("iza","obidowa1721"); 
        session = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
        topic =(Topic)context.lookup("jms/topic/newBookTopic");
        connection.start();
        publisher = session.createPublisher(topic);
	}
	
	public void sendMessage(String msg) throws JMSException { 
		Message m = session.createTextMessage(msg);
		publisher.send(m);
	}

	public void close() throws JMSException {
		connection.close();
	}

}
