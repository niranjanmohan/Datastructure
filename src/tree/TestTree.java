package tree;

import java.util.List;

public class TestTree {
	public static void main(String [] args){
		MyBTree btree = new MyBTree();
		 BinaryTree btree1 = new BinaryTree();
		
		btree.addNode(12, "president");
		btree.addNode(14, "director");
		btree.addNode(10, "boss");
		btree.addNode(2, "TL");
		btree.addNode(3, "tester");
		btree.addNode(5, "testing lead");
		btree.addNode(1, "s/w developer");
		
		btree.addNode(7, "archnitect");
		btree.addNode(11,"Vice Predident");
	
		btree.addNode(16,"CEO");
		
//		btree1.addNode(10, "boss");
//		btree1.addNode(1, "s/w developer");
//		btree1.addNode(2, "TL");
//		btree1.addNode(3, "tester");
//		btree1.addNode(5, "testing lead");
//		btree1.addNode(7, "archnitect");
//		btree1.addNode(11,"Vice Predident");
//		btree1.addNode(12, "president");
//		btree1.addNode(14, "director");
//		btree1.addNode(16,"CEO");
		
		 MyBTree theTree = new MyBTree();
        theTree.addNode(50, "Boss");
        theTree.addNode(25, "Vice President");
        theTree.addNode(15, "Office Manager");
        theTree.addNode(30, "Secretary");
        theTree.addNode(75, "Sales Manager");
        theTree.addNode(65, "Sales Manager");
        theTree.addNode(85, "Salesman 1");
        theTree.addNode(22, "dddd 1");
        theTree.addNode(43, "dddd 1");
        theTree.addNode(27, "lalala 1");
        
        
        MyBTree newTree = new MyBTree();
        newTree.insertNode(50, "Boss");
        newTree.insertNode(25, "Vice President");
        newTree.insertNode(15, "Office Manager");
        newTree.insertNode(30, "Secretary");
        newTree.insertNode(75, "Sales Manager");
        newTree.insertNode(65, "Sales Manager");
        newTree.insertNode(85, "Salesman 1");
        newTree.insertNode(22, "dddd 1");
        newTree.insertNode(43, "dddd 1");
        newTree.insertNode(27, "lalala 1");
        newTree.insertNode(100, "lalala 1");
        newTree.insertNode(101, "lalala 1");
        newTree.insertNode(102, "lalala 1");
//        
        
// 
//        System.out.println("\nNode with the key 75");
//        System.out.println(theTree.findNode(75));
//		theTree.inOrderTraversal();
//		System.out.println("--------------------");
//		theTree.preOrderTraversal();
//		
//		System.out.println("--------------------");
//		theTree.postOrderTraversal();
//		System.out.println();
		
        
        theTree.inOrderTraversal();
       System.out.println("deleting node *****"+theTree.deleteNode(25));
        System.out.print("\n in order rec :");
        theTree.inOrderTraversal();
        System.out.print("\n in order rec 2:");
        newTree.inOrderTraversal();
        
        
        System.out.print("\n in order  it :");
        theTree.inOrderTraversalIT();
        
        System.out.print("\n preorder rec :");
        theTree.preOrderTraversal();
        System.out.print("\n preorder it  :");
        theTree.preOrderTraversalIT();
        
        System.out.print("\n post order rec :");
        theTree.postOrderTraversal();
        System.out.print("\n post order it :");
        theTree.postOrderTraversalIT();
        
        System.out.println("----------------");
      
		//System.out.println(btree.findNode(13));
		
        System.out.println("search for the no "+theTree.dfs( theTree.rootNode,85));
        System.out.println("search for the no "+theTree.bfs(theTree.rootNode, 85));
        System.out.println(theTree.treeHeight());
		//deletion of tree
		System.out.println("the balanced tree---->"+newTree.isNBalanced(theTree.rootNode));
		
		
		System.out.println(theTree.checkHeight(theTree.rootNode));
		System.out.println("find the node using non recursive bfs :"+theTree.bfsNR(22));
		System.out.println("find the node using non recursive dfs :"+theTree.dfsNR(22));
		
		System.out.println("No of nodes is "+newTree.size());
		
		//System.out.println("next node ");theTree.chkn(43);
		System.out.println("next node "+theTree.chkn(22));
		  System.out.println("Height of the tree is "+theTree.calcHeight());
		System.out.println("Diameter of a tree --->"+theTree.getDiameter());
		
		List<Integer> list= newTree.inOrderLoad();
		System.out.println(list.toString());
		
		theTree.inOrderTraversal();
		System.out.println();
		theTree.mirriorTree();
		System.out.println();
		theTree.inOrderTraversal();
		
		
	}

}
