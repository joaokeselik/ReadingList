package Controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import Model.Book;
import Model.BookList;

public class Controller {
	
	private BookList bookList;
	private DBHandler dbHandler;
	private String filepath;
	
	public Controller(){
		bookList = new BookList();
		dbHandler = new DBHandler();
		filepath = "C:\\Users\\Joao\\ReadingList\\src\\Model\\booklist.json";
		bookList.setAllBooks(dbHandler.importJsonToBookList(filepath));
	}
	
	public BookList getBookList(){
		return bookList;
	} 
	
	public void setBookList(BookList bookList){
		this.bookList = bookList;
	}	
	
	public void addBook(String title, String author, int numberOfPages, boolean isRead){		
		Book book = new Book(title, author, numberOfPages, isRead);
		bookList.getAllBooks().add(book);

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
	
	public List<Book> searchBooksByTitle(String title){
		List<Book> booksByTitle = new ArrayList<>();
		for(Book book : bookList.getAllBooks()){
			if(title.equals(book.getTitle())){
				booksByTitle.add(book);
			}
		}
		if(booksByTitle.isEmpty())
			return null;
		return booksByTitle;
	}
	
	public List<Book> searchBooksByAuthor(String author){
		List<Book> booksByAuthor = new ArrayList<>();
		for(Book book : bookList.getAllBooks()){
			if(author.equals(book.getAuthor())){
				booksByAuthor.add(book);
			}
		}
		if(booksByAuthor.isEmpty())
			return null;
		return booksByAuthor;
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

	public void saveBookList(){
		dbHandler.exportBookListToJson(filepath, bookList.getAllBooks());
	}
	
}
