package com.motek.soa;

import java.util.Scanner;

public class Main {
	public static void printPrompt() {
		System.out.println("Podaj komende: ");
		System.out.println("1.Subsktybuj temat");
		System.out.println("2.Wyślij prywatną wiadomość");
		System.out.println("3.Wyślij wiadomość do tematu");
		System.out.println("4.Zamknij");
	}
	
	public static void main(String[] args) {
		try {
			Scanner in = new Scanner(System.in);
			System.out.println("Podaj swoje id: ");
			String id = in.nextLine();
			 
			ConnectionManager cm = new ConnectionManager(id);
			
			while(true) {
				printPrompt();
				switch(Integer.parseInt(in.nextLine())) {
					case 1:
						System.out.println("Podaj ID tematu: ");
						cm.addTopic(in.nextLine());
						break;
					case 2:
						System.out.println("Podaj ID użytkownika: ");
						String uID = in.nextLine();
						System.out.println("Podaj wiadomosc: ");
						String pMsg = in.nextLine();
						cm.sendPrivateMessage(uID, pMsg);
						break;
					case 3:
						System.out.println("Podaj ID tematu: ");
						String tID = in.nextLine();
						System.out.println("Podaj wiadomosc: ");
						String tMsg = in.nextLine();
						cm.sendTopicMessage(tID, tMsg);
						break;
					case 4:
						in.close();
						System.exit(0);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
