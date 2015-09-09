package assignment1;

/*ADT for the class Identifier
 * 	@author
 * 		Erik Baalhuis & Niels van der Molen
 * 	@elements 
 * 		Alphanumeric characters of type char.
 * 	@structure
 * 		Linear.
 * 	@domain 
 * 		All combinations of one or more elements that start with a letter.
 * 
 * 	@constructor
 * 	Identifier(char c);
 * 		precondition
 * 			Character c is a letter.
 * 		postcondition
 * 			A new Identifier which contains the content of c is created.
 * 	Identifier(Identifier src);
 * 		precondition
 * 			None.
 * 		postcondition
 * 			A new Identifier object which is a copy of src is created.
 * 	
*/	
public interface IdentifierInterface {
	
	/* Initializes the Identifier object with content c.
	 *  @precondition:
	 *  	None.
	 *  @postcondition:
	 *  	Success: The Identifier object contains only the content c.
	 *  	Failure: An Exception is thrown because the character c is not a letter.
	 */
	void init(char c) throws Exception;
	
	// Elementary operations for read & write
	
	/* Adds a character c to the Identifier
	 * @precondition
	 * 		None.
	 * @postcondition
	 * 		Success: The character c is added to the end of the Identifier.
	 * 		Failure: An Exception is thrown because the character c is not alphanumeric.
	 */
	void addCharacter(char c) throws Exception;
	
	/* Removes and returns the last character that was added to the identifier.
	 * @precondition
	 * 		None.
	 * @postcondition
	 * 		Success: The character added last is removed from the PRE-identifier, and returned.
	 * 		Failure: An Exception is thrown because the PRE-identifier contains only one character, which may not be removed.
	 */
	char removeLastCharacter() throws Exception;
	
	/* Returns an identifier as a String object.
	 * @precondition
	 * 		None.
	 * @postcondition
	 * 		The content of the identifier is returned as a String object.
	 */
	String toString();
	
	// Natural operations
	
	/* Compares two identifiers.
	 * @precondition
	 * 		None.
	 * @postcondition
	 * 		True: The content of both identifiers is equal.
	 * 		False: The content of both identifiers is different.
	 */
	boolean isEqual(Identifier identifier);
	
	/* Checks the amount of characters of an identifier
	 * precondition
	 * 		None.
	 * postcondition
	 * 		The amount of characters the identifier contains is returned in type int.
	 */
	int length();
}