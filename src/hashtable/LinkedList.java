package hashtable;

public class LinkedList {
	public static void main(String [] args){
		LinkedList ll = new LinkedList("hi");
		ll.insert("hello");
		ll.insert("ber");
		ll.display();
		ll.delete("hello");
		ll.display();
		
	}

	Node headNode;
	LinkedList(String val){
		Node n = new Node(val);
		headNode = n;
	}

	public void insert(String value){
		Node node = new Node(value);
		if(headNode !=null){
			Node curNode = headNode;
			Node prevNode= curNode;
			while(curNode != null){
				prevNode = curNode;
				curNode = curNode.next;
			}
			curNode = node;
			prevNode.next = curNode;

		}
		else
			headNode = node;
	}
	public boolean find(String value){
		Node curNode = headNode;
		while(curNode !=null){
			if(curNode.value.equals(value))
				return true;
			curNode = curNode.next;
		}
		return false;
	}
	public boolean delete(String value){
		if(headNode.value.equals(value)){
			headNode.value = null;
			if(headNode.next !=null)
				headNode = headNode.next;
			return true;
		}
		else{
			Node curNode = headNode;
			Node prevNode;
			while(curNode !=null){
				prevNode = curNode;
				curNode = curNode.next;
				if(curNode.value.equals(value)){
					prevNode.next = curNode.next;
					curNode = null;
					return true;
				}
			}
		}
		return false;
	}
	public void display(){
		Node curNode = headNode;
		while (curNode !=null){
			System.out.println(curNode.value);
			curNode = curNode.next;
		}
	}

	class Node{
		Node next;
		String value;
		Node(String value){
			this.value = value;
		}
	}

}
