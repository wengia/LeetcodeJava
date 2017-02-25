package solution;

/* Elimination Game - Medium */
public class EliminationGame {
	public int lastRemaining(int n) {
		int head = 1;
		int step = 1;
		int remain = n;
		boolean fromLeft = true;
		
		while(remain > 1) {
			if (fromLeft || (remain & 1) == 1) {
				head += step;
			}
			
			remain /= 2;
			step *= 2;
			fromLeft = !fromLeft;
		}
		
		return head;
    }
	
	
	/** 
	 * Below is helper method. However this will Memory Limit Exceeded
	 * 
	 * End is the length of current list
	 * 
	 * If from Left:
	 *  1 2 3 4 5 6 7 ...
	 *  x   x   x   x
	 * 
	 * If from right:
	 *    End = even (example end = 8)
	 *    1 2 3 4 5 6 7 8
	 *      x   x   x   x
	 *      
	 *    End = odd (example end = 7)
	 *    1 2 3 4 5 6 7
	 *    x   x   x   x
	 * 
	 * */
	public int lastRemainingIntuitive(int n) {
		if (n <= 1) return n;
        int[] nums = new int[n];
        for(int i = 0; i < n; i++)
        	nums[i] = i + 1;
        
        eliminating(nums, n, true);
        
        return nums[0];
    }
	
	private void eliminating(int[] nums, int end, boolean fromLeft) {
		if (end == 0) return;
		int start = (fromLeft || (end & 1) == 1) ? 1 : 0;
		int pos = 0;
		
		for(;start < end; start += 2)
			nums[pos++] = nums[start];
		
		eliminating(nums, pos, !fromLeft);
	}
}
