package LinkedList;
class LinkedList{
	Node headNode;
	Node curNode;
	public LinkedList() {
		curNode = headNode;
	}
	public static void main(String [] args){
		LinkedList ll = new LinkedList();
		ll.addNode(1);
		ll.addNode(2);
		ll.addNode(3);
		ll.addNode(4);
		ll.addNode(5);
		ll.addNode(6);
		ll.addNode(7);
		ll.addNode(8);
		ll.printNodes();
		ll.reverse();
		ll.printNodes();
	}
	public void reverse(){
		Node cur = headNode;
		Node prev = null;
		Node nxt =null;
		while(cur !=null){
			nxt = cur.next;
			cur.next = prev;
			prev = cur;
			cur =nxt;
		}
		headNode =prev;
		System.out.println();
	}


	public void addNode(int value){
		Node n = new Node(value);

		if(headNode == null){
			headNode = n;
			curNode = n;
		}
		else{
			curNode.next = n;
			curNode = n;
		}
	}
	public void printNodes(){
		Node n = headNode;
		while(n != null){
			System.out.print(n+" ");
			n = n.next;
		}
	}

	class Node {
		Node next;
		int value;
		Node (int value){
			this.value = value;
		}
		public String toString(){
			return String.valueOf(this.value);
		}
	}
}