package solution;

/* Game of Life - Medium */
public class GameofLife {
	// state 2 - to die
	// state -1 - coming to live
    public void gameOfLife(int[][] board) {
        if (board.length == 0 || board[0].length == 0) return;
        int m = board.length, n = board[0].length;
        for(int i = 0; i < m; i++) {
        	for(int j = 0; j < n; j++) {
        		int liveCount = livingNeighbors(board, i, j);
        		if (board[i][j] == 1 && (liveCount < 2 || liveCount > 3))
        			board[i][j] = 2;
        		if (board[i][j] == 0 && liveCount == 3)
        			board[i][j] = -1;
        	}
        }
        
        // Update board
        for(int i = 0; i < m; i++) {
        	for(int j = 0; j < n; j++) {
        		if (board[i][j] == 2)
        			board[i][j] = 0;
        		else if (board[i][j] == -1)
        			board[i][j] = 1;
        	}
        }
    }
    
    private int livingNeighbors(final int[][] board, int row, int col) {
    	int count = 0;
    	int m = board.length, n = board[0].length;
    	for(int i = (row > 0) ? row - 1: 0; i < m && i <= row + 1; i++)
    		for(int j = (col > 0) ? col - 1: 0; j < n && j <= col + 1; j++)
    			if ((i != row || j != col) && board[i][j] > 0)
    				count++;
    	
    	return count;
    }
    
    // Infinite
    public void gameOfLifeInfinite(int[][] board) {
        if (board.length == 0 || board[0].length == 0) return;
        int m = board.length, n = board[0].length;
        for(int i = 0; i < m; i++) {
        	for(int j = 0; j < n; j++) {
        		// Count for neighbors
        		int liveCount = 0;
        		for(int row = Math.max(i - 1, 0); row <= Math.min(i + 1, m - 1); row++)
        			for(int col = Math.max(j - 1, 0); col <= Math.min(j + 1, n - 1); col++)
        				liveCount += (board[row][col] & 1);
        		
        		/* For living item
        		 * liveCount = 3 or 4 - live
        		 * 
        		 * For dead item
        		 * liveCount = 3 - live
        		 * */
        		if (liveCount == 3 || liveCount - board[i][j] == 3)
        			board[i][j] |= 2;
        	}
        }
        
        // Update board
        for(int i = 0; i < m; i++) {
        	for(int j = 0; j < n; j++) {
        		board[i][j] >>= 1;
        	}
        }
    }
}
