package linkedlist;

import java.util.HashSet;
import java.util.Set;

import javax.management.RuntimeErrorException;

public class LinkedListNode {
	int data;
	LinkedListNode next;
	LinkedListNode prev;
	LinkedListNode head;
	LinkedListNode(int data){
		this.data = data;
	}
	LinkedListNode(){
		
	}
	public void setHead(){

	} 


	public void insertAfter(LinkedListNode n){
		if(n!=null && n != this){
			this.next = n;
			n.prev = this;
		}
	}
	public void insertBefore(LinkedListNode n){
		if(n!= null && n!=this){
			this.prev = n;
			n.next = this;
		}
	}
	public void printForward(){
		LinkedListNode temp = this;
		while (temp.next != null){
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
		System.out.print(temp.data);
		System.out.println();
		//System.out.println(this.data);
	}
	public void removeDuplicate(){
		LinkedListNode n = this.next;
		Set<Integer> lset = new HashSet<Integer>();
		lset.add(this.data);
		System.out.println(this.data);
		while(n.next !=null){
			if(!lset.add(n.data)){
				System.out.println("removing "+n.data);
				//remove the link 
				n.prev.next = n.next;
				n.next.prev = n.prev;
			}
			n = n.next;
		}
	}
	//no datastructure allowed
	public void removeDups(){
		LinkedListNode headNode = this;
		LinkedListNode runnerNode = this.next;
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
		LinkedListNode headNode = this;
		LinkedListNode runnerNode = this;
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
	public void printReverseR(LinkedListNode n){
		if(n ==null)
			System.out.println();
		else{
			printReverseR(n.next);
			System.out.print(n.data);	
		}
	}
	public void reverseLL(LinkedListNode n){
		LinkedListNode prev = null;
		LinkedListNode next = null;
		LinkedListNode cur = n;
		while(cur.next != null){
			next = cur.next;
			cur.next =prev;
			prev =cur;
			cur = next;
		}
		
	}

	public boolean deleteNode(LinkedListNode node){
		if(node ==null || node.next ==null)
			return false;
		node.data = node.next.data;
		node.next = node.next.next;
		return true;
	}

	//find Kth element recursive
	public static int findKR(LinkedListNode node,int k){
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


