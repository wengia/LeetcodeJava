package solution;

import java.util.PriorityQueue;

/* Trapping Rain Water II - Hard */
public class TrappingRainWaterII {
    public int trapRainWater(int[][] heightMap) {
    	if (heightMap.length < 3 || heightMap[0].length < 3) return 0;
    	int m = heightMap.length, n = heightMap[0].length;
    	PriorityQueue<Cell> cells = new PriorityQueue<>((a, b) -> (a.height - b.height));
    	boolean[][] visited = new boolean[m][n];
        int sum = 0;
        
        // Add Border
        for(int i = 1; i < m - 1; i++) {
        	cells.add(new Cell(i, 0, heightMap[i][0]));
        	cells.add(new Cell(i, n - 1, heightMap[i][n - 1]));
        }
        
        for(int j = 1; j < n - 1; j++) {
        	cells.add(new Cell(0, j, heightMap[0][j]));
        	cells.add(new Cell(m - 1, j, heightMap[m - 1][j]));
        }
        
        // Traverse inside
        int[][] neighbor = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        while(!cells.isEmpty()) {
        	Cell cell = cells.poll();
        	for(int i = 0; i < 4; i++) {
        		int row = cell.row + neighbor[i][0];
        		int col = cell.col + neighbor[i][1];
        		if (row > 0 && row < m - 1 && col > 0 && col < n - 1 && !visited[row][col]) {
        			visited[row][col] = true;
        			sum += Math.max(0, cell.height - heightMap[row][col]);
        			cells.add(new Cell(row, col, Math.max(cell.height, heightMap[row][col])));
        		}
        	}
        }
        
        return sum;
    }
	
	private class Cell {
		int row, col;
		int height;
		private Cell(int row, int col, int height) {
			this.row = row;
			this.col = col;
			this.height = height;
		}
	}
	
	
	/************ Try Trap Rain Water I Failed ***************/
    public int trapRainWaterNotWork(int[][] heightMap) {
    	if (heightMap.length == 0 || heightMap[0].length == 0) return 0;
    	int m = heightMap.length, n = heightMap[0].length;
        int sum = 0;
        int[][] maxHeight = new int[m][n];
        
        // Update Up <-> Down
        for(int j = 1; j < n - 1; j++) {
        	int[] up = new int[m];
        	int[] down = new int[m];
        	up[m - 1] = heightMap[m - 1][j];
        	down[0] = heightMap[0][j];
        	for(int i = 1; i < m - 1; i++) {
        		down[i] = Math.max(down[i - 1], heightMap[i][j]);
        		up[m - 1 - i] = Math.max(up[m - i], heightMap[m - 1 - i][j]);
        		
        		if (i >= m / 2) {
        			maxHeight[i][j] = Math.min(up[i], down[i]);
        			maxHeight[m - 1 - i][j] = Math.min(up[m - 1 - i], down[m - 1 - i]);
        		}
        	}
        }
        
        // Update Left <-> Right
        for(int i = 1; i < m - 1; i++) {
        	int[] left = new int[n];
        	int[] right = new int[n];
        	left[0] = heightMap[i][0];
        	right[n - 1] = heightMap[i][n - 1];
        	for(int j = 1; j < n - 1; j++) {
        		left[j] = Math.min(maxHeight[i][j], Math.max(left[j - 1], heightMap[i][j]));
        		right[n - 1 - j] = Math.min(maxHeight[i][n - 1 - j], 
        				Math.max(right[n - j], heightMap[i][n - 1 - j]));
        		
        		if (j >= n / 2) {
        			maxHeight[i][j] = Math.min(left[j], right[j]);
        			maxHeight[i][n - 1 - j] = Math.min(left[n - 1 - j], right[n - 1 - j]);
        		}
        	}
        }
        
        for(int i = 1; i < m - 1; i++) {
        	for(int j = 1; j < n - 1; j++) {
        		sum += Math.max(0, maxHeight[i][j] - heightMap[i][j]);
        	}
        }
        
        return sum;
    }
}
