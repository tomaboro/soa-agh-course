package com.motek.soa.ejb;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateful;

import com.motek.soa.model.BookNotAvaliableException;

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
	public void borrow(Integer ISBN) throws BookNotAvaliableException {
		if(store.isReserved(ISBN) && store.borrowBook(ISBN)) {
			borrowedBooks.add(ISBN);
		}
		else {
			throw new BookNotAvaliableException();
		}
	}

	@Override
	public void reserve(Integer ISBN) throws BookNotAvaliableException {
		if(store.reserveBook(ISBN)) {
			reservedBooks.add(ISBN);
		}
		else {
			throw new BookNotAvaliableException();
		}
	}

	@Override
	public void giveBack(Integer ISBN) throws BookNotAvaliableException {
		if(borrowedBooks.contains(ISBN) && store.returnBook(ISBN)) {
			borrowedBooks.remove(ISBN);
		}
		else {
			throw new BookNotAvaliableException();
		}
	}

}
