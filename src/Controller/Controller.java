package Controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Model.Author;
import Model.Book;
import Model.BookList;
import Model.DBHandler;

public class Controller {
	
	private BookList bookList;
	private DBHandler dbHandler;
	
	public Controller(){
		bookList = new BookList();
		dbHandler = new DBHandler();
	}
	
	public BookList getBookList(){
		return bookList;
	} 
	
	public void setBookList(BookList bookList){
		this.bookList = bookList;
	}	
	
	public void addBook(String title, String authorName, int numberOfPages, boolean isRead){
		Author author = new Author(authorName);
		Book book = new Book(title, author, numberOfPages, isRead);
		bookList.getAllBooks().add(book);
	}
	
	public void removeBook(String bookToRemove){
		Iterator<Book> it = bookList.getAllBooks().iterator();
		while(it.hasNext()) {
			Book book = it.next();
		    if(bookToRemove.equals(book.getTitle())){
		    	it.remove();
		    }
		}
	}
	
	public List<Book> getAllBooks(){		
		return bookList.getAllBooks();
	}
	
	public List<Book> getReadBooks(){
		List<Book> readBooks = new ArrayList<>();
		for(Book book : bookList.getAllBooks()){
			if(book.isRead() == true){				
				readBooks.add(book);
			}
		}
		return readBooks;
	}
	
	public List<Book> getUnreadBooks(){
		List<Book> unreadBooks = new ArrayList<>();
		for(Book book : bookList.getAllBooks()){
			if(book.isRead() == false){				
				unreadBooks.add(book);
			}
		}
		return unreadBooks;
	}
	
	public Book findBook(Book bookSearched){
		String titleSearched = bookSearched.getTitle();
		return findBookByTitle(titleSearched);
	}
	
	public Book findBookByTitle(String title){
		for(Book book : bookList.getAllBooks()){
			if(title.equals(book.getTitle())){
				return book;
			}
		}
		return null;
	}
	
	public List<Book> findBooksByAuthor(String author){
		List<Book> booksByAuthor = new ArrayList<>();
		for(Book book : bookList.getAllBooks()){
			if(author.equals(book.getAuthor().getName())){
				booksByAuthor.add(book);
			}
		}
		if(booksByAuthor.isEmpty())
			return null;
		return booksByAuthor;
	}	
}
