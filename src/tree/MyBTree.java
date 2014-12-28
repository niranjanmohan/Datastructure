package tree;

import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class MyBTree {
	Node rootNode;

	public void addNode(int key ,String value){
		Node newNode = new Node(key,value);
		if(rootNode == null){
			rootNode = newNode;
		}
		else{
			Node curNode = rootNode;
			Node parentNode;
			while(true){
				parentNode = curNode;
				if(key < curNode.key){
					curNode = curNode.leftChild;

					if(curNode == null){
						parentNode.leftChild = newNode;
						return;
					}
				}
				else{
					curNode = curNode.rightChild;
					if(curNode == null){
						parentNode.rightChild = newNode;
						return;
					}
				}
			}
		}
	}
	public void insertNode (int key,String value){
		Node curNode = rootNode;
		if(rootNode ==null)
			rootNode =	addNodeR(curNode,key,value);
		else
			addNodeR(curNode,key,value);
	}
	public Node addNodeR(Node curNode,int key,String value){
		if(curNode == null){
			curNode = new Node(key,value);
		}

		else if(key >curNode.key)
			curNode.rightChild = addNodeR(curNode.rightChild,key,value);
		else
			curNode.leftChild = addNodeR(curNode.leftChild, key, value);
		return curNode;
	}
	public int calcHeight(){
		return calcHeight(rootNode);
	}

	public int calcHeight(Node curNode){
		//int height;

		if(curNode == null)
			return -1;
		int lefth=0;
		int righth=0;

		//find height in left node
		lefth = calcHeight(curNode.leftChild);
		righth = calcHeight(curNode.rightChild);

		if(lefth > righth)
			return lefth+1;
		else
			return righth+1;

		//can be writter as return max(calcHeight(curNode.leftChild),calcHeight(curNode.rightCHild));

	}
	public int findHeight(Node aNode)
	{
		if(aNode == null)
			return -1;

		int lefth = findHeight(aNode.leftChild);
		int righth = findHeight(aNode.rightChild);

		if(lefth > righth)
			return lefth + 1;
		else
			return righth +1;
	}

	//******************************RECURSIVE TRAVERSAL****************************************

	public void inOrderTraversal(){
		//System.out.println("the root node is :"+ rootNode);
		inOrderTraversal(rootNode);
	}
	//static List <Integer> blist = new ArrayList<Integer>();
	public static void inOrderTraversal(Node curNode){
		if(curNode != null){
			inOrderTraversal(curNode.leftChild);
			System.out.print(curNode);
			inOrderTraversal(curNode.rightChild);
		}
	}
	public void preOrderTraversal(){
		//System.out.println("the root node is :"+ rootNode);
		preOrderTraversal(rootNode);
	}
	public void postOrderTraversal(){
		//System.out.println("the root node is :"+ rootNode);
		postOrderTraversal(rootNode);
	}
	public void preOrderTraversal(Node curNode){
		if(curNode != null){
			System.out.print(curNode);
			preOrderTraversal(curNode.leftChild);
			preOrderTraversal(curNode.rightChild);
		}
	}
	public void postOrderTraversal(Node curNode){
		if(curNode != null){
			postOrderTraversal(curNode.leftChild);
			postOrderTraversal(curNode.rightChild);
			System.out.print(curNode);
		}
	}
	//**********************************************************END RECURSIVE TRAVERSAL*************************************************


	public void preOrderTraversalIT(){
		Stack <Node> stack = new Stack<Node>();
		stack.push(rootNode);
		while( ! stack.isEmpty()){
			Node node = stack.pop();
			if(node.rightChild != null)
				stack.push(node.rightChild);
			if(node.leftChild !=null)
				stack.push(node.leftChild);
			System.out.print(node+" ");
		}
	}

	public void inOrderTraversalIT(){
		Stack<Node> stack = new Stack<Node>();
		Node node = rootNode;
		while(! stack.isEmpty() || node !=null){
			if(node !=null){
				stack.push(node);
				node= node.leftChild;
			}
			else{
				node =stack.pop();
				System.out.print(node+ " ");
				node = node.rightChild;
			}
		}
	}

	public void postOrderTraversalIT(){
		Stack <Node>s1 = new Stack<Node>();
		Stack <Node>s2 = new Stack<Node>();
		s1.push(rootNode);
		while(! s1.isEmpty()){
			Node n = s1.pop();

			s2.push(n);
			if(n.leftChild !=null)
				s1.push(n.leftChild);
			if(n.rightChild !=null)
				s1.push(n.rightChild);

		}
		while(! s2.isEmpty()){
			System.out.print(s2.pop()+" ");
		}
	}


	//*********************************Search for a node in a tree BFS and DFS Recursive Solution********************************************


	public boolean dfs(Node curNode,int i){
		if (curNode !=null){
			//search children
			//System.out.println(curNode.key + "value of i"+i+(curNode.key == i));
			if(curNode.key ==i)
				return true;
			if(dfs(curNode.leftChild,i))
				return true;
			if(dfs(curNode.rightChild,i))
				return true;

		}
		return false;
	}
	public boolean bfs(Node curNode,int i){
		if(curNode !=null){
			//search children
			if(bfs(curNode.leftChild,i))
				return true;
			if(bfs(curNode.rightChild,i))
				return true;	
			if(curNode.key == i)
				return true;
		}
		return false;
	}
	//******************************************************* END ********************************************************************************

	//**********************************************Search for node NON-RECURSIVE solution **************************************************


	public boolean  bfsNR(int i){
		Queue <Node> q = new LinkedList<Node>();
		q.add(rootNode);

		while(! q.isEmpty()){
			Node n = q.poll();
			System.out.print(n.key+" ");
			if(n.key == i)
				return true;
			if(n.leftChild !=null)
				q.offer(n.leftChild);
			if(n.rightChild !=null)
				q.offer(n.rightChild);
		}
		return false;
	}

	public boolean dfsNR(int i){
		Stack <Node> s = new Stack<Node>();
		s.push(rootNode);
		while(! s.isEmpty()){
			Node n = s.pop();
			System.out.print(n.key+" ");
			if(n.leftChild !=null)
				s.push(n.leftChild);
			if(n.rightChild !=null)
				s.push(n.rightChild);
			if(n.key == i)
				return true;
		}
		return false;

	}




	//**************************************NON-RECURSIVE search end******************************





	// ********************************Not efficient algorithm to check if balanced********************************************
	public int getHeight(Node curNode){
		if(curNode == null)
			return 0;
		else 
			return (getHeight(curNode.leftChild) + getHeight(curNode.rightChild)) +1;
	}
	public boolean isBalanced(Node curNode){
		if( curNode ==null)
			return true;
		int hdiff = getHeight(curNode.rightChild) -getHeight(curNode.leftChild);
		if(Math.abs(hdiff) >1 )
			return false;
		else
			return isBalanced(curNode.leftChild) && isBalanced(curNode.rightChild);
	}
	public int getDiameter(){
		return getDiameter(rootNode);
	}
	public int getDiameter(Node rootNode){
		if(rootNode == null)
			return 0;
		int rootDia =(getHeight(rootNode.rightChild)+getHeight(rootNode.leftChild));
		int leftDia = getDiameter(rootNode.leftChild);
		int rightDia = getDiameter(rootNode.rightChild);
		return Math.max(Math.max(leftDia, rightDia), rootDia);
	}

	//*******************************************************************************************************************



	//******************************************modified getheight to checkheight to improve the running time**************************

	public int size(){
		return size(rootNode);
	}

	public int size(Node n){
		if(n != null){
			return (size(n.leftChild)+1+size(n.rightChild));
		}
		return 0;
	}


	public int checkHeight(Node curNode){

		if(curNode == null)
			return 0;
		int leftH = checkHeight(curNode.leftChild);
		if(leftH == -1)
			return -1;
		int rightH = checkHeight(curNode.rightChild);
		if(rightH ==-1)
			return -1;
		int diffH = rightH-leftH;
		if(Math.abs(diffH) > 1)
			return -1;
		else
			return Math.max(leftH, rightH)+1;
	}

	public boolean isNBalanced(Node curNode){
		System.out.println("HHHHHHHHHHHHHHHHHHHHHH---->"+checkHeight(rootNode));
		if(checkHeight(rootNode) == -1)
			return false;
		else{
			return true;
		}
	}



	//************************************End of the efficient algo for check height ***********************************


	public int treeHeight(){
		return getHeight(rootNode);
	}


	public Node findNode(int key){
		Node curNode = rootNode;
		while (curNode.key != key){
			if(key < curNode.key){
				curNode = curNode.leftChild;
			}
			else
				curNode = curNode.rightChild;
			if(curNode == null){
				return null;
			}
		}
		return curNode;

		//********************************************Deletion of Node from Tree ****************************************************************

	}
	public boolean deleteNode(int key){
		//first find the node 
		Node curNode = rootNode;
		Node parentNode =null;
		boolean isLeftNode = false;
		while(curNode.key != key){
			parentNode = curNode;
			if(key < curNode.key){
				isLeftNode = true;
				curNode = curNode.leftChild;
			}
			else{
				isLeftNode = false;
				curNode = curNode.rightChild;
			}

			if(curNode == null)
				return false;
		}

		//node has no children
		if(curNode.leftChild ==null && curNode.rightChild == null){
			//condition for root node
			if(curNode == rootNode)
				rootNode =null;

			else if(isLeftNode)
				parentNode.leftChild = null;
			else
				parentNode.rightChild = null;
		}


		//node has no left child
		else if(curNode.leftChild == null){
			if(curNode == rootNode){
				rootNode = curNode.rightChild;
			}
			else if(isLeftNode){
				parentNode.leftChild = curNode.rightChild;
			}
			else{
				parentNode.rightChild = curNode.rightChild;
			}
		}
		//node has not right child
		else if(curNode.rightChild == null){
			if(curNode == rootNode){
				rootNode = curNode.leftChild;
			}
			else if(isLeftNode)
				parentNode.leftChild = curNode.leftChild;
			else
				parentNode.rightChild = curNode.leftChild;

		}
		//if the node has both children
		else{
			Node replaceNode = getReplacementNode(curNode);	
			if(curNode ==rootNode){
				rootNode = replaceNode;
			}
			else if(isLeftNode){
				parentNode.leftChild = replaceNode;
			}
			else
				parentNode.rightChild = replaceNode;
			replaceNode.leftChild = curNode.leftChild;
			//System.out.println("outside the leftNode"+curNode.leftChild);
		}

		return true;
	}
	private Node getReplacementNode(Node curNode){
		Node replaceNode = curNode;
		Node replaceParentNode = curNode;
		Node cursorNode = curNode;
		cursorNode = replaceNode.rightChild;
		while(cursorNode != null){
			replaceParentNode =replaceNode;
			replaceNode= cursorNode;
			cursorNode= cursorNode.leftChild;
		}
		if(curNode.rightChild != replaceNode){
			replaceParentNode.leftChild = replaceNode.rightChild;
			replaceNode.rightChild = curNode.rightChild;
			//System.out.println("left :"+curNode.leftChild);
		}
		return replaceNode;
	}

	//****************************************************************************End Deletion of Node from a Tree********************************************

	//******************************To balanced an unbalanced tree first put the elements to an array and then create min tree******************************

	//Step 1: In-order traversal to load elements from tree into an array
	public List<Integer> inOrderLoad(){
		List<Integer> list = new ArrayList<Integer>();
		inOrderLoad(rootNode,list);
		return list;
	}

	public void inOrderLoad(Node curNode,List<Integer> list){
		if(curNode !=null){
			inOrderLoad(curNode.leftChild, list);
			list.add(curNode.key);
			inOrderLoad(curNode.rightChild,list);
		}
	}







	//Step 2: Create Min tree from the array (sorted from in-order traversal)
	public Node createMinTree (int array[]){
		return createMinTree(array,0,array.length);
	}
	public Node createMinTree(int array[], int start,int end){
		if(end < start){
			return null;
		}
		int middle = (start+end)/2;
		Node n = new Node(array[middle]);
		n.leftChild = createMinTree(array,start,middle-1);
		n.rightChild = createMinTree(array,middle+1,end);
		return n;
	}





	//**************************end create Min tree


	//***********************************************find own sub tree***************************************************
	public int chkn(int i){
		return chkn(rootNode,i);
	}
	static boolean b;
	public Integer chkn(Node n,int i){
		if(n != null){

			if(chkn(n.leftChild,i) == i ) ;	

			if(i == n.key){
				System.out.println("truee");
				b=true;
			}

			if(b){
				System.out.println(n.key);
				return n.key; 
				//return n.key;
			}

			if(chkn(n.rightChild,i)== i) ;

		}
		return 0;
	}




	public Node getNextNode(Node n){
		if(n==null)
			return null;

		if(n.rightChild != null){
			return findLeftMost(n.rightChild);
		}
		else{
			Node p = n.parentNode;
			Node c = n;
			while(c!= null && p.leftChild != c  ){
				p = p.parentNode;
				c= p;
			}
			return p;
		}
	}
	public Node findLeftMost(Node n){
		while(n.leftChild !=null)
			n = n.leftChild;
		return n;
	}

	//function to create a linked list of nodes from each level
	public List<LinkedList<Node>> createLevelLinkedList(Node curNode){
		List<LinkedList<Node>> result = new ArrayList<LinkedList<Node>>();
		LinkedList<Node> current = new LinkedList<Node>();
		curNode = rootNode;
		if(curNode !=null){
			current.add(curNode);
		}
		while(current.size() > 0){
			result.add(current);
			LinkedList<Node> parent = current;//marking parent for traversal to next level
			current = new LinkedList<Node>();
			for(int i=0;i<parent.size();i++){
				if(parent.get(i).leftChild != null){
					current.add(parent.get(i).leftChild);
				}
				if(parent.get(i).rightChild != null){
					current.add(parent.get(i).rightChild);
				}
			}
		}
		return result;
	}



	//print the tree diagonal 
	public void diagonalTraverse(){
		List<LinkedList<Node>> ll =this.diagonalTraverse(rootNode);
		System.out.println();
		for(LinkedList<Node> n : ll)
			System.out.print("--"+n.toString()+"---");
	}

	public List<LinkedList<Node>> diagonalTraverse(Node node){
		List<LinkedList<Node>> result =  new ArrayList<LinkedList<Node>>();
		LinkedList<Node>ll = new LinkedList<Node>();
		addAllRightNodes(ll,node);
		while(ll.size() > 0){
			result.add(ll);
			LinkedList<Node> tempList = new LinkedList<Node>();
			for(int i=0;i<ll.size();i++){
				Node n = ll.get(i);
				if(n.leftChild != null){
					addAllRightNodes(tempList,n.leftChild);
				}
			}
			ll = tempList;
		}
		return result;
	}

	public void addAllRightNodes(LinkedList<Node> ll ,Node n){
		ll.add(n);
		//		System.out.println(n.rightChild);
		while(n.rightChild != null){
			ll.add(n.rightChild);
			n = n.rightChild;
		}
	}



	// mirrior of a tree
	public void mirriorTree(){
		mirriorTree(rootNode);
	}

	public void mirriorTree(Node node){
		if(node == null )
			return;
		mirriorTree(node.leftChild);
		mirriorTree(node.rightChild);
		swap(node);
	}
	public void swap(Node node){
		Node temp = node.leftChild;
		node.leftChild = node.rightChild;
		node.rightChild = temp;
	}

	public void spiral(){
		printSpiral(rootNode);
	}
	public  void printSpiral(Node node){
		List<LinkedList<Node>> list = new ArrayList<LinkedList<Node>>();
		if(node == null){
			return;
		}
		LinkedList<Node> ll = new LinkedList<Node>();
		ll.add(node);
		LinkedList<Node> parent ;
		int turnCount=0;
		while(ll.size() >0){
			list.add(ll);
			turnCount ++;
			parent = ll;
			ll = new LinkedList<Node>();

			if(turnCount%2 !=0){
				for(int i=0;i<parent.size();i++){
					Node n = parent.get(i);
					if(n.leftChild != null)
						ll.add(n.leftChild);
					if(n.rightChild != null)
						ll.add(n.rightChild);
				}
			}
			else{
				for(int i=parent.size()-1;i>=0;i--){
					Node n= parent.get(i);
					if(n.rightChild != null)
						ll.add(n.rightChild);
					if(n.leftChild != null)
						ll.add(n.leftChild);
				}
			}


		}

		for(LinkedList<Node> llp:list)
			System.out.println(llp.toString());


	}





	public class Node{
		int key;
		String name;

		Node leftChild;
		Node rightChild;
		Node parentNode;
		Node (int key){
			this.key = key;
		}
		Node(int key,String name){
			this.key = key ;
			this.name = name;
		}
		public  String toString(){
			return (this.name+"--");
		}
	}

}
