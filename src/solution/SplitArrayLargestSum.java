package solution;

/* Split Array Largest Sum - Hard */
public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int m) {
        long maxNum = 0, sum = 0;
        for(int num: nums) {
        	sum += num;
        	maxNum = Math.max(maxNum, num);
        }
        
        long l = maxNum, r = sum;
        while(l < r) {
        	long mid = l + (r - l) / 2;
        	if (validCut(nums, m, mid))
        		r = mid;
        	else
        		l = mid + 1;
        }
        
        return (int)l;
    }
    
    private boolean validCut(int[] nums, int m, long maxSum) {
    	int cuts = m;
    	long sum = 0;
    	for(int num: nums) {
    		sum += num;
    		if (sum > maxSum) {
    			sum = num;
    			if (--cuts == 0)
    				return false;
    		}
    	}
    	
    	return true;
    }
}
