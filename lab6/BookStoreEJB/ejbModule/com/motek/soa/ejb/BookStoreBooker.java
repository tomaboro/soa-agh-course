package com.motek.soa.ejb;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateful;

import com.motek.soa.jms.JMSNewBookTopicService;
import com.motek.soa.jms.JMSNotificationQueueService;
import com.motek.soa.jms.JMSService;
import com.motek.soa.model.Book;
import com.motek.soa.model.BookNotAvaliableException;
import com.motek.soa.model.OperationFailedException;

/**
 * Session Bean implementation class BookStoreBooker
 */
@Stateful
public class BookStoreBooker implements BookStoreBookerRemote {
	@EJB BookStore store;
	public ArrayList<Integer> borrowedBooks;
	public ArrayList<Integer> reservedBooks;
	
	@PostConstruct
	public void initBookStoreBooker() {
		borrowedBooks = new ArrayList<>();
		reservedBooks = new ArrayList<>();
	}
	
	@Override
	public void addBook(String author, String title, Integer ISBN) throws OperationFailedException {
		 if(!store.addBook(new Book(ISBN,title,author))){
			 throw new OperationFailedException(); 
		 }else {
				JMSService jms = new JMSNewBookTopicService();
				try {
					jms.init();
					jms.sendMessage("Book " + ISBN + "added");
					jms.close();
				} catch(Exception e) {
					e.printStackTrace();
				}
		 }
	}
	
	@Override
	public void borrow(Integer ISBN) throws BookNotAvaliableException {
		if(store.isReserved(ISBN) && store.borrowBook(ISBN)) {
			borrowedBooks.add(ISBN);
			JMSService jms = new JMSNotificationQueueService();
			try {
				jms.init();
				jms.sendMessage("Book " + ISBN + "is borrowed");
				jms.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		else {
			throw new BookNotAvaliableException();
		}
	}

	@Override
	public void reserve(Integer ISBN) throws BookNotAvaliableException {
		if(store.reserveBook(ISBN)) {
			reservedBooks.add(ISBN);
			JMSNotificationQueueService jms = new JMSNotificationQueueService();
			try {
				jms.init();
				jms.sendMessage("Book " + ISBN + "is reserved");
				jms.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		else {
			throw new BookNotAvaliableException();
		}
	}

	@Override
	public void giveBack(Integer ISBN) throws BookNotAvaliableException {
		if(borrowedBooks.contains(ISBN) && store.returnBook(ISBN)) {
			borrowedBooks.remove(ISBN);
			JMSNotificationQueueService jms = new JMSNotificationQueueService();
			try {
				jms.init();
				jms.sendMessage("Book " + ISBN + "is returned");
				jms.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		else {
			throw new BookNotAvaliableException();
		}
	}

}
