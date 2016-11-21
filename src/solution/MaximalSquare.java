package solution;

import java.util.*;

public class MaximalSquare {
	public int maximalSquare(char[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0)
			return 0;
        int res = 0;
        boolean last = true;
        int m = matrix.length, n = matrix[0].length;
        int level[][] = new int[2][n];
        
        for(int i = 0; i < m; i++) {
        	last = !last;
        	int prev = last ? 1 : 0;
        	int cur = last ? 0 : 1;
        	for(int j = 0; j < n; j++) {
        		int localMax = 0;
        		if (matrix[i][j] == '0') {
        			localMax = 0;
        		} else if (j > 0) {
        			localMax = Math.min(Math.min(level[prev][j - 1], level[prev][j]), level[cur][j - 1]) + 1;
        		} else
        			localMax = 1;
        		
        		level[cur][j] = localMax;
        		res = Math.max(res, localMax);
        	}
        }
        
        return res * res;
    }
}
