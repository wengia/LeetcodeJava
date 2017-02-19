package solution;

import java.util.*;

/* Largest Divisible Subset - Medium */
public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums == null || nums.length == 0) return new LinkedList<>();
        int maxLen = 0, lastNumIdx = -1;
        int[] count = new int[nums.length];
        int[] parent = new int[nums.length];
        Arrays.fill(parent, -1);
        Arrays.sort(nums); // Time, O(NlogN)
        
        // Collect each possible group. Time O(N^2)
        for(int i = 1; i < nums.length; i++) {
        	for(int j = 0; j < i; j++) {
        		if (nums[i] % nums[j] == 0 && count[i] < count[j] + 1) {
        			count[i] = count[j] + 1;
        			parent[i] = j;
        		}
        	}
        	
        	if (count[i] > maxLen) {
        		maxLen = count[i];
        		lastNumIdx = i;
        	}
        }
        
        // Construct Largest Set
        LinkedList<Integer> res = new LinkedList<Integer>();
        while(lastNumIdx != -1) {
        	res.addFirst(nums[lastNumIdx]);
        	lastNumIdx = parent[lastNumIdx];
        }
        
        return res;
    }
}
