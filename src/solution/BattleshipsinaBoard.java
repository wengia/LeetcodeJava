package solution;

/* Battleships in a Board - Medium */
public class BattleshipsinaBoard {
    public int countBattleships(char[][] board) {
    	if (board.length == 0 || board[0].length == 0) return 0;
        int count = 0;
        int m = board.length, n = board[0].length;
        
        for(int i = 0; i < m; i++) {
        	for(int j = 0; j < n; j++) {
        		if (board[i][j] == '.') continue;
        		boolean boatFromLeft = (i > 0 && board[i - 1][j] == 'X');
        		boolean boatFromUp = (j > 0 && board[i][j - 1] == 'X');
        		if (!boatFromLeft && !boatFromUp)
        			count++;
        	}
        }
        
        return count;
    }
}
