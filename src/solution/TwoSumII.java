package solution;

public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
    	int res[] = new int[2];
    	int left = 0, right = numbers.length - 1;
    	
    	while (left < right) {
    		if (numbers[left] + numbers[right] > target) {
    			right = binarySearch(numbers, left, right, target - numbers[left], true);
    		} else if (numbers[left] + numbers[right] < target) {
    			left = binarySearch(numbers, left, right, target - numbers[right], false);
    		} else
    			break;
    	}
    	
    	res[0] = left + 1;
    	res[1] = right + 1;
        return res;
    }
    
    private int binarySearch(int[] nums, int left, int right, int target, boolean findright) {
    	int mid = (left + right) / 2;
		if (findright && nums[mid] >= target || !findright && nums[mid] <= target)
			return mid;
    	
    	return findright ? right - 1 : left + 1;
    }
}
