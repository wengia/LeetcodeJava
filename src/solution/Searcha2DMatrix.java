package solution;

public class Searcha2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix.length == 0 || matrix[0].length == 0)
			return false;
		int m = matrix.length, n = matrix[0].length;
		int low = 0, high = m * n - 1;
		while(low <= high) {
			int mid = (low + high) / 2;
			if(matrix[mid / n][mid % n] == target)
				return true;
			else if (matrix[mid / n][mid % n] > target)
				high = mid - 1;
			else
				low = mid + 1;
		}
		
        return false;
    }
}
