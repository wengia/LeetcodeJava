package solution;

public class KthLargestElementinanArray {
	public int findKthLargest(int[] nums, int k) {
		int len = nums.length;
        return findKthLargest(nums, len - k, 0, len - 1);
    }
	
	private int findKthLargest(int[] nums, int k, int left, int right) {
		if(left == right) return nums[left];
		int l = left, r = right;
		int tmp = nums[l];
		
		while(l < r) {
			while(nums[r] >= tmp && l < r) r--;
			if(l != r) nums[l++] = nums[r];
			while(nums[l] < tmp && l < r) l++;
			if(l != r) nums[r--] = nums[l];
		}
		nums[l] = tmp;
		if(l == k) return nums[l];
		return (l < k) ? findKthLargest(nums, k, l + 1, right) : findKthLargest(nums, k, left, l - 1);
	}
}
