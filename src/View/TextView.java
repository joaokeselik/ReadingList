package View;


import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import Controller.Controller;


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
		commands.put("h", Command.HELP);	
		commands.put("q", Command.QUIT);		
	}
	
	
	private void readCommand(){
		Scanner reader = new Scanner(System.in);
		
		do{
			
			do{
				String commandLetter = reader.next();
				command = commands.get(commandLetter);
				if(command == null)
					System.out.println("Write a valid command");			
			}while(command == null);
			
			switch(command){
				case ADDBOOK:
			        System.out.println("ADD: ");
			        addBook(reader);
			        break;
			            
			    case LISTALLBOOKS:
			        System.out.println("ALLBOOKS: ");
			        listAllBooks();
			        break;
			                 
			    case LISTREADBOOKS: 
			        System.out.println("READBOOKS: ");
			        listReadBooks();
			        break;
			        
			    case LISTUNREADBOOKS: 
			        System.out.println("UNREADBOOKS: ");
			        listUnreadBooks();
			        break;
			        
			    case SEARCHBYTITLE: 
			        System.out.println("SEARCHBYTITLE: ");
			        //searchByTitle();
			        break;
			        
			    case SEARCHBYAUTHOR: 
			        System.out.println("SEARCHBYAUTHOR: ");
			        //searchByAuthor();
			        break;
			        
			    case REMOVEBOOK: 
			        System.out.println("REMOVE: ");
			        removeBook(reader);
			        break;
			    
			    case HELP: 
			        System.out.println("HELP: ");
			        help();
			        break;			    
			                
			    default:
			        System.out.println("GoodBye");
			        break;
			}
		}while(command != Command.QUIT);
		
		reader.close(); 
	}
	
	private void addBook(Scanner scan){	
		System.out.println("Title: ");
		String title = scan.next();		
				
		System.out.println("Author: ");
		String authorName = scan.next();
		
		
		System.out.println("Number of pages: ");		
		int numberOfPages = scan.nextInt();
				
		boolean isRead = false;
		System.out.println("Read (0) or Unread (any number): ");
		int isReadInt = scan.nextInt();
		if(isReadInt == 0)
			isRead = true;		
		
		controller.addBook(title, authorName, numberOfPages, isRead);		
	}
	
	private void listAllBooks(){
		System.out.println(listToString(controller.getAllBooks()));
	}
	
	private void listReadBooks(){
		System.out.println(listToString(controller.getReadBooks()));
	}
	
	private void listUnreadBooks(){
		System.out.println(listToString(controller.getUnreadBooks()));
	}
	
	private void removeBook(Scanner scan){
		System.out.println("Book to remove: ");
		String bookToRemove = scan.next();	
		controller.removeBook(bookToRemove);
	}
	
	private void help(){
		System.out.println("Choose an option: ");
		System.out.println("a - Add book ");
		System.out.println("l - List all books ");
		System.out.println("r - List read books ");
		System.out.println("u - List unread books ");
		System.out.println("t - Search book by title ");
		System.out.println("s - Search book by author ");
		System.out.println("x - Remove book ");	
		System.out.println("h - Help ");	
		System.out.println("q - Quit ");		 
		System.out.println("Enter a command: ");		
	}
	
	private String listToString(List<?> list) {
	    String listToString = "";
	    for (int i = 0; i < list.size(); i++) {
	    	listToString += list.get(i) + "\n";
	    }
	    return listToString;
	}

}
