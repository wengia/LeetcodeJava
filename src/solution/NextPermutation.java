package solution;

import java.util.Arrays;

// 
public class NextPermutation {

	public void nextPermutation(int[] nums) {
        int n = nums.length;
        boolean descending = true;
        
        for (int i = n - 2; i >= 0; i--) {
        	// Find the first number violating descending order
        	if (nums[i] >= nums[i + 1]) continue;
        	
        	// Find the last number bigger than the violating one
        	int idxOfLastBigger = n - 1;
        	while (nums[idxOfLastBigger] <= nums[i]) idxOfLastBigger--;
        	
        	// Swap the two
        	swap(nums, i, idxOfLastBigger);
        	
        	// Ascending the following
        	int low = i + 1, high = n - 1;
        	while (low < high) swap(nums, low++, high--);
        	
        	descending = false;
    		break;
        }
        
        if (descending) {
        	Arrays.sort(nums);
        }
    }
	
	private void swap(int nums[], int idx1, int idx2) {
		int tmp = nums[idx1];
		nums[idx1] = nums[idx2];
		nums[idx2] = tmp;
	}
}
