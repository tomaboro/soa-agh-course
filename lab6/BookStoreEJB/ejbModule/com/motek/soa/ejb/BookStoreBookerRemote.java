package com.motek.soa.ejb;

import javax.ejb.Remote;

import com.motek.soa.model.BookNotAvaliableException;
import com.motek.soa.model.OperationFailedException;

@Remote
public interface BookStoreBookerRemote {
	public void borrow(Integer ISBN) throws BookNotAvaliableException;
	public void reserve(Integer ISBN) throws BookNotAvaliableException;
	public void giveBack(Integer ISBN) throws BookNotAvaliableException;
	public void addBook(String title, String author, Integer ISBN) throws OperationFailedException;
}
