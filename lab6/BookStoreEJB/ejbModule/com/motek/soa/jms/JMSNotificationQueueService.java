package com.motek.soa.jms;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class JMSNotificationQueueService implements JMSService {
	private InitialContext context;
	private QueueConnectionFactory factory;
	private QueueConnection connection;
	private QueueSession session;
	private Queue queue;
	private QueueSender publisher;

	public void init() throws JMSException, NamingException {  
        context = new InitialContext(); 
        factory = (QueueConnectionFactory) context.lookup("ConnectionFactory");  
        connection = factory.createQueueConnection("iza","obidowa1721"); 
        session = connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
        queue = (Queue) context.lookup("jms/queue/notificationQueue");
        
        publisher = session.createSender(queue);
	}
	
	public void sendMessage(String msg) throws JMSException { 
		Message m = session.createTextMessage(msg);
		publisher.send(m);
	}

	public void close() throws JMSException {
		connection.close();
	}

}
