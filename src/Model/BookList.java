package Model;

import java.util.ArrayList;
import java.util.List;

public class BookList {

	private List<Book> books;
	
	public BookList() {
		books = new ArrayList<>();
	}
	
	public List<Book> getAllBooks(){		
		return books;
	}
	
	public void setAllBooks(List<Book> books){
		this.books = books;
	}
}
