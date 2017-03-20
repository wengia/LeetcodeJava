package solution;

import java.util.Random;

/* Minimum Moves to Equal Array Elements II - Medium */
public class MinimumMovestoEqualArrayElementsII {
	// Find median of the array -> Find kth smallest element in array
	public int minMoves2(int[] nums) {
		if (nums.length == 0) return 0;
        int res = 0;
        int median = findMedian(nums);
        for(int num: nums) {
        	res += Math.abs(median - num);
        }
        return res;
    }
	
	private int findMedian(int[] nums) {
		return findKth(nums.length / 2, nums, 0, nums.length - 1);
	}
	
	private int findKth(int k, int[] nums, int start, int end) {
		if (start == end) return nums[start];
		Random rand = new Random();
		int pivotIdx = start + rand.nextInt(end - start);
		int pivotNum = nums[pivotIdx];
		int l = start, r = end;
		
		swap(nums, pivotIdx, r);
		for(int i = l; i < r; i++) {
			if (nums[i] < pivotNum)
				swap(nums, l++, i);
		}
		swap(nums, l, r);
		
		if (l == k) return nums[l];
		else if (l < k) return findKth(k, nums, l + 1, end);
		else return findKth(k, nums, start, l - 1);
	}
	
	private void swap(int[] nums, int i, int j) {
		if (i == j) return;
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}
