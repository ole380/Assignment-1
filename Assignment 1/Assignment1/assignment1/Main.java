package assignment1;

import java.util.Scanner;
import java.io.PrintStream;

public class Main {

	static final char COLLECTION_OPEN_MARK = '{';
	static final char COLLECTION_CLOSE_MARK = '}';
	static final String DELIMITER_IDENTIFIERS = " ";
	PrintStream out;

	Main(){
		out = new PrintStream(System.out);
	}

	boolean isValidIdentifierInput(String identifierString){
		if(!Character.isLetter(identifierString.charAt(0))) {
			out.printf("Each element must start with a letter.\n");
			return false;
		}
		
		for(int i=1; i<identifierString.length(); i++) {
			if(!Character.isLetterOrDigit(identifierString.charAt(i))){
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
		
		char firstChar = collectionString.charAt(0);
		if (firstChar != COLLECTION_OPEN_MARK){
			out.printf("Missing '%c'\n", COLLECTION_OPEN_MARK);
			return false;				
		}
		
		char lastChar = collectionString.charAt(collectionString.length()-1);
		if (lastChar != COLLECTION_CLOSE_MARK){
			out.printf("Missing '%c'\n",  COLLECTION_CLOSE_MARK);
			return false;
		}	
		
		return true;
	}

	boolean isValidCollectionInput(String collectionString){
		if(!isValidCollectionFormat(collectionString)){
			return false;
		}
		
		String withoutDelimiters = collectionString.substring(1,collectionString.length()-1);
		String[] identifierInputArray = withoutDelimiters.split(" ");
		
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
		
		String withoutDelimiters = collectionString.substring(1,collectionString.length()-1);
		String[] identifierInputArray = withoutDelimiters.split(" ");
		
		if(!identifierInputArray[0].equals("")){
			for (String identifierInput : identifierInputArray) {
				try {
					Identifier nextIdentifier = constructIdentifier(identifierInput);
					resultCollection.addIdentifier(nextIdentifier);
				} catch (Exception e) {
					out.printf("%s", e.getMessage());
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
		Collection difference = collection1.difference(collection2);
		out.printf("difference = %s\n", collectionToString(difference));
		
		Collection intersection = collection1.intersection(collection2);
		out.printf("intersection = %s\n", collectionToString(intersection));
		
		try {
			Collection union = collection1.union(collection2);
			out.printf("union = %s\n", collectionToString(union));
			
			Collection symmetricDifference = collection1.symmetricDifference(collection2);
			out.printf("sym. diff. = %s\n", collectionToString(symmetricDifference));
		} catch (Exception e) {
			//Cannot occur because collection size is checked in isValidCollectionInput
		}
		
		out.println();
	}

	void start(){
		Scanner in = new Scanner(System.in);
		while (true){
			Collection collection1 = getCollectionInput(in, "first");
			Collection collection2 = getCollectionInput(in, "second");
			processCollection(collection1, collection2);
		}
	}

	public static void main(String[] args) {
		new Main().start();
	}
}