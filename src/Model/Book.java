package Model;

public class Book {
	
	private String title;
	private Author author;
	private int numberOfPages;
	private boolean isRead;
	// private Date addedDate;
	// private Language language;
	
	/**
	 * @param args
	 */
	public Book(){
		title = null;
		author = new Author();
		numberOfPages = 0;
		isRead = false;
		// date = todaysdate;
		// language = null;
	}
	
	// problem here, everything will be null
	public Book(String title) {
		this();
		this.title = title;		
	}
	
	public Book(String title, Author author) {
		this(title);
		this.author.setName(author.getName());			
	}
	
	public Book(String title, Author author, int numberOfPages) {
		this(title, author);
		this.numberOfPages = numberOfPages;			
	}
	
	public Book(String title, Author author, int numberOfPages, boolean isRead) {
		this(title, author, numberOfPages);
		this.isRead = isRead;			
	}
	
	// getters
	public String getTitle(){
		return title;
	}	
	
	public Author getAuthor(){
		return author;
	}
	
	public int getNumberOfPages(){
		return numberOfPages;
	}
	
	public boolean isRead(){
		return isRead;
	}
	
	// setters
	public void setTitle(String title){
		this.title = title;
	}
	
	public void setAuthor(Author author){
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
