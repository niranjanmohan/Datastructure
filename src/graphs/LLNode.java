package graphs;

import java.util.ArrayList;
import java.util.List;


class LLNode{
	NodeG headNode;
	String name;

	LLNode(String name){
		this.name = name;
	}

	public void insertNode(int index){
		NodeG n = new NodeG(index);
		NodeG curNode = headNode;
		if(headNode ==null){
			headNode = n;
			headNode.next =null;
		}
		else{
			while(curNode.next !=null)
				curNode = curNode.next;
			System.out.println("seting the next node "+index);
			curNode.next= n;
		}	
	}
	public void setState(boolean state){
		headNode.isVisited = state;
	}
	public boolean getState(){
		return headNode.isVisited;
	}
	public List getIndexes(){
		List<Integer> ls = new ArrayList<Integer>();
		NodeG curNode = headNode.next;
		while(curNode !=null){
			ls.add(curNode.index);
			curNode = curNode.next;
		}
		return ls;	
	}
	public int getIndex(){
		return headNode.index;
	}
	public String toString(){
		return this.name;
	}
}

class NodeG{
	int index;
	boolean isVisited;
	NodeG next;
	NodeG(int index){
		this.index = index;
		isVisited = false;
	}

}
