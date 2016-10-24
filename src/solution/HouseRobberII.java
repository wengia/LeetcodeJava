package solution;

public class HouseRobberII {
	// Arrange in a circle
	public int rob(int[] nums) {
		if (nums.length == 0) return 0;
		if (nums.length == 1) return nums[0];
		if (nums.length == 2) return Math.max(nums[0], nums[1]);
		int current, previous; // Include first no last
		int curLast, prevLast; // Include last no first
		
		previous = nums[0];
		current = Math.max(nums[0], nums[1]);
		
		prevLast = nums[1];
		curLast = Math.max(nums[1], nums[2]);
		for (int i = 2; i < nums.length - 1; i++) {
			int amount = nums[i] + previous;
			previous = current;
			current = Math.max(amount, current);
			
			int amountLast = nums[i + 1] + prevLast;
			prevLast = curLast;
			curLast = Math.max(amountLast, curLast);
		}
		
		return Math.max(current, curLast);
    }
}
