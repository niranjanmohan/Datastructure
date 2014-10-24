package linkedlist;

import java.util.Random;
import java.util.Stack;

public class LinkListUtil {
	public static LinkedListNode partition(int value){
		LinkedListNode headNode = new LinkedListNode(0);
		LinkedListNode ll = new LinkedListNode(1);
		headNode.insertAfter(ll);
		Random rand = new Random();
		for(int i=2;i<10;i++){
			LinkedListNode n = new LinkedListNode(rand.nextInt(10));
			ll.insertAfter(n);
			ll = ll.next;
		}

		headNode.printForward();


		//code to partition

		LinkedListNode beginHead=null;
		LinkedListNode beginEnd= null;
		LinkedListNode tailHead = null;
		LinkedListNode tailEnd = null ;

		ll = headNode;


		//test code to print all values

		//		while(ll != null){
		//			System.out.print("ll :"+ll.data);
		//			ll = ll.next;
		//		}
		//		System.out.println("end ");

		while(ll !=null){
			LinkedListNode llnext = ll.next;
			ll.next = null;
			if(ll.data < value){
				if(beginHead == null){
					beginHead = ll;
					beginEnd = beginHead;
				}
				else{
					beginEnd.next = ll;
					beginEnd= ll;
				}
			}
			else{
				if(tailHead == null){
					tailHead = ll;
					tailEnd = tailHead;
				}
				else{
					tailEnd.next =ll;
					tailEnd = ll;
				}
			}
			ll = llnext;
		}

		//merge the both the functions
		beginEnd.next = tailHead;	
		return beginHead;	
	}
	public static LinkedListNode addNumber(LinkedListNode l1,LinkedListNode l2){
		int carry=0,value;
		LinkedListNode result =null;
		LinkedListNode headResult = null;
		while(l1 != null && l2 !=null){
			value = l1.data+l2.data+carry;
			if(value >9)
				carry = 1;
			else
				carry = 0;
			value = value%10;
			if(result ==null){
				result = new LinkedListNode(value);
				headResult = result;
			}
			else{
				result.next = new LinkedListNode(value);
				result =result.next;
			}
			l1 = l1.next;
			l2 = l2.next;
		}
		while(l1 !=null){
			value = l1.data+carry;
			if(value >9){
				carry =1;
				value = value%10;
			}
			else
				carry =0 ;
			result.next = new LinkedListNode(value);
			result = result.next;
		}
		while(l2 !=null){
			value = l2.data+carry;
			if(value >9){
				carry =1;
				value = value%10;
			}
			else
				carry=0;
			result.next = new LinkedListNode(value);
			result = result.next;
		}
		if(carry != 0){
			result.next = new LinkedListNode(1);
			result =result.next;
		}
		return headResult;

	}

	public static LinkedListNode addNumberR(LinkedListNode l1,LinkedListNode l2,int carry){
		int value =carry;
		if(l1 ==null && l2 ==null && carry ==0)
			return null;

		if(l1 != null){
			value+= l1.data;
		}
		if(l2 !=null){
			value+=l2.data;
		}
		LinkedListNode result = new LinkedListNode(value>9?value%10:value);
		if(l1 !=null || l2 !=null){
			//recurse here
			LinkedListNode  moreNode = addNumberR(l1 ==null ? null:l1.next,
					l2 == null ? null:l2.next,
							value >9 ? 1:0);
			result.insertAfter(moreNode); 
		}
		return result;

	}

	public static boolean isPalindrome(LinkedListNode node){
		LinkedListNode sRunner = node;
		LinkedListNode fRunner = node;
		Stack<Integer> stack = new Stack<Integer>();
		while(fRunner !=null && fRunner.next !=null){
			fRunner = fRunner.next.next;
			stack.push(sRunner.data);
			sRunner = sRunner.next;
		}
		System.out.println("test :"+stack.toString());
		if(fRunner != null){
			sRunner = sRunner.next;
		}
		while(sRunner != null ){
			if(stack.pop().equals(sRunner.data))
				sRunner = sRunner.next;
			else
				return false;
		}

		return true;
	}





	public static void main(String [] args){
		LinkListUtil.partition(5).printForward();

	}

}
