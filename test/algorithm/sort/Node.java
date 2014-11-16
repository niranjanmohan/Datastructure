package algorithm.sort;


class Node{
	Node next;
	Node head;
	char data;
	Node curNode;
	public Node(char data){
		this.data = data;
		head =this;
	}


	public void printAll(){
		Node n = head;
		while(n !=null){
			System.out.println(n.data);
			n = n.next;
		}
	}
	public void insertAfter(Node n){
		curNode = head;
		while(curNode != null && curNode.next !=null )
			curNode = curNode.next;
		curNode.next = n;
	}
}