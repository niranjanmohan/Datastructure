package tree;


public class SimpleTrie {
	TrieNode trieNode;

	public SimpleTrie(){
		trieNode = new TrieNode();
	}
	public void insert(String word){
		trieNode.insertWord(word);
	}
	public boolean  hasWord(String word){
		return trieNode.hasWord(word);
	}
	public static void main(String [] args){
		SimpleTrie trie = new SimpleTrie();
		trie.insert("HELLO");
		System.out.println(trie.hasWord("HELLO"));
	}
}