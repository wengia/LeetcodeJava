package solution;

import java.util.LinkedList;

/* Create Maximum Number - Hard */
public class CreateMaximumNumber {
	public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] best = new int[k];
        int len1 = nums1.length, len2 = nums2.length;
        
        for(int k1 = Math.max(k - len2, 0); k1 <= Math.min(len1, k); k1++) {
        	best = maxArray(best, mergeArray(maxNumber(nums1, k1), maxNumber(nums2, k - k1)));
        }
        
        return best;
    }
    
    // a1 & a2 should be in same length and in descending order.
    private int[] maxArray(int[] a1, int[] a2) {
    	for(int i = 0; i < a1.length; i++) {
    		if (a1[i] == a2[i]) continue;
    		return (a1[i] > a2[i]) ? a1 : a2;
    	}
    	return a1;
    }
    
    private int[] maxNumber(int[] nums, int k) {
    	int[] res = new int[k];
    	int drop = nums.length - k;
    	LinkedList<Integer> stack = new LinkedList<>();
    	
    	// Get max numbers in sequence
    	for(int num: nums) {
    		while(drop > 0 && !stack.isEmpty() && stack.peekLast() < num) {
    			stack.pollLast();
    			drop--;
    		}
    		
    		stack.add(num);
    	}
    	
    	// Resize stack to the first k numbers
    	for(int i = 0; i < k; i++) {
    		res[i] = stack.pollFirst();
    	}
    	
    	return res;
    }
    
    private int[] mergeArray(int[] num1, int[] num2) {
    	int len1 = num1.length, len2 = num2.length;
    	int[] res = new int[len1 + len2];
    	
    	int i = 0, j = 0, pos = 0;
    	while(i < len1 && j < len2) {
    		boolean addNum1 = false;
    		int idx1 = i, idx2 = j;
    		while(idx1 < len1 && idx2 < len2 && num1[idx1] == num2[idx2]) {
				idx1++;
				idx2++;
    		}
    		
    		if (idx2 >= len2 || idx1 < len1 && num1[idx1] > num2[idx2])
    			addNum1 = true;
    		res[pos++] = addNum1 ? num1[i++] : num2[j++];
    	}
    	
    	while(i < len1) res[pos++] = num1[i++];
    	while(j < len2) res[pos++] = num2[j++];
    	
    	return res;
    }
}
