package solution;

import java.util.*;

/* Pacific Atlantic Water Flow - Medium */
public class PacificAtlanticWaterFlow {
	// 0(go A) 0(go P)
    public List<int[]> pacificAtlantic(int[][] matrix) {
    	List<int[]> res = new LinkedList<>();
        if (matrix.length == 0 || matrix[0].length == 0)
        	return res;
        
        int m = matrix.length, n = matrix[0].length;
        int flagP = 1, flagA = 1 << 1;
        int[][] marks = new int[m][n];
        
        for(int i = 0; i < m; i++) {
        	dfs(matrix, i, 0, Integer.MIN_VALUE, marks, flagP);
        	dfs(matrix, i, n - 1, Integer.MIN_VALUE, marks, flagA);
        }
        
        for(int j = 0; j < n; j++) {
        	dfs(matrix, 0, j, Integer.MIN_VALUE, marks, flagP);
        	dfs(matrix, m - 1, j, Integer.MIN_VALUE, marks, flagA);
        }
        
        for(int i = 0; i < m; i++) {
        	for(int j = 0; j < n; j++) {
        		if (marks[i][j] == (flagP | flagA))
        			res.add(new int[]{i, j});
        	}
        }
        
        return res;
    }
    
    private void dfs(int[][] matrix, int row, int col, int height, 
    		int[][] marks, final int visitFlag) {
    	int m = matrix.length, n = matrix[0].length;
    	if (row < 0 || row >= m || col < 0 || col >= n) return;
    	if ((marks[row][col] & visitFlag) != 0) return;
    	if (matrix[row][col] < height) return;

    	marks[row][col] |= visitFlag;
    	dfs(matrix, row - 1, col, matrix[row][col], marks, visitFlag);
    	dfs(matrix, row + 1, col, matrix[row][col], marks, visitFlag);
    	dfs(matrix, row, col - 1, matrix[row][col], marks, visitFlag);
    	dfs(matrix, row, col + 1, matrix[row][col], marks, visitFlag);
    }
}
