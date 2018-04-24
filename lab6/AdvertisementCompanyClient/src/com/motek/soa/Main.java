package com.motek.soa;

import java.util.Properties;

import javax.jms.*;  
import javax.naming.InitialContext;  
  
public class Main {  
    public static void main(String[] args) {  
        try{  
		    Properties props = new Properties();
	        props.put("java.naming.factory.url.pkgs","org.jboss.ejb.client.naming");
	        InitialContext ctx = new InitialContext(props);
            QueueConnectionFactory f=(QueueConnectionFactory)ctx.lookup("jms/RemoteConnectionFactory");  
            QueueConnection con=f.createQueueConnection("iza","obidowa1721");  
            con.start();  
            QueueSession ses=con.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);   
            Queue t=(Queue)ctx.lookup("jms/queue/companyRegister");    
            QueueReceiver receiver=ses.createReceiver(t);   
            NewClientRegisteredListener listener=new NewClientRegisteredListener();  
            receiver.setMessageListener(listener);   
            while(true){                  
                Thread.sleep(100);  
            }  
        }catch(Exception e){
        	e.printStackTrace();
        }  
    }  
  
}  
