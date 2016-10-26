package solution;

public class NumberofIslands {
	public int numIslands(char[][] grid) {
        if(grid.length == 0 || grid[0].length == 0)
        	return 0;
        
        int res = 0;
        int m = grid.length, n = grid[0].length;
        boolean visited[][] = new boolean[m][n];
        
        for(int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if(visited[i][j]) continue;
        		if(grid[i][j] != '0') {
        			res++;
        			markVisited(grid, visited, i, j);
        		}
        		visited[i][j] = true;
        	}
        }
        
        return res;
    }
	
	private void markVisited(final char[][] grid, boolean[][] visited, int posi, int posj) {
		int m = grid.length, n = grid[0].length;
		if (posi < 0 || posi >= m ||
			posj < 0 || posj >= n ||
			visited[posi][posj]) return;
		visited[posi][posj] = true;
		if(grid[posi][posj] == '0') return;
		
		markVisited(grid, visited, posi + 1, posj);
		markVisited(grid, visited, posi - 1, posj);
		markVisited(grid, visited, posi, posj + 1);
		markVisited(grid, visited, posi, posj - 1);
	}
}
