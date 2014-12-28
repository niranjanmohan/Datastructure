//package tree;
//
//
//class AvlTree{
//	public static void main(String []args){
//
//	}
//
//	public Node addNode(Node node,int data){
//		if(node == null){
//			node = new Node(data);
//			return node;
//		}
//		else if(node.data < data){
//			node.left = addNode(node.left,data);
//		}
//		else{
//			node.right = addNode(node.right,data);
//		}
//		//update heights
//		int l=0,r=0;
//		if(node.left != null){
//			l = node.left.height;
//		}
//		if(node.right != null){
//			r =node.right.height;
//		}
//		node.height = l >r ? l:r;
//		int balance = isBalanced(node);
//		
//		//left left case
//		if(balance < -1 && data > node.right.data){
//			 return rotateLeft(node);
//		}
//		
//		
//		
//
//	}
//	
////	public Node rotateLeft(Node node){
////		Node rp = node.right;
////		Node temp = rp.left;
////		rp.left = node;
////		node.right = temp;
////		//update height;
////		
////		int l,r=0;
////		if(node.)
////		
////		return rp;
////	}
////	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	public int isBalanced(Node node){
//		int l=0,r=0;
//		if(node.left != null){
//			l = node.left.height;
//		}
//		if(node.right != null ){
//			r =node.right.height;
//		}
//		return (l-r);
//	}
//
//
//	class Node{
//		public Node(int data) {
//			this.data = data;
//		}
//		int data;
//		int height;
//		Node left;
//		Node right;
//	}
//
//}