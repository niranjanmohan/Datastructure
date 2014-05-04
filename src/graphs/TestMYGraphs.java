package graphs;

public class TestMYGraphs {
	public static void main(String [] args){

		
		//Lets create nodes as given as an example in the article
	
		MyGraph graph = new MyGraph();
		MyLLGraph lgraph = new MyLLGraph();
		MyNode nA = graph.createMyNode('A');
		MyNode nB = graph.createMyNode('B');
		MyNode nC = graph.createMyNode('C');
		MyNode nD = graph.createMyNode('D');
		MyNode nE = graph.createMyNode('E');
		MyNode nF = graph.createMyNode('F');
		
		
		
		LLNode nlA = lgraph.createNode("A");
		LLNode nlB = lgraph.createNode("B");
		LLNode nlC = lgraph.createNode("C");
		LLNode nlD = lgraph.createNode("D");
		LLNode nlE = lgraph.createNode("E");
		LLNode nlF = lgraph.createNode("F");
		//Create the graph, add nodes, create edges between nodes
		//Graph g=new Graph();
		graph.addNode(nA);
		graph.addNode(nB);
		graph.addNode(nC);
		graph.addNode(nD);
		graph.addNode(nE);
		graph.addNode(nF);
		graph.setRootMyNode(nA);
		
		graph.connectNode(nA,nB);
		graph.connectNode(nA,nC);
		graph.connectNode(nA,nD);
		graph.connectNode(nB,nE);
		graph.connectNode(nB,nF);
		graph.connectNode(nC,nF);
		
		//connecting the new graph
		
		lgraph.connectNode(nlA,nlB);
		lgraph.connectNode(nlA,nlC);
		lgraph.connectNode(nlA,nlD);
		lgraph.connectNode(nlB,nlE);
		lgraph.connectNode(nlB,nlF);
		lgraph.connectNode(nlC,nlF);
		
		
		
		//Perform the traversal of the graph
		System.out.println("DFS Traversal of a graph is ------------->");
		graph.dfs();
		
		System.out.println("\nBFS Traversal of a graph is ------------->");
		graph.bfs();
		
		lgraph.displayAll();
		System.out.println("\n the new ll graph");
		lgraph.dfs();
		
		
	
	}

}
