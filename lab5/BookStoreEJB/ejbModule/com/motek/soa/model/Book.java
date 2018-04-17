package com.motek.soa.model;

public class Book {
	private int ISBN;
	private String title;
	private String author;
	
	private boolean reserved;
	private boolean borrowed;

	public Book(int ISBN, String title, String author) {
		this.ISBN = ISBN;
		this.title = title;
		this.author = author;
		this.reserved = false;
		this.borrowed = false;
	}
		
	public boolean isReserved() {
		return reserved;
	}

	public void setReserved(boolean reserved) {
		this.reserved = reserved;
	}

	public boolean isBorrowed() {
		return borrowed;
	}

	public void setBorrowed(boolean borrowed) {
		this.reserved = borrowed;
		this.borrowed = borrowed;
	}

	public int getISBN() {
		return ISBN;
	}

	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
}
