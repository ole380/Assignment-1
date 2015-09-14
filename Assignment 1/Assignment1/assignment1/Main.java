package assignment1;

import java.util.Scanner;
import java.io.PrintStream;

public class Main {

	static final char SET_OPEN_MARK = '{';
	static final char SET_CLOSE_MARK = '}';
	PrintStream out;

	Main(){
		out = new PrintStream(System.out);
	}

	
	boolean checkValidCollectionInput(String collection){
		if(collection.length()==0){
			return false;
		}else if (collection.charAt(0) == SET_OPEN_MARK && !(collection.charAt(collection.length()-1) == SET_CLOSE_MARK)){
				out.printf("Missing '%c'\n", SET_CLOSE_MARK);
				return false;				
		}else if (!(collection.charAt(collection.length()-1) == SET_CLOSE_MARK)){
			out.printf("Missing '%c'\nMissing '%c'\n", SET_OPEN_MARK, SET_CLOSE_MARK);
			return false;
		}else{
			out.printf("Missing '%c'\n", SET_OPEN_MARK);
		}
		return true;
	}
	
	void readCollectionInput(Scanner in, String s){
		Collection resultCollection = new Collection();
		String collection;
		do {
			out.printf("Give the %s set : ", s);
			collection = in.nextLine();
			}while (!checkValidCollectionInput(collection));
		
	}

	void start(){
		Scanner s = new Scanner(System.in);
		while (true){
			readCollectionInput(s,"first");
		}
	}

	public static void main(String[] args) {
		new Main().start();
	}
}