package solution;

public class SearchA2DMatrixII {
	// O(m + n)
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix.length == 0 || matrix[0].length == 0)
			return false;
		int m = matrix.length, n = matrix[0].length;
		int row = 0, col = n - 1;
		while(row < m && col >= 0) {
			if (matrix[row][col] == target)
				return true;
			else if (matrix[row][col] < target)
				row++;
			else
				col--;
		}
		
        return false;
    }
}
