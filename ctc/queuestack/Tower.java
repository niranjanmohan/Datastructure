package queuestack;

import java.util.Stack;

public class Tower {
	private Stack<Integer> disks;
	int index;
	public Tower(int i){
		index =i;
		disks = new Stack<Integer>();
	}
	public int index(){
		return index;
	}
	public void add(int d){
		if(!disks.isEmpty() && disks.peek() <= d){
			System.out.println("error in placing disk");
		}
		else{
			disks.push(d);
		}
	}
	public void moveTopTo(Tower t){
		int top =disks.pop();
		t.add(top);
		System.out.println("Move disk"+top +" from "+index+ " to "+t.index);
	}
	public void moveDisks(int n ,Tower destination,Tower buffer){
		if(n >0){
			this.moveDisks(n-1,buffer,destination);
			moveTopTo(destination);
			buffer.moveDisks(n-1,destination,this);
		}
	}
	public static void main(String [] args){
		//create three towers
		int n = 3;
		Tower t[] = new Tower[n];
		for(int i=0;i<3;i++){
			 t[i] = new Tower(i);
		}
		for(int i=n-1;i>=0;i--){
			t[0].add(i);
		}
		t[0].moveDisks(n, t[2], t[1]);
	}

}
