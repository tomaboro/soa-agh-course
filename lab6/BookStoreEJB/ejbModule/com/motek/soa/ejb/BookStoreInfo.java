package com.motek.soa.ejb;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.motek.soa.model.Book;

/**
 * Session Bean implementation class BookStoreInfo
 */
@Stateless
@LocalBean
public class BookStoreInfo implements BookStoreInfoRemote {

	@EJB BookStore store;

	@Override
	public String printBookList() {
		String result = "";
		for(Book book : store.getBooksList()) {
			result = result  + "[" + book.getISBN() + "] " + book.getTitle()+"-"+book.getAuthor()+"\n";
		}
		return result;
	}

	@Override
	public String printAvaliableBooks() {
		String result = "";
		for(Book book : store.getBooksList()) {
			if(!book.isReserved()) result = result  + "[" + book.getISBN() + "] " + book.getTitle()+"-"+book.getAuthor()+"\n";
		}
		return result;
	}

	@Override
	public String printReservedBooks() {
		String result = "";
		for(Book book : store.getBooksList()) {
			if(book.isReserved()) result = result  + "[" + book.getISBN() + "] " + book.getTitle()+"-"+book.getAuthor()+"\n";
		}
		return result;
	}

	@Override
	public String printBorrowedBooks() {
		String result = "";
		for(Book book : store.getBooksList()) {
			if(book.isBorrowed()) result = result + "[" + book.getISBN() + "] " + book.getTitle()+"-"+book.getAuthor()+"\n";
		}
		return result;
	}

}
