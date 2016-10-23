package solution;

public class RotateArray {
	public void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        if (k == 0) return;
        
        k = nums.length - k;
        
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }
	
	private void reverse(int[] nums, int start, int end) {
		if (end >= nums.length)
			end = nums.length - 1;
		
		while (start < end) {
			int tmp = nums[start];
			nums[start++] = nums[end];
			nums[end--] = tmp;
		}
	}
}
