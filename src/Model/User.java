package Model;



public class User {

	private BookList bookList;
	private DBHandler dbHandler;
	
	public User(){
		bookList = new BookList();
		dbHandler = new DBHandler();
	}
	
	public User(BookList bookList){
		this();
		this.bookList = bookList;
	}
	
	public void addBook(String title, Author author, int numberOfPages, boolean isRead){
		bookList.addBook(new Book(title, author, numberOfPages, isRead));
	}

	
	
	public String findBookByTitle(String title){
		return bookList.findBookByTitle(title).toString();
	}
	
	public String findBooksByAuthor(String author){
		return bookList.findBooksByAuthor(author).toString();			
	}
	
	public void removeBook(String bookToRemove){
		bookList.removeBook(bookToRemove);
	}
	
	public String getAllTitles(){
		return bookList.getAllTitles().toString();
	}
}
