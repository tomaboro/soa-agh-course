package com.motek.soa.ejb;

import javax.ejb.Remote;

@Remote
public interface BookStoreInfoRemote {
	public String printBookList();
	public String printAvaliableBooks();
	public String printReservedBooks();
	public String printBorrowedBooks();
}
