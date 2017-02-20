package solution;

import java.util.HashSet;
import java.util.Set;

/* Combination Sum IV - Medium */
public class CombinationSumIV {
	// Leetcode solution DP, Time O(nums.length * target), Space O(1)
    public int combinationSum4(int[] nums, int target) {
    	if (nums == null || nums.length == 0) return 0;
    	int[] comb = new int[target + 1];
    	
    	comb[0] = 1;
    	for(int i = 1; i <= target; i++) {
    		for(int num: nums) {
    			if (num > i) continue;
    			comb[i] += comb[i - num];
    		}
    	}
    	
    	return comb[target];
    }
	
	// DP, Time O(target ^ 2), space O(target + nums.length)
    public int combinationSum4DP(int[] nums, int target) {
    	if (nums == null || nums.length == 0) return 0;
        Set<Integer> numTable = new HashSet<>();
        int[] dp = new int[target + 1];
        
        for(int num: nums)
        	numTable.add(num);
        
        dp[0] = 1; // To count value already in nums
        for(int i = 1; i <= target; i++) {
        	for(int j = 0; j < i; j++) {
        		if (numTable.contains(i - j))
        			dp[i] += dp[j];
        	}
        }
        
        return dp[target];
    }
}
