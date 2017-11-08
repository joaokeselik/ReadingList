package Controller;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import Model.Book;


public class DBHandler {
        
    private String splitStr;    
    
    public DBHandler(){
    	splitStr = ",";
    	
    }     
    
    public List<Book> importCSVToBookList(String filePath){
        List<Book> bookList = new ArrayList<Book>();
        
		try(Scanner scan = new Scanner(new File(filePath))){
			while (scan.hasNextLine()) {
	            String line = scan.nextLine();
	            String[] lineArray = line.split(splitStr);
	            int numberOfPages = Integer.parseInt(lineArray[2]);
	            boolean isRead = Boolean.parseBoolean(lineArray[3]);
	            bookList.add(new Book(lineArray[0], lineArray[1], numberOfPages, isRead));
	        }
		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}        
        
        return bookList;
    }   
    
    // writing everything in the same column, have to parse title-author-pages-isread
    //have to pass a list instead of a string as a parameter and parse the list in the method body
    public void exportBookListToCSV(String filePath, String bookListToCSV){
    	String input = bookListToCSV;
        //input = input.substring(1, input.length() - 1); // get rid of brackets
        String[] split = input.split(" ");

        
		try(FileWriter writer = new FileWriter(filePath)){			
			for(String s : split) {
	            String[] split2 = s.split(",");
	            writer.write(Arrays.asList(split2).stream().collect(Collectors.joining(",")));
	            writer.write("\n"); 
	        }

		} catch (IOException e) {
			e.printStackTrace();
		}       
        
    }
    
}
	
	

