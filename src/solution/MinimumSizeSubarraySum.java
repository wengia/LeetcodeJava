package solution;

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) return 0;
        int res = Integer.MAX_VALUE;
        int start = 0, end = 0, sum = 0;
        
        for (; end < nums.length; end++) {
        	sum += nums[end];
        	
        	while (sum - nums[start] >= s && start < end) {
        		sum = sum - nums[start++];
        	}
        	
        	if (sum >= s)
        	    res = Math.min(res, end - start + 1);
        }
        
        return (res == Integer.MAX_VALUE) ? 0 : res;
    }
}
