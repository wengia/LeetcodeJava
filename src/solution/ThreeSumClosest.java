package solution;

import java.util.Arrays;

public class ThreeSumClosest {
	public int threeSumClosest(int[] nums, int target) {
		if (nums == null || nums.length < 3) return Integer.MAX_VALUE;
		int res = nums[0] + nums[1] + nums[2];
		Arrays.sort(nums);
		
		
		for (int i = 0; i < nums.length; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) continue;
			
			int left = i + 1, right = nums.length - 1;
			int twoSum = target - nums[i];
			while (left < right) {
				int localSum = nums[left] + nums[right];
				if (localSum < twoSum)
					left++;
				else if (localSum > twoSum)
					right--;
				else
					return target;
				
				int threeSum = localSum + nums[i];
				if (Math.abs(threeSum - target) < Math.abs(res - target))
					res = threeSum;
			}
		}
		
		return res;
    }

}
