package Model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookList {

	private List<Book> books;
	/**
	 * @param args
	 */
	public BookList() {
		books = new ArrayList<Book>();
	}
	
	public void addBook(Book book){
		books.add(book);
	}
	
	public void removeBook(Book bookToRemove){
		Iterator<Book> it = books.iterator();
		while(it.hasNext()) {
			Book book = it.next();
		    if(book == bookToRemove){
		    	it.remove();
		    }
		}
	}
	
	public List<String> getAllTitles(){
		List<String> titles = new ArrayList<>();
		for(Book book : books){
			String title = book.getTitle();
			titles.add(title);
		}
		return titles;
	}
	
	public Book findBook(Book bookSearched){
		for(Book book : books){
			if(bookSearched.getTitle().equals(book.getTitle())){
				return book;
			}
		}
		return null;
	}
	
	public Book findBookByTitle(String title){
		for(Book book : books){
			if(title.equals(book.getTitle())){
				return book;
			}
		}
		return null;
	}
	
	public Book findBookByAuthor(Author author){
		for(Book book : books){
			if(author == book.getAuthor()){
				return book;
			}
		}
		return null;
	}

}
