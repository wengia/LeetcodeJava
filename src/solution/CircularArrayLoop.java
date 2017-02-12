package solution;

/* Circular Array Loop - Medium */
// The question has issue. Really cannot understand what should be the pass case
public class CircularArrayLoop {
	/* tricky points! the question asks for loop which
	 * 1. Loop include MORE THAN 1 item
	 * [-2, 1, -1, -2, -2] where loop in 1 -> 2 -> 1 false
	 * [3,1,2] where loop in 0 -> 0  return true???!!!
	 * [2, -1, 1, 2, 2] where loop in 0 -> 2 -> 3 -> 0 true
	 * 
	 * 2. Loop in ONE DIRECTION, all forward or backward
	 * [2, -1, 1, -2, -2] where loop in 0 -> 2 -> 3 -> 1 -> 0
	 * false because nums[3] = -2 going backward
	 * 
	 * */
    public boolean circularArrayLoop(int[] nums) {
    	if (nums == null || nums.length < 2) return false;
        int fast = 0, slow = 0, n = nums.length;
        do {
        	slow = nextStep(slow, nums[slow], n);
        	fast = nextStep(fast, nums[fast], n);
        	fast = nextStep(fast, nums[fast], n);
        } while(fast != slow);
        
        int loopLen = 0;
        boolean trend = nums[fast] > 0;
        do {
        	fast = nextStep(fast, nums[fast], n);
        	
        	// Add loopLen
        	loopLen++;
        	
        	// check forward or backward
        	boolean curTrend = nums[fast] > 0;
        	if (curTrend != trend)
        		return false;
        } while(slow != fast);

        return loopLen > 2;
    }
    
    private int nextStep(int idx, int num, int n) {
    	int next = idx + num;
    	if (next < 0) next += n;
    	if (next >= n) next -= n;
    	return next;
    }
}
