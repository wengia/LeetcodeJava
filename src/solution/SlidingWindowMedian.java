package solution;

import java.util.Collections;
import java.util.PriorityQueue;

/* Sliding Window Median - Hard */
public class SlidingWindowMedian {
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] res = new double[nums.length - k + 1];
        PriorityQueue<Integer> lowers = new PriorityQueue<>(Collections.reverseOrder());
    	PriorityQueue<Integer> highers = new PriorityQueue<>();
        
    	for(int i = 0, j = 0; i < nums.length; i++) {
    		if (i < k - 1) {
    			updateHeap(lowers, highers, nums[i]);
    			continue;
    		}
    		
    		updateHeap(lowers, highers, nums[i]);
    		double med = findMed(lowers, highers);
            res[j++] = med;
    		
            // remove the last one
            if (!lowers.isEmpty() && nums[i - k + 1] <= lowers.peek())
            	lowers.remove(nums[i - k + 1]);
            else
            	highers.remove(nums[i - k + 1]);
    	}
        
        return res;
    }
    
    private void updateHeap(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers, int num) {
    	if (!lowers.isEmpty() && num < lowers.peek())
    		lowers.add(num);
    	else if (!highers.isEmpty() && num > highers.peek())
    		highers.add(num);
    	else
    		lowers.add(num);
    	
    	// Balance the two que
    	while(Math.abs(lowers.size() - highers.size()) > 1) {
	    	if (highers.size() > lowers.size())
	    		lowers.add(highers.poll());
	    	else
	    		highers.add(lowers.poll());
    	}
    }
    
    // Take care of out of RANGE! Like (Integer.MIN_VALUE + Integer.MIN_VALUE) / 2
    private double findMed(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
    	double res = 0;
    	if (highers.size() == lowers.size()) {
           	res = ((double)highers.peek() + (double)lowers.peek()) / 2.0;
    	} else {
    		res = (highers.size() > lowers.size()) ?
           			 highers.peek() : lowers.peek();
    	}
        return res;
    }
}
