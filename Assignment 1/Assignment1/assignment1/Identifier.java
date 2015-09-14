package assignment1;

public class Identifier implements IdentifierInterface {

	private StringBuffer identifier;
	private int length;
	
	Identifier(char c){
		identifier = new StringBuffer();
		identifier.append(c);
		length = 1;
	}
	
	Identifier(Identifier src){
		identifier = src.identifier;
	}
	
	public void init(char c) {
		identifier = new StringBuffer();
		identifier.append(c);
		length = 1;
	}
	
	public String toString(){
		return identifier.toString();
	}

	public void addCharacter(char c) {
		identifier.append(c);
		length++;
	}

	public char removeLastCharacter() {
		char lastChar = identifier.charAt(length-1);
		identifier.deleteCharAt(length-1);
		return lastChar;
	}

	public boolean isEqual(Identifier identifier2) {
		if (length==identifier2.length){
			for (int i=0; i<length; i++){
				if(identifier.charAt(i)==identifier2.identifier.charAt(i)){
					continue;
				}
				return false;
			}
			return true;
		}
		return false;
	}

	public int length() {
		return length;
	}

}