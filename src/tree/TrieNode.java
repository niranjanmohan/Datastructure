package tree;
//tree node class 

class TrieNode{
	boolean flag;
	TrieNode[] childNode;

	public TrieNode(){
		flag = false;
		childNode = new TrieNode[26];
	}

	public void insertWord(String word){
		int index = word.charAt(0)-64;
		if(childNode[index] == null){
			childNode[index] = new TrieNode();
		}
		if(word.length() >1){
			childNode[index].insertWord(word.substring(1));
		}
		else{
			flag = true;
		}
	}
	public boolean  hasWord(String word){
		//System.out.println("enter hasword");
		int index = word.charAt(0) -64;
		if(childNode[index] != null && word.length() >1){
			return childNode[index].hasWord(word.substring(1));
		}
		if(word.length() ==1 )if(  flag == true){
			//System.out.println("*******returning true*****");
			return true;
		}
		return false;
	}
}
