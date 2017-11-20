package Controller;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import Model.Book;
import com.google.gson.Gson;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;

public class DBHandler {

    public DBHandler(){

    }

	public void exportBookListToJson(String filename, List<Book> bookListToJson){

		String json = new Gson().toJson(bookListToJson);

		try (FileWriter file = new FileWriter(new File(".").getCanonicalPath() + File.separator +
				"src" + File.separator + "Controller" + File.separator + filename)){
			file.write(json);
			file.flush();
		} catch (IOException e){
			e.printStackTrace();
		}
	}

	public List<Book> importJsonToBookList(String filepath){

		InputStream in = this.getClass().getResourceAsStream(filepath);

		Reader reader = new InputStreamReader(in);
		BufferedReader br = new BufferedReader(reader);

		Type listType = new TypeToken<ArrayList<Book>>(){}.getType();
		Gson gson = new Gson();
		List<Book> bookList = gson.fromJson(br, listType);
		return bookList;
	}

}
	
	

