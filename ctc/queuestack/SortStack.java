package queuestack;
import java.util.Stack;
import java.util.Random;

public class SortStack {
	
	public static void main(String [] args){
		Random rand = new Random();
		Stack <Integer> stack = new Stack<Integer>();
		for(int i=0;i<5;i++){
			stack.push(rand.nextInt(5));
			//stack.push(5-i);
		}
		displayAll(stack);
		displayAll(sortStack(stack));
	}
	
	public static void displayAll(Stack<Integer> stack){
		//System.out.println(stack.size());
		for(int i=stack.size()-1;i>=0;i--){
			System.out.print(stack.get(i)+" ");
		}
		System.out.println();
	}
	
	
	
	
	public static Stack<Integer> sortStack(Stack <Integer>pStack){
		//create a temp stack
		Stack <Integer>tStack = new Stack<Integer>();
		
		while( ! pStack.isEmpty()){
			int temp = pStack.pop();
			while(! tStack.isEmpty() && tStack.peek() > temp){
				pStack.push(tStack.pop());
			}
			tStack.push(temp);
		}
		return tStack;
	}
}
