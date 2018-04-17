package com.motek.soa;

import java.util.Properties;
import java.util.Scanner;

import javax.naming.InitialContext;

import com.motek.soa.ejb.*;
import com.motek.soa.model.BookNotAvaliableException;

public class Main {
	public static void main(String[] args) {   
		try {
		Properties props = new Properties();
        props.put("java.naming.factory.url.pkgs","org.jboss.ejb.client.naming");
        InitialContext context = new InitialContext(props);

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
        	int num = in.nextInt();
        	switch(num) {
        		case 1:
        			System.out.println(info.printBookList());
        			break;
        		case 2:
        			System.out.println(info.printAvaliableBooks());
        			break;
        		case 3:
        			System.out.println("Podaj numer ISBN ksiazki:");
        			int num2 = in.nextInt();
        			try {
        				booker.borrow(num2);
        			}catch(BookNotAvaliableException e) {
        				System.out.println("Ta ksiazka nie jest dostepna");
        			}
        			break;
        		case 4:
        			System.out.println("Podaj numer ISBN ksiazki:");
        			int num3 = in.nextInt();
        			try {
        				booker.reserve(num3);
        			}catch(BookNotAvaliableException e) {
        				System.out.println("Ta ksiazka nie jest dostepna");
        			}
        		case 5:
        			System.out.println("Podaj numer ISBN ksiazki:");
        			int num4 = in.nextInt();
        			try {
        				booker.giveBack(num4);
        			}catch(BookNotAvaliableException e) {
        				System.out.println("Nie posiadasz tej ksiazki");
        			}
        			break;
        		case 6:
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
		System.out.println("6. Zakończ działanie");
		System.out.println("Podaj numer komendy: ");
	}
	
}
