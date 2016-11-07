package solution;

public class Trie {
	private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
    	if (word == null || word.isEmpty()) return;
    	TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
        	char ch = word.charAt(i);
        	if (!cur.children.containsKey(ch)) {
        		cur.children.put(ch, new TrieNode());
        	}
        	
        	cur = cur.children.get(ch);
        }
        cur.isEnd = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
    	TrieNode current = searchEnd(word);
    	return (current == null) ? false : current.isEnd;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
    	TrieNode current = searchEnd(prefix);
    	return (current != null);
    }
    
    private TrieNode searchEnd(String word) {
    	if (word == null || word.isEmpty()) return null;
    	TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
        	char ch = word.charAt(i);
        	if (!cur.children.containsKey(ch)) {
        		return null;
        	}
        	
        	cur = cur.children.get(ch);
        }
        return cur;
    }
}
