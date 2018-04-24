package com.motek.soa.ejb;

import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.ejb.Lock;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import static javax.ejb.LockType.READ;
import static javax.ejb.LockType.WRITE;

import com.motek.soa.model.Book;

@Singleton
@Startup
public class BookStore {
	private ArrayList<Book> bookList = new ArrayList<>();

	@PostConstruct
	public void initBookStore(){
		try {
			URL url = new URL("http://localhost:8080/TempConverterClient/books.xml");
			URLConnection conn = url.openConnection();
	        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	        Document doc = dBuilder.parse(conn.getInputStream());
	        doc.getDocumentElement().normalize();
	        NodeList nList = doc.getElementsByTagName("book");
	        
	        for (int temp = 0; temp < nList.getLength(); temp++) {
	        	Node nNode = nList.item(temp);
	        	if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	        		Element eElement = (Element) nNode;
	        		bookList.add(new Book(
	        				Integer.parseInt(eElement.getElementsByTagName("ISBN").item(0).getTextContent()),
	        				eElement.getElementsByTagName("name").item(0).getTextContent(),
	        				eElement.getElementsByTagName("author").item(0).getTextContent()));
	        	}
	        	
	        }
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Lock(WRITE)
	public void addBook(int ISBN, String title, String author) {
		bookList.add(new Book(ISBN,title,author));
	}
	
	@Lock(READ)
	public ArrayList<Book> getBooksList(){
		return bookList;
	}

	@Lock(WRITE)
	public boolean borrowBook(int ISBN) {
		Book book = findBook(ISBN);
		if(book != null && !book.isBorrowed()) {
			book.setBorrowed(true);
			return true;
		}
		else {
			return false;
		}
	}
	
	@Lock(READ)
	public boolean isReserved(int ISBN) {
		Book book = findBook(ISBN);
		if(book == null) return false;
		else return book.isReserved();
	}
	
	@Lock(WRITE)
	public boolean reserveBook(int ISBN) {
		Book book = findBook(ISBN);
		if(book != null && !book.isReserved()) {
			book.setReserved(true);
			return true;
		}
		else {
			return false;
		}
	}
	
	@Lock(WRITE)
	public boolean returnBook(int ISBN) {
		Book book = findBook(ISBN);
		if(book != null && book.isBorrowed()) {
			book.setBorrowed(false);
			return true;
		}
		else {
			return false;
		}
	}
	
	@Lock(WRITE)
	public boolean addBook(Book book) {
		if(!bookList.contains(book)) {
			bookList.add(book);
			return true;
		}else {
			return false;
		}
	}
	
	private Book findBook(int ISBN) {
		for(Book book: bookList) {
			if(book.getISBN() == ISBN) return book;
		}
		return null;
	}
	
}
