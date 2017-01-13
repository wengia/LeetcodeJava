package solution;

import java.util.*;

public class SlidingWindowMaximum {
	public int[] maxSlidingWindow(int[] nums, int k) {
		int[] res = new int[nums.length - k + 1];
        PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < nums.length; i++) {
        	que.add(nums[i]);
        	if (i < k - 1) {
        		continue;
        	}
        	
        	if (i >= k) {
        		que.remove(nums[i - k]);
        	}
        	res[i - k + 1] = que.peek();
        }
        
        return res;
    }
}
