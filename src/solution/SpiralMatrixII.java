package solution;

public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int res[][] = new int[n][n];
        
        // Start spiral matrix
		int imin = 0, imax = n-1; //row
        int jmin = 0, jmax = n-1; //col
		int count = 1;

		while(true) {
			for(int j = jmin; j <= jmax; j++)
				res[imin][j] = count++;
			if(++imin > imax) break;
			for(int i = imin; i <= imax; i++)
				res[i][jmax] = count++;
			if(jmin > --jmax) break;
			for(int j = jmax; j >= jmin; j--)
				res[imax][j] = count++;
			if(imin >-- imax) break;
			for(int i = imax; i >= imin; i--)
				res[i][jmin] = count++;
			if(++jmin > jmax) break;
		}
        
        return res;
    }
}
