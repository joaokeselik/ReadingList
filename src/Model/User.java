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
	
}
