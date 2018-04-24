package com.motek.soa;

import java.io.BufferedReader;  
import java.io.InputStreamReader;
import java.util.Properties;

import javax.naming.*;  
import javax.jms.*;  
  
public class MySender {  
    public static void main(String[] args) {  
        try  
        {   //Create and start connection  
		    Properties props = new Properties();
	        props.put("java.naming.factory.url.pkgs","org.jboss.ejb.client.naming");
            InitialContext ctx=new InitialContext(props);  
            QueueConnectionFactory f=(QueueConnectionFactory)ctx.lookup("jms/RemoteConnectionFactory");  
            QueueConnection con=f.createQueueConnection("iza","obidowa1721");  
            con.start();  
            //2) create queue session  
            QueueSession ses=con.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);  
            //3) get the Queue object  
            Queue t=(Queue)ctx.lookup("jms/queue/test");  
            //4)create QueueSender object         
            QueueSender sender=ses.createSender(t);  
            //5) create TextMessage object  
            TextMessage msg=ses.createTextMessage();    
            //6) write message  
            BufferedReader b=new BufferedReader(new InputStreamReader(System.in));  
            while(true)  
            {  
                System.out.println("Enter Msg, end to terminate:");  
                String s=b.readLine();  
                if (s.equals("end"))  
                    break;  
                msg.setText(s);  
                //7) send message  
                sender.send(msg);  
                System.out.println("Message successfully sent.");  
            }  
            //8) connection close  
            con.close();  
        }catch(Exception e){System.out.println(e);}  
    }  
}  