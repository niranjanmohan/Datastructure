package linkedlist;

import java.util.Random;

public class TestRunner {
	public static void main(String [] args){
		LinkedListNode headNode = new LinkedListNode(0);
		//fill in the node with random values
		LinkedListNode ll = new LinkedListNode(1);
		headNode.insertAfter(ll);
		Random random = new Random();
		for(int i=2;i<10;i++){
			LinkedListNode n = new LinkedListNode(i);
			ll.insertAfter(n);
			ll = ll.next;
		}
		headNode.printForward();
		headNode.printReverseR(headNode);
		
		//headNode.removeDups();
		System.out.println("after remove ");
		headNode.findKElement(3);
		
		LinkedListNode.findKR(headNode, 3);
		headNode.printForward();
		
		headNode.reverseLL(headNode);
		headNode.printForward();
		
		
		
		LinkedListNode l1 = new LinkedListNode(1);
		LinkedListNode headl1 = l1;
		l1.insertAfter(new LinkedListNode(2));
		l1 = l1.next;
		l1.insertAfter(new LinkedListNode(9));
		l1 = l1.next;
		l1.insertAfter(new LinkedListNode(4));
		l1 = l1.next;
		headl1.printForward();
		
		System.exit(0);
		
		LinkedListNode l2 = new LinkedListNode(1);
		LinkedListNode headl2 = l2;
		l2.insertAfter(new LinkedListNode(2));
		l2 = l2.next;
		l2.insertAfter(new LinkedListNode(9));
		l2 = l2.next;
		l2.insertAfter(new LinkedListNode(4));
		l2 = l2.next;
		headl2.printForward();
		
		System.out.println("#############");
		
		
		LinkedListNode pal = new LinkedListNode(0);
		LinkedListNode palHead = pal;
		pal.insertAfter(new LinkedListNode(2));
		pal = pal.next;
//		pal.insertAfter(new LinkedListNode(3));
//		pal = pal.next;
		pal.insertAfter(new LinkedListNode(2));
		pal = pal.next;
		pal.insertAfter(new LinkedListNode(0));
		pal = pal.next;
		
		palHead.printForward();
		System.out.println("after");
		
		LinkListUtil.addNumberR(headl1, headl2, 0).printForward();
		LinkListUtil.addNumber(headl1, headl2).printForward();
		
		System.out.println("###$$$$#####");
		System.out.println(LinkListUtil.isPalindrome(palHead));
		
		
		
		
		
	}

}
