package assignment1;

/*ADT for the class Collection 
* 	@author
* 		Erik Baalhuis & Niels van der Molen
* 	@elements
* 		Identifiers of type Identifier
* 	@structure
* 		None
* 	@domain
* 		Up to a maximum of 20 identifiers with a minimum of 0.
* 
* 	@constructor
* 	
* 	Collection();
* 		precondition
*  			None.
* 		postcondition
* 			A new empty Collection object is created.
* 
* 	Collection(Collection src);
* 		precondition
* 			None.
* 		postcondition
* 			A new Collection object is created which is a copy of scr.
*/

public interface CollectionInterface {
	
	/* Initializes the Collection object to the empty collection. 
	 * @precondition
	 * 		None.
	 * @postcondition
	 * 		The collection is empty.
	 */
	void init();
	
	// Elementary read and write
	
	/* Checks if an identifier is in the collection.
	 * @precondition
	 * 		None.
	 * @POST-condition
	 * 		True: The identifier is in the collection.
	 * 		False: The identifier is not in the collection.
	 */
	boolean containsIdentifier(Identifier identifier);
	
	/* Adds an identifier to the collection.
	 * @precondition
	 * 		None.
	 * @postcondition
	 * 		The identifier is now in the POST-collection.
	 */
	void addIdentifier(Identifier identifier);
	
	/* Removes an identifier from the collection.
	 * @precondition
	 * 		None.
	 * @postcondition
	 * 		The identifier is not in the POST-collection.
	 */
	void removeIdentifier(Identifier identifier);
	
	/* Returns an Identifier that is in the collection.
	 * @precondition
	 * 		None.
	 * @postcondition
	 * 		An identifier of type Identifier that is in the collection is returned.
	 */
	Identifier get();
	
	// Natural operations
	
	/*  Checks if two collections are equal.
	 * @precondition
	 * 		None.
	 * @POST-condition
	 * 		True: The collections are equal.
	 * 		False: The collections are not equal.
	 */
	boolean isEqual(Collection collection);
	
	/*  Returns the size of the collection as an int.
	 * @precondition
	 * 		None.
	 * @POST-condition
	 * 		The size of the collection is returned as an int.
	 */
	int size();
	
	/* Determines the difference of the collections.
	 * @precondition
	 * 		None.
	 * @postcondition
	 * 		The difference of the two collections is returned as a Collection object.
	 */
	Collection difference(Collection collection);
	
	/* Determines the intersection of the collections.
	 * @precondition
	 * 		None.
	 * @postcondition
	 * 		The intersection of the two collections is returned as a Collection object.
	 */
	Collection intersection(Collection collection);
	
	/* Determines the union of the collections.
	 * @precondition
	 * 		None.
	 * @postcondition
	 * 		Success: The union of the two collections is returned as a Collection object.
	 * 		Failure: An Exception is thrown because the union of the two collections contains over 20 identifiers.
	 */
	Collection union(Collection collection) throws Exception;
	
	/* Determines the symmetric difference of the collections.
	 * @precondition
	 * 		None.
	 * @postcondition
	 * 		Success: The symmetric difference of the two collections is returned as a Collection object.
	 * 		Failure: An Exception is thrown because the symmetric difference of the two collections contains over 20 identifiers.
	 */
	Collection symmetricDifference(Collection collection) throws Exception;
}