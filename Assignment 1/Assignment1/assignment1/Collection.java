package assignment1;

public class Collection implements CollectionInterface {

	static final int MAX_COLLECTION_SIZE = 20;
	
	private Identifier[] collection;
	private int size;
	
 	Collection(){
 		collection = new Identifier[MAX_COLLECTION_SIZE];
 		size = 0;
 	}
 
	Collection(Collection src){
		collection = src.collection;
		size = src.size;
	}
	
	public void init() {
		collection = new Identifier[MAX_COLLECTION_SIZE];
		size = 0;
	}
	
	public boolean containsIdentifier(Identifier identifier) {
		for (int i=0; i<size; i++){
			if(collection[i].isEqual(identifier)){
				return true;
			}
		}
		return false;
	}

	public void addIdentifier(Identifier identifier) throws Exception {
		if(!containsIdentifier(identifier)){
			if (size == MAX_COLLECTION_SIZE){
				throw new Exception("The collection already contains 20 identifiers, cannot add identifier.");
			}
			collection[size] = identifier;
			size++;
		}
	}

	public void removeIdentifier(Identifier identifier) {
		for (int i=0; i<size; i++) {
			if (collection[i].isEqual(identifier)) {
				collection[i] = collection[size-1];
				size--;
				break;
			}
		}
	}

	public Identifier get() {
		return collection[size-1];
	}

	public boolean isEqual(Collection collection) {
			// TODO
		return false;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public Collection difference(Collection collection2){
		Collection resultCollection = new Collection(this);
		for (int i=0; i<collection2.size; i++){
			resultCollection.removeIdentifier(collection2.collection[i]);
		}
		return resultCollection;
	}

	@Override
	public Collection intersection(Collection collection2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection union(Collection collection2) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection symmetricDifference(Collection collection2) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
