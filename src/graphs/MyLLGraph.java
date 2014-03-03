package graphs;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class MyLLGraph {
	LLNode headNode ;
	List<LLNode> nodeList;
	int size;


	MyLLGraph(){
		size=0;
		nodeList = new ArrayList<LLNode>();
	}
	public LLNode createNode(String name){
		LLNode n = new LLNode(name);
		n.insertNode(size);
		size++;
		nodeList.add(n);
		if(headNode == null){
			System.out.println("setting head node");
			headNode = n;
		}
		return n;
	}
	
	public void connectNode(LLNode n1,LLNode n2){
		//get index of both the nodes
		int index1 = n1.getIndex();
		int index2 = n2.getIndex();
		LLNode node1 = nodeList.get(index1);
		LLNode node2 = nodeList.get(index2);
		node1.insertNode(node2.getIndex());
		node2.insertNode(node1.getIndex());
		nodeList.set(node1.getIndex(), node1);
		nodeList.set(node2.getIndex(), node2);
	}
	public void dfs(){
		Stack <LLNode>stack = new Stack<LLNode>();
		stack.push(headNode);
		headNode.setState(true);
		System.out.println(headNode);
		while(! stack.isEmpty()){
			LLNode n = stack.peek();
			LLNode child  = getUnvisitedNode(n);
			if(child !=null){
				stack.push(child);
				System.out.println(child);
				child.setState(true);
			}
			else
				stack.pop();
		}
	}
	
	public void displayAll(){
		for(int i=0;i<nodeList.size();i++){
			System.out.print(nodeList.get(i).name);
		}
	
	}
	
	public LLNode getUnvisitedNode(LLNode n){
		//code to traverse through the list and get the indexes;
		//System.out.println("entered function");
		List <Integer>nList= n.getIndexes();
	//	System.out.println("unvisited nodes---"+nList.size());
		for(int i=0;i<nList.size();i++){
			//check if visited
			if(! nodeList.get(nList.get(i)).getState()){
				return  nodeList.get(nList.get(i));
			}
		}
		return null;
	}

}

