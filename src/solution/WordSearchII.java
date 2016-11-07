package solution;

import java.util.*;

public class WordSearchII {
	private TrieNode root = new TrieNode();
	private Set<String> res = new HashSet<>();
	
	public List<String> findWords(char[][] board, String[] words) {
        if (board.length == 0 || board[0].length == 0 || words == null || words.length == 0)
			return new LinkedList<String>();
        
		int m = board.length, n = board[0].length;
		boolean visited[][] = new boolean[m][n];
		
		// Construct trie for words
		for (String word: words) {
			insertWordToTrie(word);
		}
		
		// Search by Trie
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				exist(board, root, 0, i, j, visited);
				if (res.size() == words.length)
					return new LinkedList<String>(res);
			}
		}
		
        return new LinkedList<String>(res);
    }
	
	private void exist(final char[][] board, TrieNode current, int wpos, 
			int posi, int posj, boolean visited[][]) {
		if (current == null) return;
		if (current.isEnd) res.add(current.word);
		int m = board.length, n = board[0].length;
		if (posi < 0 || posi >= m || posj < 0 || posj >= n || 
				visited[posi][posj] || !current.children.containsKey(board[posi][posj]))
			return;
		
		char ch = board[posi][posj];
		visited[posi][posj] = true;
		exist(board, current.children.get(ch), wpos + 1, posi - 1, posj, visited);
		exist(board, current.children.get(ch), wpos + 1, posi + 1, posj, visited);
		exist(board, current.children.get(ch), wpos + 1, posi, posj - 1, visited);
		exist(board, current.children.get(ch), wpos + 1, posi, posj + 1, visited);
		visited[posi][posj] = false;
    }
	
	private void insertWordToTrie(String word) {
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
        cur.word = word;
	}
}
