package solution;

/* Range Sum Query - Immutable - Easy */
public class RangeSumQueryImmutable {
	private int[] dp;

    //public NumArray(int[] nums) {
    public RangeSumQueryImmutable(int[] nums) {
    	int n = nums.length;
    	dp = new int[n];
    	for(int i = 0; i < n; i++) {
    		dp[i] = (i == 0) ? nums[i] : dp[i - 1] + nums[i];
    	}
    }
    
    public int sumRange(int i, int j) {
    	if (i == 0) return dp[j];
    	return dp[j] - dp[i - 1];
    }
}
