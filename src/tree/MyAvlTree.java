package tree;

public class MyAvlTree {
	Node rootNode;

	void insertNode(int key){
		//insert the normal way
		Node curNode = rootNode;
		if(rootNode == null)
			rootNode =addNode(curNode,key);
		else
			rootNode=addNode(curNode , key);

	}
	public int isBalanced(Node curNode){
		int l=0,r=0;
		if(curNode.rightChild !=null)
			r = curNode.rightChild.height;
		if(curNode.leftChild !=null)
			l = curNode.leftChild.height;
		return ( l-r);
	}
	
	public Node addNode(Node curNode,int key){
		if(curNode == null){
			Node n = new Node(key);
			return n;
		}
		else if(curNode.key > key){
			curNode.leftChild = addNode(curNode.leftChild,key);
		}
		else
			curNode.rightChild = addNode(curNode.rightChild,key);
		
		int l=0,r=0;
		//calculate height
		if(curNode.leftChild != null)
			l = curNode.leftChild.height;
		if(curNode.rightChild != null)
			r =	curNode.rightChild.height;
		curNode.height = (l > r ? l : r) +1;
		//check balanced or not
		int balanced = isBalanced(curNode);
		
		//left left case
		if(balanced > 1 && key < curNode.leftChild.key){
			//rotate right
			System.out.println("Right rotate node :"+curNode);
			return rotateRight(curNode);
		}
		//right right case
		 if(balanced < -1 && key > curNode.rightChild.key){
			 System.out.println("Left rotate node :"+curNode);
			 return rotateLeft(curNode);
			//rotate left
		}
		 //left right case
		 if(balanced >1 && key > curNode.leftChild.key){
			//right left rotation
			 System.out.println("Left Right rotation :"+curNode);
			 curNode.leftChild= rotateLeft(curNode.leftChild);
			 return rotateRight(curNode);
			 
		}
		 //right left case
		if(balanced < -1 && key < curNode.rightChild.key){
			//left right rotation
			curNode.rightChild = rotateRight(curNode.rightChild);
			return rotateLeft(curNode);
		}
		return curNode;
	}
	public Node rotateLeft(Node curNode){
		Node fp = curNode.rightChild;
		Node temp = fp.leftChild;
		
		//do the swapping
		fp.leftChild = curNode;
		curNode.rightChild = temp;
		
		
		//update the height from the children
		int l=0,r=0;
		if(curNode.leftChild != null)
			l = curNode.leftChild.height;
		if(curNode.rightChild != null)
			r =curNode.rightChild.height;
		curNode.height = (l>r ? l:r)+1;
		
		l=0;r=0;
		if(fp.leftChild != null)
			l = fp.leftChild.height;
		if(fp.rightChild != null)
			r =fp.rightChild.height;
		fp.height = (l>r ? l:r)+1;
		
		return fp;
	}
	public Node rotateRight(Node curNode){
		Node fp = curNode.leftChild;
		Node temp = fp.rightChild;
		
		//do the swapping
		fp.rightChild = curNode;
		curNode.leftChild = temp;
		
		
		//update the height from the children
		int l=0,r=0;
		if(curNode.leftChild != null)
			l = curNode.leftChild.height;
		if(curNode.rightChild != null)
			r =curNode.rightChild.height;
		curNode.height = (l>r ? l:r)+1;
		
		l=0;r=0;
		if(fp.leftChild != null)
			l = fp.leftChild.height;
		if(fp.rightChild != null)
			r =fp.rightChild.height;
		fp.height = (l>r ? l:r)+1;
		
		return fp;
	}
	class Node{
		int height;
		Node leftChild;
		Node rightChild;
		int key;
		Node ( int key){
			this.key = key;
			this.height =1;
		}
		public String toString(){
			return (this.key+" ");
		}
	}
	public void inOrderTraversal(){
		inOrderTraversal(this.rootNode);
	}
	public void preOrderTraversal(){
		preOrderTraversal(this.rootNode);
	}
	public void inOrderTraversal(Node curNode){
		if(curNode !=null){
			inOrderTraversal(curNode.leftChild);
			System.out.print(curNode);
			inOrderTraversal(curNode.rightChild);
		}
	}
	public void preOrderTraversal(Node curNode){
		if(curNode != null){
			System.out.print(curNode);
			preOrderTraversal(curNode.leftChild);
			preOrderTraversal(curNode.rightChild);
		}
	}
	
	
	public static void main(String [] args){
		MyAvlTree avlTree = new MyAvlTree();
		avlTree.insertNode(10);
		avlTree.insertNode(20);
		avlTree.insertNode(30);
		avlTree.insertNode(40);
		avlTree.insertNode(50);
		avlTree.insertNode(25);
		
		avlTree.inOrderTraversal();
		System.out.println();
		avlTree.preOrderTraversal();
		System.out.println();
		//avlTree.insertNode(key);
	
	}
	
	
}
