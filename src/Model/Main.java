package Model;

import java.io.IOException;

import View.TextView;

public class Main {
	
	
	private static TextView textView;
	/**
	 * @param args
	 * @throws IOException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	
	
	public static void main(String[] args){
		textView = new TextView();
		textView.startUp();

	}

}
