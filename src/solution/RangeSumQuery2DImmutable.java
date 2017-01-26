package solution;

/* Range Sum Query 2D - Immutable - Medium */
public class RangeSumQuery2DImmutable {
	/* 0-------------------
	 * |      |       |
	 * |      |       |
	 * |------A-------D--
	 * |      |       |
	 * |      |       |
	 * |------B-------C--
	 * |      |       |
	 * 
	 * Rec[ABCD] = Rec[C] - (Rec[B] + Rec[D] - Rec[A])
	 * */
	
	private int[][] sum;

	// public NumMatrix(int[][] matrix) {
    public RangeSumQuery2DImmutable(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
        	return;
        
        int m = matrix.length, n = matrix[0].length;
        sum = new int[m][n];
        for(int i = 0; i < m; i++) {
        	sum[i][0] = (i == 0) ? matrix[0][0]: matrix[i][0] + sum[i - 1][0];
        	for(int j = 1; j < n; j++) {
        		if (i == 0)
        			sum[0][j] = sum[0][j - 1] + matrix[0][j];
        		else
        			sum[i][j] = sum[i - 1][j] + sum[i][j - 1] + matrix[i][j] - sum[i - 1][j - 1];
        	}
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int recA = (row1 == 0 || col1 == 0) ? 0 : sum[row1 - 1][col1 - 1];
        int recB = (col1 == 0) ? 0 : sum[row2][col1 - 1];
        int recD = (row1 == 0) ? 0 : sum[row1 - 1][col2];
        int recC = sum[row2][col2];
        
        return recC - (recB + recD - recA);
    }
}
