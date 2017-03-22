package solution;

import java.util.Stack;

/* 132 Pattern - Medium */
public class The132Pattern {
    public boolean find132pattern(int[] nums) {
    	if (nums.length < 3) return false;
    	
    	Stack<Pair> minmaxSt = new Stack<>();
    	for(int i = 0; i < nums.length; i++) {
    		if (minmaxSt.isEmpty() || nums[i] < minmaxSt.peek().minNum)
    			minmaxSt.push(new Pair(nums[i], nums[i]));
    		else if (nums[i] > minmaxSt.peek().minNum) {
    			Pair last = minmaxSt.pop();
    			if (nums[i] < last.maxNum) return true;
    			
    			// nums[i] >= last.maxNum
    			while(!minmaxSt.isEmpty() && nums[i] >= minmaxSt.peek().maxNum) {
    				last.minNum = Math.min(last.minNum, minmaxSt.peek().minNum);
    				minmaxSt.pop();
    			}
    			
    			// EITHER minmaxSt.isEmpty OR nums[i] < minmaxSt.peek().maxNum
    			if (!minmaxSt.isEmpty() && nums[i] > minmaxSt.peek().minNum)
    				return true;
    			
    			last.maxNum = nums[i];
    			minmaxSt.push(last);
    		}
    	}
    	
        return false;
    }
    
    private class Pair {
    	int minNum, maxNum;
    	private Pair(int min, int max) {
    		this.minNum = min;
    		this.maxNum = max;
    	}
    }
    
    public boolean find132patternSmart(int[] nums) {
    	if (nums.length < 3) return false;
    	Stack<Integer> maxFromRight = new Stack<>();
    	int s3 = Integer.MIN_VALUE;
    	
    	for(int i = nums.length - 1; i >= 0; i--) {
    		if (nums[i] < s3) return true;
    		
    		while(!maxFromRight.isEmpty() && nums[i] > maxFromRight.peek()) {
    			s3 = maxFromRight.peek();
    			maxFromRight.pop();
    		}
    		maxFromRight.push(nums[i]);
    	}
    	
    	return false;
    }
}
