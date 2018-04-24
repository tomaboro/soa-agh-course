package com.motek.soa;

import java.util.Properties;
import java.util.Scanner;

import javax.jms.JMSException;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;
import javax.jms.Session;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.motek.soa.ejb.*;
import com.motek.soa.model.BookNotAvaliableException;
import com.motek.soa.model.OperationFailedException;

public class Main {
	public static void initNotificationListener() throws NamingException, JMSException {
	    Properties props = new Properties();
        props.put("java.naming.factory.url.pkgs","org.jboss.ejb.client.naming");
        InitialContext ctx = new InitialContext(props);
        TopicConnectionFactory f=(TopicConnectionFactory)ctx.lookup("jms/RemoteConnectionFactory");  
        TopicConnection con=f.createTopicConnection("iza","obidowa1721");  
        con.start();  
        //2) create Topic session  
        TopicSession ses=con.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);  
        //3) get the Topic object  
        Topic t=(Topic)ctx.lookup("jms/topic/newBookTopic");  
        //4)create TopicReceiver  
        TopicSubscriber receiver=ses.createSubscriber(t);  
          
        //5) create listener object  
        NotificationListener listener=new NotificationListener();  
          
        //6) register the listener object with receiver  
        receiver.setMessageListener(listener);  
	}
	
	public static void main(String[] args) {   
		try {
		Properties props = new Properties();
        props.put("java.naming.factory.url.pkgs","org.jboss.ejb.client.naming");
        InitialContext context = new InitialContext(props);

        initNotificationListener();
        
        String appName = "";        	 
        String moduleName = "BookStoreEJB";
        String distinctName = "";        	 
        String beanName = BookStoreInfo.class.getSimpleName();        	 
        String interfaceName = BookStoreInfoRemote.class.getName();
        String name = "ejb:" + appName + "/" + moduleName + "/" +  distinctName    + "/" + beanName + "!" + interfaceName;
        BookStoreInfoRemote info = (BookStoreInfoRemote)context.lookup(name);
        beanName = BookStoreBooker.class.getSimpleName();
        interfaceName = BookStoreBookerRemote.class.getName();
        name = "ejb:" + appName + "/" + moduleName + "/" +  distinctName    + "/" + beanName + "!" + interfaceName + "?stateful";
        BookStoreBookerRemote booker = (BookStoreBookerRemote)context.lookup(name);
        
        Scanner in = new Scanner(System.in);
        while(true) {
        	printPrompt();
        	int num = Integer.parseInt(in.nextLine());
        	switch(num) {
        		case 1:
        			System.out.println(info.printBookList());
        			break;
        		case 2:
        			System.out.println(info.printAvaliableBooks());
        			break;
        		case 3:
        			System.out.println("Podaj numer ISBN ksiazki:");
        			int num2 = Integer.parseInt(in.nextLine());
        			try {
        				booker.borrow(num2);
        			}catch(BookNotAvaliableException e) {
        				System.out.println("Ta ksiazka nie jest dostepna");
        			}
        			break;
        		case 4:
        			System.out.println("Podaj numer ISBN ksiazki:");
        			int num3 = Integer.parseInt(in.nextLine());
        			try {
        				booker.reserve(num3);
        			}catch(BookNotAvaliableException e) {
        				System.out.println("Ta ksiazka nie jest dostepna");
        			}
        			break;
        		case 5:
        			System.out.println("Podaj numer ISBN ksiazki:");
        			int num4 = Integer.parseInt(in.nextLine());
        			try {
        				booker.giveBack(num4);
        			}catch(BookNotAvaliableException e) {
        				System.out.println("Nie posiadasz tej ksiazki");
        			}
        			break;
        		case 6:
        			System.out.println("Podaj numer ISBN ksiazki:");
        			int num5 = Integer.parseInt(in.nextLine());
        			System.out.println("Podaj tytul ksiazkie");
        			String str1 = in.nextLine();
        			System.out.println("Podaj autora ksiazki");
        			String str2 = in.nextLine();
        			
        			try {
        				booker.addBook(str1,str2,num);
        			}catch(OperationFailedException e) {
        				System.out.println("Taka ksiazka juz istnieje");
        			}
        			break;
        		case 9:
        			in.close();
        			return;
        	}
        }
        
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void printPrompt() {
		System.out.println("Co chcesz zrobić ?");
		System.out.println("1. Wyświetl wszystkie pozycje w bibliotece");
		System.out.println("2. Wyświetl dostępne pozycje w bibliotece");
		System.out.println("3. Wypożycz ksiazke");
		System.out.println("4. Zarezerwuj książkę");
		System.out.println("5. Zwróć książkę");
		System.out.println("6. Dodaj książkę");
		System.out.println("9. Zakończ działanie");
		System.out.println("Podaj numer komendy: ");
	}
	
}
