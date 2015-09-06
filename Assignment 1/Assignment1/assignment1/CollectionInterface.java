package assignment1;

/*ADT for the class Collection 
* 	Author: Erik Baalhuis & Niels van der Molen
* 	Elements: Identifiers of type Identifier
* 	Structure: None
* 	Domain: Up to a maximum of 20 identifiers with a minimum of 0.
* 
* 	Constructors
* 	
* 	Collection();
* 		PRE-Condition
*  			None.
* 		POST-Condition
* 			A new empty Collection object is created.
* 
* 	Collection(Collection src);
* 		PRE-Condition
* 			None.
* 		POST-Condition
* 			A new Collection object is created which is a copy of scr.
*/

public interface CollectionInterface {
	
	/* Initializes the Collection object to the empty collection. 
	 * PRE-Condition
	 * 		None.
	 * POST-Condition
	 * 		The collection is empty.
	 */
	void init();
	
	// Elementary read and write
	
	/* Checks if an identifier is in the collection.
	 * PRE-Condition
	 * 		None.
	 * POST-True
	 * 		The identifier is in the collection.
	 * POST-False
	 * 		The identifier is not in the collection.
	 * 		
	 */
	boolean containsIdentifier(Identifier ident);
	
	/* Adds an identifier to the collection.
	 * PRE-Condition
	 * 		The identifier is not in the collection.
	 * POST-Condition
	 * 		The identifier is added to the PRE-collection.
	 */
	void addIdentifier(Identifier ident);
	
	/* Removes an identifier from the collection.
	 * PRE-Condition
	 * 		The identifier is in the collection.
	 * POST-Condition
	 * 		The identifier is removed from the PRE-collection.
	 */
	void removeIdentifier(Identifier ident);
	
	/* Returns the collection as a String array.
	 * PRE-Condition
	 * 		None.
	 * POST-Condition
	 * 		the PRE-Collection is returned as a String array.
	 */
	String[] readCollection();
	
	// Natural operations
	
	/*  Checks if two collections are equal.
	 * PRE-Condition
	 * 		None.
	 * POST-True
	 * 		The collections are equal.
	 * POST-False
	 * 		The collections are not equal.
	 */
	boolean isEqual(Collection collection);
	
	/* Determines the difference of the collections.
	 * PRE-Condition
	 * 		None.
	 * POST-Condition
	 * 		The difference of the two collections is returned as a Collection object.
	 */
	Collection difference(Collection collection);
	
	/* Determines the intersection of the collections.
	 * PRE-Condition
	 * 		None.
	 * POST-Condition
	 * 		The intersection of the two collections is returned as a Collection object.
	 */
	Collection intersection(Collection collection);
	
	/* Determines the union of the collections.
	 * PRE-Condition
	 * 		None.
	 * POST-Condition
	 * 		The union of the two collections is returned as a Collection object.
	 */
	Collection union(Collection collection);
	
	/* Determines the symmetric difference of the collections.
	 * PRE-Condition
	 * 		None.
	 * POST-Condition
	 * 		The symmetric difference of the two collections is returned as a Collection object.
	 */
	Collection symmetricDifference(Collection collection);
}
