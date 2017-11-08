package Model;

import java.io.IOException;

import View.TextView;

public class Main {
	
	
	private static TextView textView;
	/**
	 * @param args
	 * @throws IOException 
	 */
	
	
	public static void main(String[] args) throws IOException {
		textView = new TextView();
		textView.startUp();

	}

}
