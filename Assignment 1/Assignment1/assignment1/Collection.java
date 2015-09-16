package assignment1;

public class Collection implements CollectionInterface {

	static final int MAX_COLLECTION_SIZE = 20;

	private Identifier[] identifierArray;
	private int collectionSize;

	Collection(){
		identifierArray = new Identifier[MAX_COLLECTION_SIZE];
		collectionSize = 0;
	}

	Collection(Collection src){
		identifierArray = new Identifier[MAX_COLLECTION_SIZE];
		for(int i=0; i<src.collectionSize; i++){
			identifierArray[i] = new Identifier(src.identifierArray[i]);
		}
		collectionSize = src.collectionSize;
	}

	public void init() {
		identifierArray = new Identifier[MAX_COLLECTION_SIZE];
		collectionSize = 0;
	}

	public boolean containsIdentifier(Identifier identifier) {
		for (int i=0; i<collectionSize; i++){
			if(identifierArray[i].isEqual(identifier)){
				return true;
			}
		}
		return false;
	}

	public void addIdentifier(Identifier identifier) throws Exception {
		if(!containsIdentifier(identifier)){
			if (collectionSize == MAX_COLLECTION_SIZE){
				throw new Exception("The collection already contains 20 identifiers, cannot add identifier.");
			}
			identifierArray[collectionSize] = identifier;
			collectionSize++;
		}
	}

	public void removeIdentifier(Identifier identifier) {
		for (int i=0; i<collectionSize; i++) {
			if (identifierArray[i].isEqual(identifier)) {
				identifierArray[i] = identifierArray[collectionSize-1];
				identifierArray[collectionSize-1] = null;
				collectionSize--;
				break;
			}
		}
	}

	public Identifier get() {
		return identifierArray[0];
	}

	public boolean isEqual(Collection collection2) {
		if(collectionSize == collection2.collectionSize){
			for(int i=0; i<collectionSize; i++){
				if (collection2.containsIdentifier(identifierArray[i])){
					continue;
				}
				return false;
			}
			return true;
		}
		return false;
	}

	public int size() {
		return collectionSize;
	}

	public boolean isEmpty() {
		return collectionSize == 0;
	}

	public Collection difference(Collection collection2){
		Collection resultCollection = new Collection(this);
		for (int i=0; i<collection2.collectionSize; i++){
			resultCollection.removeIdentifier(collection2.identifierArray[i]);
		}
		return resultCollection;
	}

	public Collection intersection(Collection collection2) {
		Collection resultCollection = new Collection();
		for (int i=0; i<collection2.collectionSize; i++){
			if (containsIdentifier(collection2.identifierArray[i])){
				resultCollection.identifierArray[resultCollection.collectionSize] = collection2.identifierArray[i];
				resultCollection.collectionSize++;
			}
		}
		return resultCollection;
	}

	public Collection union(Collection collection2) throws Exception {
		Collection resultCollection = new Collection(this);
		for (int i=0; i<collection2.collectionSize; i++){
			if (resultCollection.collectionSize<MAX_COLLECTION_SIZE){
				resultCollection.addIdentifier(collection2.identifierArray[i]);
			}else if(resultCollection.containsIdentifier(collection2.identifierArray[i])){
				continue;
			}else{
				throw new Exception("Collection contains more than 20 identifiers, cannot form collection.");
			}
		}
		return resultCollection;
	}

	public Collection symmetricDifference(Collection collection2) throws Exception {
		return (this.difference(collection2)).union(collection2.difference(this));
	}

}
