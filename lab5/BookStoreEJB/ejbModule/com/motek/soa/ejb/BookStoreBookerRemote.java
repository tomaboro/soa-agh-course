package com.motek.soa.ejb;

import javax.ejb.Remote;

import com.motek.soa.model.BookNotAvaliableException;

@Remote
public interface BookStoreBookerRemote {
	public void borrow(Integer ISBN) throws BookNotAvaliableException;
	public void reserve(Integer ISBN) throws BookNotAvaliableException;
	public void giveBack(Integer ISBN) throws BookNotAvaliableException;
}
