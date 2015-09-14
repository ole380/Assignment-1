package assignment1;

public class Collection implements CollectionInterface {

	static final int MAX_COLLECTION_SIZE = 20;

	private Identifier[] identifierArray;
	private int size;

	Collection(){
		identifierArray = new Identifier[MAX_COLLECTION_SIZE];
		size = 0;
	}

	Collection(Collection src){
		identifierArray = new Identifier[MAX_COLLECTION_SIZE];
		for(int i=0; i<src.size; i++){
			identifierArray[i] = src.identifierArray[i];
		}
		size = src.size;
	}

	public void init() {
		identifierArray = new Identifier[MAX_COLLECTION_SIZE];
		size = 0;
	}

	public boolean containsIdentifier(Identifier identifier) {
		for (int i=0; i<size; i++){
			if(identifierArray[i].isEqual(identifier)){
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
			identifierArray[size] = identifier;
			size++;
		}
	}

	public void removeIdentifier(Identifier identifier) {
		for (int i=0; i<size; i++) {
			if (identifierArray[i].isEqual(identifier)) {
				identifierArray[i] = identifierArray[size-1];
				identifierArray[size-1] = null;
				size--;
				break;
			}
		}
	}

	public Identifier get() {
		return identifierArray[size -1];
	}

	public boolean isEqual(Collection collection2) {
		if(size == collection2.size){
			for(int i=0; i<size; i++){
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
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public String toString(){
		String resultString = "";
		for (int i=0; i < size; i++){
			if(size == 1){
				resultString = resultString + identifierArray[i];
			}else{
				resultString = resultString + identifierArray[i] + " ";
			}
		}
		return resultString;
	}


	public Collection difference(Collection collection2){
		Collection resultCollection = new Collection(this);
		for (int i=0; i<collection2.size; i++){
			resultCollection.removeIdentifier(collection2.identifierArray[i]);
		}
		return resultCollection;
	}

	public Collection intersection(Collection collection2) {
		Collection resultCollection = new Collection();
		for (int i=0; i<collection2.size; i++){
			if (containsIdentifier(collection2.identifierArray[i])){
				resultCollection.identifierArray[resultCollection.size] = collection2.identifierArray[i];
				resultCollection.size++;
			}
		}
		return resultCollection;
	}

	public Collection union(Collection collection2) throws Exception {
		Collection resultCollection = new Collection(this);
		for (int i=0; i<collection2.size; i++){
			if (resultCollection.size<MAX_COLLECTION_SIZE){
				resultCollection.addIdentifier(collection2.identifierArray[i]);
			}else if(resultCollection.containsIdentifier(collection2.identifierArray[i])){
				continue;
			}else{
				throw new Exception("set contains over 20 identifiers, cannot form set.");
			}
		}
		return resultCollection;
	}

	public Collection symmetricDifference(Collection collection2) throws Exception {
		return (this.difference(collection2)).union(collection2.difference(this));
	}

}
