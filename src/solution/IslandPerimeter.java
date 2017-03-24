package solution;

/* Island Perimeter - Easy */
public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
    	if (grid.length == 0 || grid[0].length == 0) return 0;
        int p = 0;
        int m = grid.length, n = grid[0].length;
        
        for(int i = 0; i < m; i++) {
        	for(int j = 0; j < n; j++) {
        		if (grid[i][j] == 0) continue;
        		
        		int up = (i == 0 || grid[i - 1][j] == 0) ? 1: 0;
        		int down = (i == m - 1 || grid[i + 1][j] == 0) ? 1: 0;
        		int left = (j == 0 || grid[i][j - 1] == 0) ? 1: 0;
        		int right = (j == n - 1 || grid[i][j + 1] == 0) ? 1: 0;
        		p += (up + down + left + right);
        	}
        }
        
        return p;
    }
}
