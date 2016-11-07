package solution;

public class WordSearch {
	public boolean exist(char[][] board, String word) {
		if (board.length == 0 || board[0].length == 0 || word == null || word.isEmpty())
			return false;
		int m = board.length, n = board[0].length;
		boolean visited[][] = new boolean[m][n];
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (exist(board, word, 0, i, j, visited)) {
					return true;
				}
			}
		}
		
        return false;
    }
	
	private boolean exist(final char[][] board, String word, int wpos, 
			int posi, int posj, boolean visited[][]) {
		if (wpos >= word.length()) return true;
		int m = board.length, n = board[0].length;
		char ch = word.charAt(wpos);
		if (posi < 0 || posi >= m || posj < 0 || posj >= n || 
				visited[posi][posj] || board[posi][posj] != ch)
			return false;
		
		visited[posi][posj] = true;
		boolean res = exist(board, word, wpos + 1, posi - 1, posj, visited) ||
					  exist(board, word, wpos + 1, posi + 1, posj, visited) ||
					  exist(board, word, wpos + 1, posi, posj - 1, visited) ||
					  exist(board, word, wpos + 1, posi, posj + 1, visited);
		visited[posi][posj] = false;
		
		return res;
	}
}
