package Model;

public class Book {
	
	private String title;
	private String author;
	private int numberOfPages;
	private boolean isRead;
	// private Date addedDate;


	public Book(){
		title = null;
		author = null;
		numberOfPages = 0;
		isRead = false;
		// date = todaysdate;
	}	
	
	public Book(String title) {
		this();
		this.title = title;		
	}
	
	public Book(String title, String author) {
		this(title);
		this.author = author;			
	}
	
	public Book(String title, String author, int numberOfPages) {
		this(title, author);
		this.numberOfPages = numberOfPages;			
	}
	
	public Book(String title, String author, int numberOfPages, boolean isRead) {
		this(title, author, numberOfPages);
		this.isRead = isRead;			
	}
	
	public String getTitle(){
		return title;
	}	
	
	public String getAuthor(){
		return author;
	}
	
	public int getNumberOfPages(){
		return numberOfPages;
	}
	
	public boolean isRead(){
		return isRead;
	}

	public void setTitle(String title){
		this.title = title;
	}
	
	public void setAuthor(String author){
		this.author = author;
	}
	
	public void setNumberOfPages(int numberOfPages){
		this.numberOfPages = numberOfPages;
	}
	
	public void setIsRead(){
		if(isRead == false)
			isRead = true;
		else
			isRead = false;
	}
	

}
