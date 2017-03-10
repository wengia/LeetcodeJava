package solution;

/* Partition Equal Subset Sum - Medium */
public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
    	if (nums.length == 0) return true;
    	if (nums.length == 1) return false;
    	int sum = 0;
    	for(int num: nums)
    		sum += num;
    	
    	// Odd sum could not split to two partitions
    	if ((sum & 1) == 1) return false;
    	
    	// Solve 0/1 knapsack problem
    	int half = sum / 2;
    	boolean[] dp = new boolean[half + 1];
    	dp[0] = true;
    	for(int num: nums) {
    		for(int i = half; i > 0 && i >= num; i--) {
    			dp[i] = dp[i] || dp[i - num];
    		}
    	}
    	
        return dp[half];
    }
}
