package questions.linkedlist;
/*
 * You have two numbers represented by a linked list, where each node 
 * contains a single digit. The digits are stored in reverse order, 
 * such that the 1’s digit is at the head of the list. Write a function 
 * that adds the two numbers and returns the sum as a linked list. 
 * EXAMPLE
 * Input: (3 -> 1 -> 5), (5 -> 9 -> 2)
 * Output: 8 -> 0 -> 8
 * i.e. 513 + 295 = 808
 */
public class LinkedList {
	protected Node head;
	protected Node tail;
	public final class Node {
		int data;
		Node next;
	
		public Node() {}	
		public Node(int d) {
			data = d;
		}
		public Node(int d, Node n) {
			data = d;
			next = n;
		}
			public int getData() {
			return data;
		}			
		public Node getNext() {
			return next;
		}
	}
	
	public LinkedList()
		{}
	public LinkedList(int data[]) {
		for (int i = 0; i < data.length; i++) {
			append(data[i]);
		}
	}
	public void purge() {
		head = null;
		tail = null;
	}
	public Node getHead() {
		return head;
	}
	public Node getTail() {
		return tail;
	}		
	public boolean isEmpty() {
		return head == null;
	}
		
	public void append(int d) {
		Node node = new Node(d, null);
		if (tail == null) head = node;
		else tail.next = node;
		tail = node;
	}
	public void prepend(int d) {
		Node node = new Node(d, head);
		if (head == null) tail = node;
		head = node;
	}
	public void print() {
		if (head == null) return;
		Node curr = head;
		while (curr != null) {
			System.out.print(curr.data + " ");
			curr = curr.next;
		}
		System.out.println();
	}
 
	public static LinkedList addLists(LinkedList l1, LinkedList l2) {
		if (l1 == null && l2 == null) return null;
		LinkedList ret = new LinkedList();
		Node curr1 = l1.head;
		Node curr2 = l2.head;
		int result = 0;
		while (curr1 != null && curr2 != null) {
			result += (curr1.data + curr2.data);
			if (result < 10) {
				ret.append(result);
				result = 0;
			}
			else if (result >= 10) {
				ret.append(result-10);
				result = result - 9;
			}
			curr1 = curr1.next;
			curr2 = curr2.next;
		}
		if (curr1 != null) {
			while (curr1 != null) {
				ret.append(curr1.data);
				curr1 = curr1.next;
			}
		}
		if (curr2 != null) {
			while (curr2 != null) {
				ret.append(curr2.data);
				curr2 = curr2.next;
			}
		}
		return ret;
	}
	public static void main(String args[]) {
		int data1[] = {3, 1, 5};
		int data2[] = {5, 9, 2};
		LinkedList l1 = new LinkedList(data1);
		LinkedList l2 = new LinkedList(data2);
		LinkedList list = addLists(l1, l2);
		list.print();
	}
}