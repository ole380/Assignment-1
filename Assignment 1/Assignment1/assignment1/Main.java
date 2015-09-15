package assignment1;

import java.util.Scanner;
import java.io.PrintStream;

public class Main {

	static final char COLLECTION_OPEN_MARK = '{';
	static final char COLLECTION_CLOSE_MARK = '}';
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
			out.printf("The collection may not contain more than 10 elements.\n");
			return false;
		}
		for(String identifierInput : identifierInputArray) {
			if(!isValidIdentifierInput(identifierInput)) {
				return false;
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

	Collection constructCollection(String collectionString)throws Exception{
		Collection resultCollection = new Collection();
		String[] identifierInputArray = collectionString.substring(1,collectionString.length()-1).split(" ");
		for (String identifierInput : identifierInputArray) {
			resultCollection.addIdentifier(constructIdentifier(identifierInput));
		}
		return resultCollection;
	}

	Collection getCollectionInput(Scanner in, String setOrdinal) throws Exception{
		String collectionInput;
		do{
			out.printf("Give the %s set : ", setOrdinal);
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

	void processCollectios(Collection collection1, Collection collection2) throws Exception{
		out.printf("difference = %s\n", collectionToString(collection1.difference(collection2)));
		out.printf("intersection = %s\n", collectionToString(collection1.intersection(collection2)));
		out.printf("union = %s\n", collectionToString(collection1.union(collection2)));
		out.printf("sym. diff. = %s\n", collectionToString(collection1.symmetricDifference(collection2)));
		out.println();
	}

	void start(){
		Scanner in = new Scanner(System.in);
		while (true){
			try {
				processCollectios(getCollectionInput(in,"first") , getCollectionInput(in,"second"));
			} catch (Exception e) {
				System.exit(0);
			}	
		}
	}

	public static void main(String[] args) {
		new Main().start();
	}
}