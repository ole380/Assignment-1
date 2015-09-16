package assignment1;

public class Identifier implements IdentifierInterface {

	private StringBuffer identifierContent;
	private int identifierLength;

	Identifier(char c){
		identifierContent = new StringBuffer();
		identifierContent.append(c);
		identifierLength = 1;
	}

	Identifier(Identifier src){
		identifierContent = new StringBuffer(src.identifierContent);
		identifierLength = src.identifierLength;
	}

	public void init(char c) {
		identifierContent = new StringBuffer();
		identifierContent.append(c);
		identifierLength = 1;
	}

	public String toString(){
		return identifierContent.toString();
	}

	public void addCharacter(char c) {
		identifierContent.append(c);
		identifierLength++;
	}

	public char removeLastCharacter() {
		char lastChar = identifierContent.charAt(identifierLength-1);
		identifierContent.deleteCharAt(identifierLength-1);
		return lastChar;
	}

	public boolean isEqual(Identifier identifier2) {
		if (identifierLength==identifier2.identifierLength){
			for (int i=0; i<identifierLength; i++){
				if(identifierContent.charAt(i)==identifier2.identifierContent.charAt(i)){
					continue;
				}
				return false;
			}
			return true;
		}
		return false;
	}

	public int length() {
		return identifierLength;
	}

}