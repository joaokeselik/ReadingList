package Model;

import java.util.HashMap;
import java.util.Scanner;

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
	
	private void help(){
		System.out.println("Choose an option: ");
		System.out.println("a - Add book ");
		System.out.println("l - List all books ");
		System.out.println("r - List read books ");
		System.out.println("u - List unread books ");
		System.out.println("t - Search book by title ");
		System.out.println("s - Search book by author ");
		System.out.println("q - Quit ");		 
		System.out.println("Enter a command: ");		
	}
	
	private void fillCommands(){
		commands.put("a", command.ADD);
		commands.put("l", command.ALLBOOKS);
		commands.put("r", command.READBOOKS);
		commands.put("u", command.UNREADBOOKS);
		commands.put("t", command.SEARCHBYTITLE);
		commands.put("s", command.SEARCHBYAUTHOR);
		commands.put("q", command.QUIT);		
	}
	
	
	private void readCommand(){
		Scanner reader = new Scanner(System.in);
		
		do{
			
			String commandLetter = reader.next();
			command = commands.get(commandLetter);
						
			switch(command){
				case ADD:
			        System.out.println("ADD: ");
			        addBook();
			        break;
			            
			    case ALLBOOKS:
			        System.out.println("ALLBOOKS: ");
			        //allBooks();
			        break;
			                 
			    case READBOOKS: 
			        System.out.println("READBOOKS: ");
			        //readBooks();
			        break;
			        
			    case UNREADBOOKS: 
			        System.out.println("UNREADBOOKS: ");
			        //unreadBooks();
			        break;
			                
			    /*default:
			        System.out.println("Midweek days are so-so.");
			        break;*/
			}
		}while(command != Command.QUIT);
		
		
		reader.close(); 
	}
	
	public void addBook(){
		// read all inputs: String title, Author author, int numberOfPages, boolean isRead
		// controller.getUser().addBook(title, author, numberOfPages, isRead);
	}

}
