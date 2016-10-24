package solution;

public class HouseRobber {
	// Arrange in a list
	public int rob(int[] nums) {
		if (nums.length == 0) return 0;
		if (nums.length == 1) return nums[0];
		int current, previous;
		
		previous = nums[0];
		current = Math.max(nums[0], nums[1]);
		for (int i = 2; i < nums.length; i++) {
			int amount = nums[i] + previous;
			previous = current;
			current = Math.max(amount, current);
		}
		
		return current;
    }
	
	public int robForUnderstand(int[] nums) {
		if (nums.length == 0) return 0;
		if (nums.length == 1) return nums[0];
		int maxAmount[] = new int[nums.length];
		
		maxAmount[0] = nums[0];
		maxAmount[1] = Math.max(nums[0], nums[1]);
		for (int i = 2; i < nums.length; i++) {
			int amount = nums[i] + maxAmount[i - 2];
			maxAmount[i] = Math.max(amount, maxAmount[i - 1]);
		}
		
		return maxAmount[nums.length - 1];
    }
}
