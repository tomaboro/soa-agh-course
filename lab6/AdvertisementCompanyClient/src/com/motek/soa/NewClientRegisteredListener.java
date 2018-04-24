package com.motek.soa;

import java.util.Arrays;
import java.util.HashMap;

import javax.jms.*;  

public class NewClientRegisteredListener implements MessageListener {  
  
    public void onMessage(Message m) {  
        try{  
        ObjectMessage msg = (ObjectMessage) m;  
        HashMap<String,String> map = (HashMap<String,String>) msg.getObject();
        System.out.println("Otrzymałem wiadomość: " + Arrays.asList(map)); 
        }catch(ClassCastException e) {
        	System.out.println("Otzymałem wiadomość ale jej format jest nie obsługiwany");
        }catch(JMSException e){
        	System.out.println(e);
        }  
    }  
}  