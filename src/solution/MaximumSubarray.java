package solution;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        int res = nums[0], localSum = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
        	localSum = Math.max(nums[i], nums[i] + localSum);
        	
        	res = Math.max(res, localSum);
        }
        
        return res;
    }
}
