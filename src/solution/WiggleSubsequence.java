package solution;

/* Wiggle Subsequence - Medium */
public class WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 0) return 0;
        int count = 2, pos = 1;
        while(pos < nums.length && nums[pos] == nums[0]) pos++;
        if (pos == nums.length) return 1;
        
        boolean up = nums[pos++] > nums[0];
        for(;pos < nums.length; pos++) {
        	if (nums[pos] == nums[pos - 1] ||
        			(nums[pos] > nums[pos - 1]) == up) continue;
        	count++;
        	up = !up;
        }
        
        return count;
    }
}
