package solution;

import java.util.*;

public class TrieNode {
	protected Map<Character, TrieNode> children;
	protected boolean isEnd = false;
	
    // Initialize your data structure here.
    public TrieNode() {
        children = new HashMap<>();
    }
}
