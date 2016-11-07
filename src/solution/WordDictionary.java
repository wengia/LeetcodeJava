package solution;

public class WordDictionary {
	private TrieNode root = new TrieNode();
	
	// Adds a word into the data structure.
    public void addWord(String word) {
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

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
    	return searchEnd(word, 0, root);
    }
    
    private boolean searchEnd(String word, int pos, TrieNode cur) {
    	if (pos >= word.length() || cur == null) return false;
    	
    	char ch = word.charAt(pos);
    	if (ch == '.') {
    		for (TrieNode child: cur.children.values()) {
    			if (pos == word.length() - 1 && child.isEnd)
    				return true;
    			
    			if (searchEnd(word, pos + 1, child))
    				return true;
    		}
    	} else if (!cur.children.containsKey(ch))
    		return false;
    	else if (pos == word.length() - 1) {
    		return cur.children.get(ch).isEnd;
    	}
    	
    	return searchEnd(word, pos + 1, cur.children.get(ch));
    }
}
