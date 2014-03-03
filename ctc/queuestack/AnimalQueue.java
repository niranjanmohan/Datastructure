package queuestack;

import java.util.Queue;
import java.util.LinkedList;

public class AnimalQueue {
	public Queue <Animal>dogQ;
	public Queue <Animal>catQ;
	
	public AnimalQueue() {
		// TODO Auto-generated constructor stub
		dogQ = new LinkedList<Animal>();
		catQ = new LinkedList<Animal>();
	}
	
	public void enqueue(Animal animal){
		if (animal instanceof Dog ){
			dogQ.offer(animal);
		}
		else if(animal instanceof Cat){
			catQ.offer(animal);
		}
		else
			throw new RuntimeException("Invalid animal into shed");
	}
	public Animal dequeueAny(){
		if(dogQ.isEmpty() && catQ.isEmpty())
			return null;
		else if(dogQ.isEmpty() && ! catQ.isEmpty())
			return catQ.poll();
		else if(! dogQ.isEmpty() && catQ.isEmpty())
			return dogQ.poll();
		else{
			//System.out.println("comparing dates"+dogQ.peek().getEntryDate().compareTo(catQ.peek().getEntryDate()));
			if(dogQ.peek().getEntryDate().getTime() < (catQ.peek().getEntryDate().getTime()) )
				return dogQ.poll();
			else
				return catQ.poll();
			
		}
	}
	public Animal dequeueDog(){
		if(dogQ.isEmpty())
			return dogQ.poll();
		else
			return null;
	}
	public Animal dequeueCat(){
		if(catQ.isEmpty())
			return catQ.poll();
		else
			return null;
	}	
}
