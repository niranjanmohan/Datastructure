package datastructureimpl;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;


public class TestDS {
	public static void main(String [] args){
		
		
		
		/*********************TESTING LIST IMPLEMENTATION***********************/
		MyList<Integer> list= new MyList<Integer>();
		Random rand = new Random();
		for(int i=0;i<10;i++)
			list.add(rand.nextInt(20));
		for(int i=0;i<list.size();i++)
			System.out.print(list.get(i)+ " ");

		System.out.println("size:"+list.size());
		list.remove(1);
		for(int i=0;i<list.size();i++)
			System.out.print(list.get(i)+ " ");

		
		/*********************TESTING STACK IMPLEMENTATION***********************/		
		
		MyStack<Integer> stack = new MyStack<Integer>();
		for(int i=0;i<2;i++){
			//int no =rand.nextInt(20);System.out.print("-"+no);
			System.out.print("val:"+i);
			stack.push(i);
		}
		System.out.println("\n"+stack.size());
		for(int i=0;i<5;i++)
			System.out.print(" "+stack.pop());
		System.out.println(stack.pop());
		
		
		/*********************TESTING MAP IMPLEMENTATION***********************/
		MyMap<String,String> mymap = new MyMap<String,String>();
		mymap.put("1", "one");
		mymap.put("2", "two");
		mymap.put("3", "three");
		mymap.put("4", "four");
		mymap.put("5", "five");
		System.out.println(mymap.get("1"));
		System.out.println(mymap.get("5"));
		mymap.remove("1");
		Set <String>s = mymap.getKeySet();
		Iterator<String> it = s.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
		/*********************TESTING HASH TABLE IMPLEMENTATION***********************/
		
		
		
	}
}

