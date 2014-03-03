package queuestack;

import java.util.Date;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Random;
import java.util.Iterator;

public class TestApi {
	public static void main(String [] args) throws InterruptedException{
		Random rand = new Random();
		
		Queue<Integer> lq = new LinkedList<Integer>();
		for(int i=0;i<10;i++)
			lq.offer(rand.nextInt(10));
		
		lq.peek();
		Iterator it = lq.iterator();
		while(it.hasNext())
			System.out.print(it.next()+" ");
		System.out.println();
		for(int i=0;i<10;i++)
			System.out.print(lq.poll()+" ");
		
		Queue <Integer>pq = new PriorityQueue<Integer>();
		for(int i=0;i<10;i++)
			pq.offer(rand.nextInt(10));
		
		System.out.println();
		it = pq.iterator();
		while(it.hasNext()){
			System.out.print(it.next()+" ");
		}
		System.out.println();
		for(int i=0;i<10;i++)
			System.out.print(pq.poll()+" ");
		
		
		
		
		
		
		//Testing animal
		Animal dn,cn;
		AnimalQueue aq = new AnimalQueue();
		for(int i=0;i<10;i++){
			 dn = new Dog("dog "+String.valueOf(i));
			 aq.enqueue(dn);
			// Thread.sleep(200);
			 cn = new Cat("cat "+String.valueOf(i+10));
			 aq.enqueue(cn);
		}
		System.out.println();
		for(int i=0;i<15;i++){
		System.out.println(aq.dequeueAny());
		}
		
		aq.enqueue(new Cat(" trial "));
		
		
	}

}
