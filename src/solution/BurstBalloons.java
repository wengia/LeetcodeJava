package solution;

/* Burst Balloons - Hard */
public class BurstBalloons {
    public int maxCoins(int[] nums) {
    	if (nums == null || nums.length == 0) return 0;
    	int numlen = nums.length;
    	int dp[][] = new int[numlen][numlen];
        
    	for(int length = 1; length <= numlen; length++) {
    		for(int start = 0; start <= numlen - length; start++) {
    			int end = start + length - 1;
    			for(int idx = start; idx <= end; idx++) {
    				int coins = nums[idx] * getValue(nums, start - 1) * getValue(nums, end + 1);
    				coins += (start == idx) ? 0 : dp[start][idx - 1];
    				coins += (end == idx) ? 0 : dp[idx + 1][end];
    				dp[start][end] = Math.max(dp[start][end], coins);
    			}
    		}
    	}
    	
        return dp[0][numlen - 1];
    }
    
    private int getValue(final int[] nums, int pos) {
    	if (pos < 0 || pos >= nums.length) return 1;
    	return nums[pos];
    }
}
