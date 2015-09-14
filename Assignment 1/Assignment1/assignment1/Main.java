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
		}else if(!(collection.charAt(0) == SET_OPEN_MARK)){
			out.printf("Missing '%c'\n", SET_OPEN_MARK);
			return false;
		}	
		return true;
	}

	boolean checkLetter(Scanner in){
		return in.hasNext("[a-zA-Z]");
	}

	boolean checkDigit(Scanner in){
		return in.hasNext("[0-9]");
	}

	boolean checkAlphanumeric(Scanner in){
		return checkLetter(in) || (checkDigit(in));
	}

	Identifier readIdentifierInput(Scanner identifierScanner) throws Exception{
		identifierScanner.useDelimiter("");
		
		if(!checkLetter(identifierScanner)){
			throw new Exception("Wrong identifier input, identifiers always start with a letter.");
		}
		Identifier resultIdentifier = new Identifier(identifierScanner.next().charAt(0));
		while(identifierScanner.hasNext()){
			if(!checkAlphanumeric(identifierScanner)){
				throw new Exception("Wrong identifier input, identifiers can only consist of alphanumeric characters.");
			}
			resultIdentifier.addCharacter(identifierScanner.next().charAt(0));
		}
		return resultIdentifier;
	}

	Collection readCollectionInput(Scanner collectionScanner) throws Exception{
		Collection resultCollection = new Collection();
		collectionScanner.useDelimiter(" ");
		while (collectionScanner.hasNext()){
			if (resultCollection.size() > 10){
				throw new Exception("This set is too large, only sets up to 10 identifiers are allowed as input.");
			}
			Scanner identifierScanner = new Scanner(collectionScanner.next());
			resultCollection.addIdentifier(readIdentifierInput(identifierScanner));
		}
		return resultCollection;
	}

	Collection getCollectionInput(Scanner in, String s) throws Exception{
		String collectionInput;
		do{
			out.printf("Give the %s set : ", s);
			collectionInput = in.nextLine();
		}while (!checkValidCollectionInput(collectionInput));
		collectionInput = collectionInput.substring(1, collectionInput.length()-1);
		Scanner collectionScanner = new Scanner(collectionInput);
		return readCollectionInput(collectionScanner);
	}

	void printCollection(Collection collection){
		Collection resultCollection = new Collection(collection);
		out.printf("{");
		for (int i=0; i < collection.size(); i++){
			Identifier identifier = resultCollection.get();
			if(resultCollection.size() == 1){
				out.printf("%s", identifier.toString());
			}else{
				out.printf("%s ", identifier.toString());
			}
			resultCollection.removeIdentifier(identifier);
		}
		out.printf("}\n");
	}
	
	void processCollectionInput(Collection collection1, Collection collection2) throws Exception{
		//Collection difference = collection1.difference(collection2);
		out.printf("difference = ");
		printCollection(collection1.difference(collection2));
		//printCollection(difference);
		
		//Collection intersection = collection1.intersection(collection2);
		out.printf("intersection = ");
		printCollection(collection1.intersection(collection2));
		//printCollection(intersection);
		
		//Collection union = collection1.union(collection2);
		out.printf("union = ");
		printCollection(collection1.union(collection2));
		//printCollection(union);
		
		//Collection symmetricDifference = collection1.symmetricDifference(collection2);
		out.printf("sym. diff. = ");
		printCollection(collection1.symmetricDifference(collection2));
		//printCollection(symmetricDifference);
	}
	
	void start(){
		Scanner s = new Scanner(System.in);
		boolean lol = true;
		while (lol){
			try {
				processCollectionInput(getCollectionInput(s,"first") , getCollectionInput(s,"second"));	
			} catch (Exception e) {
				e.printStackTrace();
			}
			//lol = false;
		}

	}

	public static void main(String[] args) {
		new Main().start();
	}
}