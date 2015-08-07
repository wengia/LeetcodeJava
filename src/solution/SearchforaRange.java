package solution;

public class SearchforaRange {
	public int[] searchRange(int[] nums, int target) {
        int res[] = new int[]{-1, -1};
        if (nums.length == 0) return res;
        
        int left = 0, right = nums.length - 1;
        
        while (left <= right) {
        	int mid = (left + right) / 2;
        	if (nums[mid] < target)
        		left = mid + 1;
        	else if (nums[mid] > target)
        		right = mid - 1;
        	else {
        		left = findLeft(left, mid, nums, target);
        		right = findRight(right, mid, nums, target);
        		res[0] = left;
        		res[1] = right;
        		break;
        	}
        	
        }
        
        return res;
    }
	
	private int findLeft(int left, int end, int nums[], final int target) {
		while (left < end) {
			int mid = (left + end) / 2;
			if (nums[mid] < target)
				left = (left == mid) ? left + 1 : mid;
			else
				end = mid;
		}
		
		return left;
	}
	
	private int findRight(int right, int start, int nums[], final int target) {
		while (start < right) {
			int mid = (start + right) / 2;
			if (nums[mid] > target)
				right = mid;
			else if (nums[right] == target)
				return right;
			else if (start == mid)
				right = mid;
			else
				start = mid;
		}
		
		return right;
	}
	
	public int[] searchRange2(int[] nums, int target) {
		int[] res = {-1, -1};
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] < target)
                start = mid + 1;
            else
                end = mid;
        }
        int low;
        if (nums[start] != target)
            return res;
        else
            low = start;
        
        end = nums.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] < target + 1)
                start = mid + 1;
            else
                end = mid;
        }
        int high = nums[start] == target ? start : start - 1;
        res[0] = low;
        res[1] = high;
        
        return res;
	}
}
