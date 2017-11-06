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
		books = new ArrayList<>();
	}
	
	public void addBook(Book book){
		books.add(book);
	}
	
	public void removeBook(String bookToRemove){
		Iterator<Book> it = books.iterator();
		while(it.hasNext()) {
			Book book = it.next();
		    if(bookToRemove.equals(book.getTitle())){
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
		String titleSearched = bookSearched.getTitle();
		return findBookByTitle(titleSearched);
	}
	
	public Book findBookByTitle(String title){
		for(Book book : books){
			if(title.equals(book.getTitle())){
				return book;
			}
		}
		return null;
	}
	
	public List<Book> findBooksByAuthor(String author){
		List<Book> booksByAuthor = new ArrayList<>();
		for(Book book : books){
			if(author.equals(book.getAuthor().getName())){
				booksByAuthor.add(book);
			}
		}
		if(booksByAuthor.isEmpty())
			return null;
		return booksByAuthor;
	}
	
	public String toString(){
		String listOfBooks = "";
		for(Book book : books){
			listOfBooks += book.toString() + "\n";
		}
		return listOfBooks;
	}

}
