package questions.linkedlist;



public class LList {
	Node head;
	Node curr;
	LList (int value){
		Node n = new Node(value);
		head = n;
		curr= head;
	}
	public Cursor getCursor(){
		return new Cursor(head);
	}
	public LList() {
		head =null;
		curr=null;
	}
	public Node currentNode(){
		return curr;
	}
	public Node headNode(){
		return head; 
	}
	public void insertNode(int value){
		if(head ==null){
			Node n = new Node(value);
			head = n;
			curr= head;
		}
		else{
		Node n = new Node (value);
		curr.next = n;
		curr = n;
		n.next = null;
		}
	}
	public void displayAll(){
		Node n = head;
		while(n !=null){
			System.out.print(n.value+" ");
			n= n.next;
		}
	}
	class Node {
		Node next;
		int value;
		Node(int value){
			this.value = value;
		}
	}
	class Cursor{
		Node current;
		Cursor(){
			current = head;
		}
		Cursor(Node n){
			this.current = n;
		}
		public void next(){
			if(current != null)
				current = current.next;
		}
		public boolean hasNext(){
			return current.next !=null ? true:false;
		}
		public void insertAfter(int value){
			Node n = new Node(value);
			Node temp = current.next;
			current.next = n;
			current = n;
			n.next = temp;
		}
		public Node getNode(){
			return current;
		}
		public void setValue(int i){
			current.value = i;
		}
		public int getValue(){
			return current.value;
		}
		public void setTail(){
			current.next=null;
		}
	}
	//to get the last kth or k elements recursive solution
	public int nthToLast(Node rnode,int k){
		if(rnode == null)
			return 0;
		int i = nthToLast(rnode.next,k)+1;
		if(i <= k)
			System.out.print(rnode.value+" ");
		return i;
	}
	
	
	
	//there is no point wasting time on this crap i ll write my own function
	
	public Node addNumbers(Node n1,Node n2, int carry){
		if(n1==null && n2==null && carry ==0){
			return null;
		}
		int value = carry;
		if(n1!=null)
			value += n1.value;
		
		if(n2!=null)
			value +=n2.value;
		
		Node result = new Node(carry%10);
		
		if(n1!=null || n2 !=null){
			Node more =addNumbers(n1==null ? null:n1.next ,n2==null ? null:n2.next,value >10 ?1:0 ); 
			result.next = more;
		}
		return result;
		
		
	}



}
