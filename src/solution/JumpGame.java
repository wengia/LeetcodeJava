package solution;

public class JumpGame {
	public boolean canJump(int[] nums) {
		if (nums.length <= 1) return true;
		int latestIdx = nums[0];
		
		for (int i = 1; i < nums.length; i++) {
			if (latestIdx < i) 
				return false;
			
			int cur = i + nums[i];
			if (cur > latestIdx)
				latestIdx = cur;
		}
		
        return latestIdx >= nums.length - 1;
    }
}
