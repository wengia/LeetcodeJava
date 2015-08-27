package solution;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;
		if (nums.length == 1) return nums[0];
		int res = nums[0];
		int maxPositive = 1;
		int maxNegative = 1;
		
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				maxPositive = 1;
				maxNegative = 1;
				res = Math.max(res, 0);
				continue;
			}
			else if (nums[i] > 0) {
				maxPositive *= nums[i];
				maxNegative *= nums[i];
			}
			else if (maxNegative < 0) {
				int positive = maxPositive;
				maxPositive = maxNegative * nums[i];
				maxNegative = nums[i] * positive;
			}
			else {
				maxPositive  = 1;
				maxNegative *= nums[i];
				continue;
			}

        	res = Math.max(res, maxPositive);
        }
		
		
		return res;
    }
}
