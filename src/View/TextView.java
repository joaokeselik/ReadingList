package View;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import Controller.Controller;
import Model.Book;

public class TextView {
	private Controller controller;
	private Command command;
	private HashMap<String, Command> commands;
	
	public TextView(){
		controller = new Controller();
		command = null;
		commands = new HashMap<>();		
	}
	
	public void startUp(){
		help();
		fillCommands();
		readCommand();
	}	
	
	private void fillCommands(){
		commands.put("a", Command.ADDBOOK);
		commands.put("l", Command.LISTALLBOOKS);
		commands.put("r", Command.LISTREADBOOKS);
		commands.put("u", Command.LISTUNREADBOOKS);
		commands.put("t", Command.SEARCHBYTITLE);
		commands.put("s", Command.SEARCHBYAUTHOR);
		commands.put("x", Command.REMOVEBOOK);
		commands.put("w", Command.SAVE);
		commands.put("h", Command.HELP);	
		commands.put("q", Command.QUIT);		
	}
	
	private void readCommand(){
		Scanner reader = new Scanner(System.in);
		
		do{
			do{
				String commandLetter = reader.nextLine();
				command = commands.get(commandLetter);
				if(command == null)
					System.out.println("Enter a valid command");
			}while(command == null);
			
			switch(command){
				case ADDBOOK:
			        System.out.println("ADDBOOK:");
			        addBook(reader);
			        break;
			            
			    case LISTALLBOOKS:
			        System.out.println("ALLBOOKS:");
			        listAllBooks();
			        break;
			                 
			    case LISTREADBOOKS: 
			        System.out.println("READBOOKS:");
			        listReadBooks();
			        break;
			        
			    case LISTUNREADBOOKS: 
			        System.out.println("UNREADBOOKS:");
			        listUnreadBooks();
			        break;
			        
			    case SEARCHBYTITLE: 
			        System.out.println("SEARCHBYTITLE:");
			        searchByTitle(reader);
			        break;
			        
			    case SEARCHBYAUTHOR: 
			        System.out.println("SEARCHBYAUTHOR:");
			        searchByAuthor(reader);
			        break;
			        
			    case REMOVEBOOK:
			        System.out.println("REMOVE:");
			        removeBook(reader);
			        break;

				case SAVE:
					System.out.println("SAVED!");
					save();
					break;

			    case HELP: 
			        System.out.println("HELP:");
			        help();
			        break;			    
			                
			    default:
			        System.out.println("GOODBYE!");
			        break;
			}
		}while(command != Command.QUIT);
		
		reader.close(); 
	}
	
	private void addBook(Scanner scan){	
		System.out.println("Title: ");
		String title = scan.nextLine();
				
		System.out.println("Author: ");
		String authorName = scan.next();
		
		System.out.println("Number of pages: ");		
		int numberOfPages = scan.nextInt();
				
		System.out.println("Read(True) or Unread(False): ");
		boolean isRead = Boolean.parseBoolean(scan.next());
		
		controller.addBook(title, authorName, numberOfPages, isRead);
		scan.nextLine();
	}
	
	private void listAllBooks(){
		System.out.println(convertBookListToString(controller.getAllBooks()));
	}
	
	private void listReadBooks(){
		System.out.println(convertBookListToString(controller.getReadBooks()));
	}

	private void listUnreadBooks(){
		System.out.println(convertBookListToString(controller.getUnreadBooks()));
	}

	private void searchByTitle(Scanner scan){
		System.out.println("Title: ");
		String bookToSearchByTitle = scan.next();
		System.out.println(convertBookListToString(controller.searchBooksByTitle(bookToSearchByTitle)));
		scan.nextLine();
	}

	private void searchByAuthor(Scanner scan){
		System.out.println("Author: ");
		String bookToSearchByAuthor = scan.next();
		System.out.println(convertBookListToString(controller.searchBooksByAuthor(bookToSearchByAuthor)));
		scan.nextLine();
	}
	
	private void removeBook(Scanner scan){
		System.out.println("Book to remove: ");
		String bookToRemove = scan.next();	
		controller.removeBook(bookToRemove);
		scan.nextLine();
	}
	
	private void help(){
		System.out.println("Choose an option:");
		System.out.println("a - Add book");
		System.out.println("l - List all books");
		System.out.println("r - List read books");
		System.out.println("u - List unread books");
		System.out.println("t - Search book by title");
		System.out.println("s - Search book by author");
		System.out.println("x - Remove book");
		System.out.println("w - Save");
		System.out.println("h - Help");
		System.out.println("q - Quit");
		System.out.println("Enter a command:");
	}

	private void save(){
		controller.saveBookList();
	}
	
	private String convertBookListToString(List<Book> bookListToString){
		String bookListStr = "";
		System.out.println(String.format("%-40s %-20s %-7s %5s","Title", "Author", "Pages", "Read"));
		System.out.println("---------------------------------------------------------------------------");
	    for(Book book : bookListToString){
	    	String title = book.getTitle();
	    	String author = book.getAuthor();
	    	int numberOfPages = book.getNumberOfPages();
	    	String isRead = Boolean.toString(book.isRead());	    	
	    	
	    	bookListStr += String.format("%-40s %-20s %-7s %5s\n", title, author, numberOfPages, isRead);
	    }
	    return bookListStr;
	}
}
