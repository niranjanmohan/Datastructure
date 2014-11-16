package algorithm.sort;



import java.util.HashSet;
import java.util.Set;

public class LinkedList {
	char data;
	LinkedList next;
	LinkedList prev;
	LinkedList head;
	LinkedList(char data){
		this.data = data;
	}
	public LinkedList(){
		
	}
	public void setHead(){

	} 


	public void insertAfter(LinkedList n){
		if(n!=null && n != this){
			this.next = n;
		}
	}
	public void insertBefore(LinkedList n){
		if(n!= null && n!=this){
			this.prev = n;
			n.next = this;
		}
	}
	public void printForward(){
		LinkedList temp = this;
		while (temp.next != null){
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
		System.out.print(temp.data);
		System.out.println();
		//System.out.println(this.data);
	}
	//no datastructure allowed
	public void removeDups(){
		LinkedList headNode = this;
		LinkedList runnerNode = this.next;
		while(headNode.next !=null){
			while(runnerNode.next != null){
				if(runnerNode.data == headNode.data){
					//delete the node
					runnerNode.prev.next = runnerNode.next;
					runnerNode.next.prev = runnerNode.prev;
				}
				runnerNode = runnerNode.next;
			}
			headNode = headNode.next;
			runnerNode = headNode.next;
		}
	}
	public void findKElement(int index){
		LinkedList headNode = this;
		LinkedList runnerNode = this;
		for(int i=0;i<index-1;i++){
			if(runnerNode.next ==null)
				return;
			System.out.println("value i :"+i);
			runnerNode = runnerNode.next;
		}
		while(runnerNode.next != null){
			runnerNode = runnerNode.next;
			headNode = headNode.next;
		}
		System.out.println("the kth element :"+headNode.data);
	}
	public void printReverseR(LinkedList n){
		if(n ==null)
			System.out.println();
		else{
			printReverseR(n.next);
			System.out.print(n.data);	
		}
	}
	public void reverseLL(LinkedList n){
		LinkedList prev = null;
		LinkedList next = null;
		LinkedList cur = n;
		while(cur.next != null){
			next = cur.next;
			cur.next =prev;
			prev =cur;
			cur = next;
		}
		
	}

	public boolean deleteNode(LinkedList node){
		if(node ==null || node.next ==null)
			return false;
		node.data = node.next.data;
		node.next = node.next.next;
		return true;
	}

	//find Kth element recursive
	public static int findKR(LinkedList node,int k){
		if( node == null)
			return 0;
		int i  = findKR(node.next,k) + 1;
		//System.out.println("i -->"+i+" " +node.data);
		if(i==k){
			System.out.println(" the value of ith element"+ node.data);
		}
		return i;

	}
}


