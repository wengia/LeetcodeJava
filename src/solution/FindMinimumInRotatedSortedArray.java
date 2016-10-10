package solution;

public class FindMinimumInRotatedSortedArray {
	public int findMin(int[] nums) {
		int left = 0, right = nums.length - 1;
        while (left < right) {
        	int mid = (left + right) / 2;
        	if (nums[mid] > nums[right])
        	    left = mid + 1;
        	else
        	    right = mid;
        }
        
        return nums[left];
    }
	
	public int findMinDuplicated(int[] nums) {
		int left = 0, right = nums.length - 1;
        while (left < right) {
        	int mid = (left + right) / 2;
        	if (nums[left] < nums[right])
        		return nums[left];
        	else if (nums[mid] > nums[right])
        	    left = mid + 1;
        	else if (nums[mid] < nums[right])
        	    right = mid;
        	else
        		right--;
        }
        
        return nums[left];
    }
}
