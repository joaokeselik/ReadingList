package Controller;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import Model.Book;
import com.google.gson.Gson;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;


public class DBHandler {
        
    //private String splitStr;
    
    public DBHandler(){
    	// splitStr = ",";
    }

	public void exportBookListToJson(String filepath, List<Book> bookListToJson){

		String json = new Gson().toJson(bookListToJson);

		try (FileWriter file = new FileWriter(filepath)){
			file.write(json);
			file.flush();
		} catch (IOException e){
			e.printStackTrace();
		}
	}

	public List<Book> importJsonToBookList(String filepath){
		Gson gson = new Gson();
		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader(filepath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		Type listType = new TypeToken<ArrayList<Book>>(){}.getType();
		List<Book> bookList = gson.fromJson(br, listType);
		return bookList;
	}
    
   /* public List<Book> importCSVToBookList(String filePath){
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
    public void exportBookListToCSV(String filePath, List<Book> bookListToCSV){
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
        
    }*/
}
	
	

