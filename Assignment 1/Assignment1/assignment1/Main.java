package assignment1;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.io.PrintStream;

public class Main {

	static final char SET_OPEN_MARK = '{';
	static final char SET_CLOSE_MARK = '}';
	PrintStream out;

	Main(){
		out = new PrintStream(System.out);
	}

	String collectionToString(Collection collection) {
		String result = "{";
		while(collection.size > 0) {
			Identifier nextElement = collection.get();
			collection.removeIdentifier(nextElement);
			result = result + nextElement.toString() + " ";
		}
		return result.substring(0,result.length()-1) + "}";
	}

	boolean hasValidDelimiters(String collectionInput) {
		if(collectionInput.length() == 0) {
			return false;
		}
		if(collectionInput.charAt(0) != SET_OPEN_MARK) {
			out.printf("Missing '%c'\n", SET_OPEN_MARK);
			return false;
		}
		if(collectionInput.charAt(collectionInput.length()-1) != SET_CLOSE_MARK) {
			out.printf("Missing '%c'\n", SET_CLOSE_MARK);
			return false;
		}
		return true;
	}
	
	boolean isValidIdentifierInput(String identifierInput) {
		if(!Character.isLetter(identifierInput.charAt(0))) {
			out.printf("Each element must start with a letter %s.\n",identifierInput);
			return false;
		}
		for(int i=1; i<identifierInput.length(); i++) {
			if(!Character.isLetter(identifierInput.charAt(i)) && !Character.isDigit(identifierInput.charAt(i))) {
				out.printf("Each element may only contain alphanumeric characters.\n");
				return false;
			}
		}
		return true;
	}
	
	boolean isValidCollectionInput(String collectionInput) {
		if(!hasValidDelimiters(collectionInput)){
			return false;
		}
		
		String inputWithoutDelimiters = collectionInput.substring(1,collectionInput.length()-1);
		String[] identifierInputArray = inputWithoutDelimiters.split(" ");
		if(identifierInputArray.length > 10) {
			out.printf("The set may not contain more than 10 elements.\n");
			return false;
		}
		
		for(String identifierInput : identifierInputArray) {
			if(!isValidIdentifierInput(identifierInput)) {
				return false;
			}
		}
		
		return true;
	}

	Identifier constructIdentifier(String identifierInput) {
		Identifier result = new Identifier(identifierInput.charAt(0));
		for(int i=1; i<identifierInput.length(); i++) {
			result.addCharacter(identifierInput.charAt(i));
		}
		return result;
	}
	
	Collection constructCollection(String collectionInput) {
		Collection result = new Collection();
		String inputWithoutDelimiters = collectionInput.substring(1,collectionInput.length()-1);
		String[] identifierInputArray = inputWithoutDelimiters.split(" ");
		for(String identifierInput : identifierInputArray) {
			Identifier identifier = constructIdentifier(identifierInput);
			try {
				result.addIdentifier(identifier);
			} catch (Exception e) {
			}
		}
		return result;
	}
	
	Collection readCollectionInput(Scanner in, String setOrdinal){
		String collectionInput;
		
		do {
			out.printf("Give the %s set : ", setOrdinal);
			collectionInput = in.nextLine();				
			}while (!isValidCollectionInput(collectionInput));
		
		return constructCollection(collectionInput);
	}

	void processCollections(Collection collection1, Collection collection2) {
		Collection difference = new Collection();
		Collection intersection = new Collection();
		Collection union = new Collection();
		Collection symmetricDifference = new Collection();
		
		difference = collection1.difference(collection2);
		intersection = collection1.intersection(collection2);
		try {
			union = collection1.union(collection2);
		} catch (Exception e) {
		}
		try {
			symmetricDifference = collection1.symmetricDifference(collection2);
		} catch (Exception e) {
		}
		
		out.printf("difference = %s\n", collectionToString(difference));
		out.printf("intersection = %s\n", collectionToString(intersection));
		out.printf("union = %s\n", collectionToString(union));
		out.printf("symm. diff. = %s\n", collectionToString(symmetricDifference));
	}

	void start(){
		Scanner in = new Scanner(System.in);
		Collection collection1, collection2;
		while (true){
			collection1 = readCollectionInput(in,"first");
			collection2 = readCollectionInput(in,"second");
			processCollections(collection1,collection2);
		}
	}

	public static void main(String[] args) {
		new Main().start();
	}
}