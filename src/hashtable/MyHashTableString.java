package hashtable;

public class MyHashTableString {
	NodeList [] nodeList;
	int size;
	int noNodes;//used for testing
	
	
	MyHashTableString(int size){
		this.size = size;
		nodeList = new NodeList[size];
		for(int i=0;i<size;i++){
			nodeList[i] = new NodeList();
		}
		
		
	}
	public void insert(String key,String value){
		//calculate hash to find index;
		noNodes++;
		Node n = new Node(key,value);
		int index = hashFromString(key);
		if(size == noNodes){
			System.out.println("need to increase the size of the array");
			throw new ArrayIndexOutOfBoundsException();
		}
		nodeList[index].insert(n);
		
	}
	public void insertArray(String[][] map){
		for (int i=0;i<map.length;i++){
			insert(map[i][0],map[i][1]);
		}
	}
	public boolean find(String key){
		int index = hashFromString(key);
		System.out.println("the hash returned-->"+index);
		return nodeList[index].findNode(key);
	}
	public String getValue(String key){

		int index = hashFromString(key);
		System.out.println("the hash returned-->"+index);
		return nodeList[index].findValue(key);
	
	}
	
	
	public void displayTable(){
		for(int i=0;i< size;i++){
			nodeList[i].display();
		}
	}
	
	
	
	//function to calculate the hash value
	public int hashFromString(String key){
		int hashKeyValue =0 ;
		for(int i=0;i<key.length();i++){
			System.out.println("char at "+(int)key.charAt(i));
			int charCode = key.charAt(i) -96;
			int ascii = charCode;
			hashKeyValue = ((hashKeyValue*27)+charCode)%size;
			System.out.println("ascii :"+ascii+"hashKeyVal :"+hashKeyValue);
		}
		System.out.println("HashKey Returned --->"+hashKeyValue);
		
		return hashKeyValue;
	}
	
	
	
	
	public class Node{
		String key;
		String value;
		Node next;
		Node(String key,String value){
			this.key = key;
			this.value = value;
		}
		public String toString(){
			return ("Key :"+key+"value :"+value);
		}
	}
	public class NodeList{
		//This is my linked list which needs to perform all the linked list operations
		private Node headNode;

		public void insert(Node node){
			if(headNode == null ){
				headNode = node;
			}
			else{
				System.out.println("inserting into linked list");
				Node curNode = headNode;
				Node prevNode = null;
				//curNode = headNode;
				while(curNode !=null){
					prevNode = curNode;
					curNode = curNode.next;
				}
				curNode = node;
				if(headNode !=null)//it is not the first element
					prevNode.next = curNode;
			}
		}
		public boolean findNode(String nodeKey){
			Node curNode = headNode;
			while(curNode != null){
				if(curNode.key.equals(nodeKey))
					return true;
				curNode = curNode.next;
			}
			return false;
		}
		public String findValue(String nodeKey){
			Node curNode = headNode;
			while(curNode != null){
				if(curNode.key.equals(nodeKey)){
					return curNode.value;
				}
				curNode = curNode.next;
			}
			return null;
		}

		public void display(){
			Node curNode = headNode;
			while(curNode != null){
				System.out.println("Key :"+curNode.key+"Value :"+curNode.value);
				curNode = curNode.next;
			}
		}
	}

}
