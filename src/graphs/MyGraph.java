package graphs;


import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class MyGraph {
	List <MyNode> nodeList = new ArrayList<MyNode>();
	MyNode rootNode;
	int adjMatrix[][];
	int size;

	public MyNode createMyNode(char label){
		MyNode newMyNode = new MyNode (label);
		return newMyNode;
	}
	public void addNode(MyNode n){
		nodeList.add(n);
	}
	public void setRootMyNode(MyNode n){
		this.rootNode = n;
	}
	public void connectNode(MyNode start,MyNode end){
		if(adjMatrix == null){
			this.size = nodeList.size();
			adjMatrix = new int[size][size];
		}
		int startIndex = nodeList.indexOf(start);
		int endIndex = nodeList.indexOf(end);
		adjMatrix[startIndex][endIndex]= 1;
		adjMatrix[endIndex][startIndex] =1;
	}
	public MyNode getUnvisitedChildNode(MyNode n){
		int index = nodeList.indexOf(n);
		for(int i=0;i<size;i++)
			if(adjMatrix[index][i]==1 && nodeList.get(i).isVisited ==false){
				return nodeList.get(i);
			}
		return null;
	}

	public void bfs(){
		Queue <MyNode>q = new LinkedList<MyNode>();
		q.offer(this.rootNode);
		System.out.println(rootNode);
		rootNode.isVisited = true;
		while (! q.isEmpty()){
			MyNode n = q.poll();
			MyNode child = null;
			while((child = getUnvisitedChildNode(n))!= null){
				child.isVisited = true;
				System.out.println(child);
				q.offer(child);
			}
		}
		clearNodes();
	}
	public void dfs(){
		Stack<MyNode> stack = new Stack<MyNode>();
		stack.push(rootNode);
		rootNode.isVisited = true;
		System.out.println(rootNode);
		while( ! stack.isEmpty()){
			MyNode n = stack.peek();
			MyNode child = getUnvisitedChildNode(n);
			if(child !=null){
				child.isVisited = true;
				System.out.println(child);
				stack.push(child);
			}
			else{
				stack.pop();
			}
		}
		clearNodes();
	}
	public void clearNodes(){
		for(int i=0;i<size ;i++){
			nodeList.get(i).isVisited = false;
		}
	}
}



class MyNode{
	char label;
	boolean isVisited;
	int cost;
	MyNode(char label){
		this.label = label;
	}
	public String toString(){
		return String.valueOf(this.label);
	}
}


