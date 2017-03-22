package solution;

import java.util.Random;

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
	
	private Random rand = new Random();
	private int findKthSmallest(int[] nums, int k, int left, int right) {
		if(left == right) return nums[left];
		
		int pivotIdx = left + rand.nextInt(right - left);
		int pivotNum = nums[pivotIdx];
		int l = left, r = right;
		swap(nums, pivotIdx, r);
		
		for(int i = l; i < r; i++) {
			if (nums[i] < pivotNum)
				swap(nums, l++, i);
		}
		swap(nums, l, r);
		
		if(l == k) return nums[l];
		return (l < k) ? findKthLargest(nums, k, l + 1, right) : findKthLargest(nums, k, left, l - 1);
	}
	
	private void swap(int[] nums, int i, int j) {
		if (i == j) return;
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}
