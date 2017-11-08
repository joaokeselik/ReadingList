package Controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Model.Book;
import Model.BookList;

public class Controller {
	
	private BookList bookList;
	private DBHandler dbHandler;
	private String filePath;
	
	public Controller(){
		bookList = new BookList();
		dbHandler = new DBHandler();
		filePath = "/afs/kth.se/home/tmp/1016/tmp-sda-1110/workspace/ReadingList/src/Model/booklist.csv";
		bookList.setAllBooks(dbHandler.importCSVToBookList(filePath));		
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
		//dbHandler.exportBookListToCSV(filePath, convertBookListToString(getAllBooks()));
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
			if(author.equals(book.getAuthor())){
				booksByAuthor.add(book);
			}
		}
		if(booksByAuthor.isEmpty())
			return null;
		return booksByAuthor;
	}	
	
	public String convertBookListToString(List<Book> bookListToString){
		String bookListStr = "";
	    for(Book book : bookListToString){
	    	String title = book.getTitle();
	    	String author = book.getAuthor();
	    	int numberOfPages = book.getNumberOfPages();
	    	String isRead = Boolean.toString(book.isRead());
	    	
	    	bookListStr += title + " " + author + " " + numberOfPages + " pages " + isRead + "\n";
	    }
	    return bookListStr;
	}
}
