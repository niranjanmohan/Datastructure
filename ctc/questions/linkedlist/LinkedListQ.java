package questions.linkedlist;

import java.util.LinkedList;

import questions.linkedlist.LList.Node;

public class LinkedListQ {

	public static void main(String []args){
		LList list = new LList(0);
		for(int i=1;i<10;i++)
			list.insertNode(i);
		list.displayAll();



		LList.Cursor c1 = list.new Cursor();
		LList.Cursor c2 = list.new Cursor();

		while(c2.hasNext()){
			c2.next();
			if(c2.hasNext()){
				c2.next();
				c1.next();
			}
		}
		System.out.println(c1.getValue()+"-----"+c2.getValue());
		c2 =  list.new Cursor();
		while (c1.hasNext()){
			c1.next();
			c2.insertAfter(c1.getValue());

			if(c1.hasNext())
				c2.next();
			System.out.println(c1.getValue()+"-----"+c2.getValue());

		}
		c2.setTail();
		list.displayAll();
		//LinkedList <Integer>ls = new LinkedList<Integer>();
		System.out.println("k to end");
		list.nthToLast(list.headNode(), 5);
		
		
		//code to add 2 numbers
		LList l1 = new LList(1);
		LList l2 = new LList(9);
		l1.insertNode(5);
		l1.insertNode(4);
		l2.insertNode(2);
		l2.insertNode(2);
		
		LList r = addList(l1, l2);
		System.out.println(" \n result of adding numbers");
		l1.displayAll();System.out.println();l2.displayAll();System.out.println("\n ans :");
		r.displayAll();
		
		
		
		
		
	}
		public static LList addList(LList l1,LList l2){
			if(l1==null && l2 ==null)
				return null;
			LList flist = new LList();
			LList.Cursor c1 = l1.getCursor();
			LList.Cursor c2 = l2.getCursor();
			int result =0;
			
			System.out.println(c1);
			
			while(c1.current !=null || c2.current != null)
			{
				//System.out.println( c1+"--#####---"+c2);
				result += c1.getValue()+c2.getValue();
				//System.out.println( c1.getValue()+"--#####---"+c2.getValue());
				if(result <10 ){
					flist.insertNode(result);
					result =0;
				}
				else {
					flist.insertNode(result%10);
					result -= 9;
				}
				
				c1.next();c2.next();
			}	
			if(result !=0)
				flist.insertNode(result);
			return flist;
		}

}


