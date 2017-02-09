package solution;

/* Longest Increasing Path in a Matrix - Hard */
public class LongestIncreasingPathinaMatrix {
	// DFS, Time O(m * n), Space O(m * n)
    public int longestIncreasingPath(int[][] matrix) {
    	if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] larger = new int[m][n];
        int res = 0;
        
        for(int i = 0; i < m; i++) {
        	for(int j = 0; j < n; j++) {
        		int current = longestIncreasingPath(matrix, larger, i, j, Integer.MAX_VALUE);
        		res = Math.max(current, res);
        	}
        }
        
        return res;
    }
    
    public int longestIncreasingPath(int[][] matrix, int[][] larger, int row, int col, int pre) {
    	int m = matrix.length, n = matrix[0].length;
    	if (row < 0 || row >= m || col < 0 || col >= n || matrix[row][col] >= pre) return 0;
    	if (larger[row][col] != 0) return larger[row][col];
    	
    	int left = longestIncreasingPath(matrix, larger, row - 1, col, matrix[row][col]);
    	int right = longestIncreasingPath(matrix, larger, row + 1, col, matrix[row][col]);
    	int up = longestIncreasingPath(matrix, larger, row, col - 1, matrix[row][col]);
    	int down = longestIncreasingPath(matrix, larger, row, col + 1, matrix[row][col]);
    	
    	larger[row][col] = Math.max(0, Math.max(up, Math.max(down, Math.max(left, right))));
    	larger[row][col]++; // Add self
    	
    	return larger[row][col];
    }
}
