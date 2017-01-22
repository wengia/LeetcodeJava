package solution;

import java.util.Collections;
import java.util.PriorityQueue;

/* Find Median from Data Stream - Hard */
public class FindMedianfromDataStream {
	private PriorityQueue<Integer> lowers = new PriorityQueue<>(Collections.reverseOrder());
	private PriorityQueue<Integer> highers = new PriorityQueue<>();

    /** initialize your data structure here. */
//    public MedianFinder() {
//    }
	public FindMedianfromDataStream() {
	}
    
	// O(logN)
    public void addNum(int num) {
    	if (lowers.isEmpty() || num < lowers.peek())
    		lowers.add(num);
    	else
    		highers.add(num);
    	
    	if (highers.size() > lowers.size())
    		lowers.add(highers.poll());
    	else if (lowers.size() - 1 > highers.size())
    		highers.add(lowers.poll());
    }
    
    public double findMedian() {
        if (highers.size() < lowers.size())
        	return lowers.peek();
        else
        	return (highers.peek() + lowers.peek()) / 2.0;
    }
}
