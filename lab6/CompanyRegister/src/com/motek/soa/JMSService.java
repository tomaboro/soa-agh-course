package com.motek.soa;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Properties;

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

public class JMSService implements JEEService {
	private InitialContext context;
	private QueueConnectionFactory factory;
	private QueueConnection connection;
	private QueueSession session;
	private Queue queue;
	private QueueSender publisher;

	@Override
	public void init() throws JMSException, NamingException {
        context = new InitialContext(); 
        factory = (QueueConnectionFactory) context.lookup("ConnectionFactory");  
        connection = factory.createQueueConnection("iza","obidowa1721"); 
        session = connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
        queue = (Queue) context.lookup("jms/queue/companyRegister");
        
        connection.start();
        
        publisher = session.createSender(queue);
	}
	
	@Override
	public void sendMessage(Serializable msg) throws JMSException { 
		Message m = session.createObjectMessage(msg);
		publisher.send(m);
	}

	@Override
	public void close() throws JMSException {
		connection.close();
	}

}
