package solution;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        
        if (nums.length == 0 || target < nums[0]) 
        	return 0;
        else if (target > nums[right]) 
        	return nums.length;
        
        while (left < right) {
        	int mid = (left + right) / 2;
        	
        	if (nums[mid] == target)
        		return mid;
        	else if (nums[mid]  < target)
        		left++;
        	else
        		right--;
        }
        
        return left;
    }
}
