package Model;

import java.util.ArrayList;
import java.util.List;

public class BookList {

	private List<Book> books;
	/**
	 * @param args
	 */
	public BookList() {
		books = new ArrayList<>();
	}
	
	public List<Book> getAllBooks(){		
		return books;
	}
}
