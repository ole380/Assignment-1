package assignment1;

/*ADT for the class Identifier
 * 	Author: Erik Baalhuis & Niels van der Molen
 * 	Elements: alphanumeric characters of type String.
 * 	Structure: Linear.
 * 	Domain: All combinations of one or more alphanumeric characters that start with a letter.
 * 
 * 	Constructors
 * 
 * 	Identifier(String s);
 * 		PRE-condition
 * 			String s starts with a letter and contains only alphanumeric characters.
 * 		POST-condition
 * 			A new Identifier which contains the linear content of String s is created.
 * 
 * 	Identifier(Identifier src);
 * 		PRE-condition
 * 			None.
 * 		POST-condition
 * 			A new Identifier object which is a copy of src is created.
 * 	
*/	
public interface IdentifierInterface {

	/** Initializes the Identifier object (..)????
	 *  PRE-Condition:
	 *  POST-Condition:
	 */
	void init();
	
	// Elementary operations for read & write
	
	/* Reads an identifier.
	 * PRE-Condition
	 * 		None.
	 * POST-Condition
	 * 		The content of the identifier is returned in string format.
	 */
	String read();
	
	// Natural operations
	
	/* Compares two identifiers.
	 * PRE-Condition
	 * 		None.
	 * POST-True 
	 * 		The content of both identifiers is equal.
	 * POST-False
	 * 		The content of both identifiers is different.
	 */
	boolean isEqual(Identifier ident);
	
	/* Checks the amount of characters of an identifier
	 * PRE-Condition
	 * 		None.
	 * POST-Condition
	 * 		The amount of characters the identifier contains is returned in type int.
	 */
	int length();
}
