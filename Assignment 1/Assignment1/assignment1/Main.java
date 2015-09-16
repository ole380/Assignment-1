package assignment1;

import java.util.Scanner;
import java.io.PrintStream;

public class Main {

	static final char COLLECTION_OPEN_MARK = '{';
	static final char COLLECTION_CLOSE_MARK = '}';
	static final String DELIMITER_IDENTIFIERS = " ";
	boolean errorHasOccurred;
	PrintStream out;

	Main(){
		out = new PrintStream(System.out);
		errorHasOccurred = false;
	}

	boolean isValidIdentifierInput(String identifierString){
		if(!Character.isLetter(identifierString.charAt(0))) {
			out.printf("Each element must start with a letter.\n");
			return false;
		}
		for(int i=1; i<identifierString.length(); i++) {
			if(!Character.isLetter(identifierString.charAt(i)) && !Character.isDigit(identifierString.charAt(i))) {
				out.printf("Each element may only contain alphanumeric characters.\n");
				return false;
			}
		}
		return true;
	}

	boolean isValidCollectionFormat(String collectionString){
		if(collectionString.length()==0){
			return false;
		}
		if (collectionString.charAt(0) != COLLECTION_OPEN_MARK){
			out.printf("Missing '%c'\n", COLLECTION_OPEN_MARK);
			return false;				
		}
		if (collectionString.charAt(collectionString.length()-1) != COLLECTION_CLOSE_MARK){
			out.printf("Missing '%c'\n",  COLLECTION_CLOSE_MARK);
			return false;
		}	
		return true;
	}

	boolean isValidCollectionInput(String collectionString){
		if(!isValidCollectionFormat(collectionString)){
			return false;
		}
		String[] identifierInputArray = collectionString.substring(1,collectionString.length()-1).split(" ");
		if(identifierInputArray.length > 10) {
			out.printf("The set may not contain more than 10 elements.\n");
			return false;
		}
		if(!identifierInputArray[0].equals("")){
			for(String identifierInput : identifierInputArray) {
				if(!isValidIdentifierInput(identifierInput)) {
					return false;
				}
			}
		}
		return true;
	}

	Identifier constructIdentifier(String identifierString){
		Identifier resultIdentifier = new Identifier(identifierString.charAt(0));
		for(int i=1; i<identifierString.length(); i++){
			resultIdentifier.addCharacter(identifierString.charAt(i));
		}
		return resultIdentifier;
	}

	Collection constructCollection(String collectionString){
		Collection resultCollection = new Collection();
		String[] identifierInputArray = collectionString.substring(1,collectionString.length()-1).split(" ");
		if(!identifierInputArray[0].equals("")){
			for (String identifierInput : identifierInputArray) {
				try {
					resultCollection.addIdentifier(constructIdentifier(identifierInput));
				} catch (Exception e) {
					out.printf("%s", e.getMessage());
					errorHasOccurred = true;
					break;
				}
			}
		}
		return resultCollection;
	}

	Collection getCollectionInput(Scanner in, String setOrdinal) {
		String collectionInput;
		do{
			out.printf("Give the %s set : ", setOrdinal);
			//Eclipse somehow does not generate EOF from time to time when pressing ctrl+z so this does not always work.
			if(!in.hasNextLine()){
				out.println("Program ends here because of End Of File");
				System.exit(0);
			}
			collectionInput = in.nextLine();
		}while (!isValidCollectionInput(collectionInput));
		return constructCollection(collectionInput);
	}

	String collectionToString(Collection collection){
		Collection resultCollection = new Collection(collection);
		String resultString = "{";
		for (int i=0; i < collection.size(); i++){
			Identifier identifier = resultCollection.get();
			resultString = resultString + identifier.toString() + " ";
			resultCollection.removeIdentifier(identifier);
		}
		if(resultString.length() == 1){
			return resultString + "}";
		}else{
			return resultString.substring(0, resultString.length()-1) + "}";
		}
	}

	void processCollection(Collection collection1, Collection collection2) {
		out.printf("difference = %s\n", collectionToString(collection1.difference(collection2)));
		out.printf("intersection = %s\n", collectionToString(collection1.intersection(collection2)));
		try {
			out.printf("union = %s\n", collectionToString(collection1.union(collection2)));
			out.printf("sym. diff. = %s\n", collectionToString(collection1.symmetricDifference(collection2)));
			out.println();
		} catch (Exception e) {
			out.printf("%s", e.getMessage());
		}
	}

	void start(){
		Scanner in = new Scanner(System.in);
		while (true){
			Collection collection1 = getCollectionInput(in, "first");
			if(!errorHasOccurred){
				Collection collection2 = getCollectionInput(in, "second");
				if(!errorHasOccurred){
					processCollection(collection1, collection2);
				}
			}
			//processCollection(getCollectionInput(in,"first") , getCollectionInput(in,"second"));
			errorHasOccurred = false;
		}
	}

	public static void main(String[] args) {
		new Main().start();
	}
}