package solution;

import java.util.HashSet;
import java.util.Set;

/* Patching Array - Hard */
public class PatchingArray {
	/* Simple way to understand
	 * Miss number initial by 1.
	 * Miss number represents the largest missing number till index i.
	 * 
	 * Assume current idx is i, we have all numbers till "miss"
	 * 1, 2, ..., miss
	 * If nums[i] <= miss, then ..., miss, ..., miss + nums[i] is included
	 * Else we need to add miss to the list, so that
	 * ..., miss, miss + 1, ..., miss + miss is included
	 * 
	 * In this way we could reduce the Time to O(logN).
	 * Worst case we have nothing in nums, and we add
	 * 1, 2, 4, 8, ..., n (or 2^miss > n)
	 * 
	 * miss must be long because there is case
	 * minPatches([1,2,31,33], 2147483647)
	 * 
	 * */
    public int minPatches(int[] nums, int n) {
        long miss = 1;
        int patches = 0, i = 0;
        
        while(miss <= n) {
        	if (i < nums.length && nums[i] <= miss)
        		miss += nums[i++];
        	else {
        		miss += miss;
        		patches++;
        	}
        }
        
        return patches;
    }
	
	// Exceed Time Limitation
    public int minPatchesExceedTime(int[] nums, int n) {
        int patches = 0;
        Set<Integer> sums = new HashSet<>();
        
        // Initial sums set
        for(int i = 0; i < nums.length; i++) {
        	Set<Integer> newSums = new HashSet<>();
        	newSums.add(nums[i]);
        	for(int prevSum: sums) {
        		int sum = prevSum + nums[i];
        		if (sum <= n && !sums.contains(sum))
        			newSums.add(sum);
        	}
        	sums.addAll(newSums);
        }
        
        // Add patch
        for(int i = 1; i <= n && sums.size() < n; i++) {
        	if (sums.contains(i)) continue;
        	
        	patches++;
        	Set<Integer> newSums = new HashSet<>();
        	newSums.add(i);
        	for(int prevSum: sums) {
        		int sum = prevSum + i;
        		if (sum <= n && !sums.contains(sum))
        			newSums.add(sum);
        	}
        	sums.addAll(newSums);
        }
        
        return patches;
    }
}
