package assignment1;

/*Design for assignment 1 program.
 * 	@author
 * 		Erik Baalhuis & Niels van der Molen
 * 	
 */	

/* Main method. Calls the input method to obtain two input collections, then calls the output method to print what is required.
 * @precondition
 * 		None.
 * @postcondition
 * 		None.
 */
interface ProgramDesign{

	public static void main(String[] args){
		
	}

	/* Reads the input from stdin and shows an error if the input is invalid.
	 * @precondition
	 * 		None.
	 * @postcondition
	 * 		Success: Returns the collection that was entered.
	 * 		Failure: An Exception is thrown because the input is not valid.
	 */ 
	Collection input() throws Exception;

	/* Calculates the required collections, given the input.
	 * @precondition
	 * 		collection1 and collection2 must be collections of valid identifiers.
	 * @postcondition
	 * 		Returns the difference, intersection, union, and symmetric difference of collection1 and collection2 as a Collection array.
	 * 		
	 */ 
	Collection[] process(Collection collection1, Collection collection2);

	/* Prints the output as required.
	 * @precondition
	 * 		results contains 4 collections of type Collection.
	 * @postcondition
	 * 		The difference, intersection, union, and symmetric difference are printed.
	 */ 
	void output(Collection[] results);
}