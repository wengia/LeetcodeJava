package solution;

import java.util.Arrays;
import java.util.TreeSet;

/* Max Sum of Rectangle No Larger Than K - Hard */
public class MaxSumofRectangleNoLargerThanK {
    public int maxSumSubmatrix(int[][] matrix, int k) {
    	if (matrix.length == 0 || matrix[0].length == 0) return 0;
    	int maxSum = Integer.MIN_VALUE;
    	int m = matrix.length, n = matrix[0].length;
    	int smallEdge = Math.min(m, n);
    	int largeEdge = Math.max(m, n);
    	int dp[] = new int[largeEdge];
    	
    	for(int left = 0; left < smallEdge; left++) {
    		Arrays.fill(dp, 0);
    		for(int right = left; right < smallEdge; right++) {
    			// Count current array
    			for(int i = 0; i < largeEdge; i++)
    				dp[i] += (m < n) ? matrix[right][i]: matrix[i][right];
    			
    			int localMax = largestSumContiniousArrayLessThanK(dp, k);
    			maxSum = Math.max(maxSum, localMax);
    		}
    	}
    	
        return maxSum;
    }
    
    // Suppose Sum(i, j] <= k, 
    // Sum[j] - Sum[i] <= k
    // till each j, we only need to find upper bound i
    // Time O(NlogN)
    private int largestSumContiniousArrayLessThanK(int[] nums, int k) {
    	int localMax = Integer.MIN_VALUE;
    	TreeSet<Integer> prevSum = new TreeSet<>();
    	int sum = 0;
    	
    	prevSum.add(0); // if sumj <= k is the closest one
    	for(int num: nums) {
    		sum += num;
    		Integer tmp = prevSum.ceiling(sum - k);
    		int sumi = (tmp == null) ? 0: tmp;
    		if (sum - sumi <= k)
    			localMax = Math.max(localMax, sum - sumi);
    		prevSum.add(sum);
    	}
    	
    	return localMax;
    }
    
    /*---------------------- Max Sum of Rectangle ---------------------*/
    
    private int maxSumSubmatrix(int[][] matrix) {
    	if (matrix.length == 0 || matrix[0].length == 0) return 0;
    	int maxSum = Integer.MIN_VALUE;
    	int m = matrix.length, n = matrix[0].length;
    	int dp[] = new int[m];
    	
    	for(int left = 0; left < n; left++) {
    		for(int right = 0; right < n; right++) {
    			// Count current array
    			for(int row = 0; row < m; row++)
    				dp[row] += matrix[row][right];
    			
    			int localMax = largestSumContiniousArray(dp);
    			maxSum = Math.max(maxSum, localMax);
    		}
    	}
    	
        return maxSum;
    }

    // Kadane's algorithm, Time O(N)
    private int largestSumContiniousArray(int[] nums) {
    	int sum = Integer.MIN_VALUE;
    	int largest_end_here = 0;
    	
    	for(int num: nums) {
    		largest_end_here += num;
    		if (sum < largest_end_here)
    			sum = largest_end_here;
    		if (largest_end_here < 0)
    			largest_end_here = 0;
    	}
    	
    	return sum;
    }
}
