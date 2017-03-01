package solution;

import java.util.HashSet;
import java.util.Set;

/* Frog Jump - Hard */
public class FrogJump {
	// Time worst case O(n^2), Space worst case O(n^2)
    public boolean canCross(int[] stones) {
    	if (stones.length < 2) return true;
    	int maxStep = 1; // The max unit frog could reach
    	int[] maxLen = new int[stones.length]; // The max unit frog could reach till [i]
    	Set<Integer>[] steps = new HashSet[stones.length];
    	
    	steps[0] = new HashSet<Integer>();
    	steps[0].add(1);
    	maxLen[0] = 1;
    	for(int i = 1; i < stones.length; i++) {
    		if (stones[i] > maxStep) break;
    		steps[i] = new HashSet<Integer>();
    		int localMaxLen = 0;
    		for(int j = i - 1; j >= 0; j--) {
    			if (maxLen[j] < stones[i]) break;
    			int step = stones[i] - stones[j];
    			if (steps[j].contains(step)) {
    				steps[i].add(step - 1);
    				steps[i].add(step);
    				steps[i].add(step + 1);
    				localMaxLen = Math.max(localMaxLen, step + 1 + stones[i]);
    			}
    		}
    		maxLen[i] = Math.max(maxLen[i - 1], localMaxLen);
    		maxStep = Math.max(maxStep, maxLen[i]);
    	}
    	
        return steps[stones.length - 1] != null && !steps[stones.length - 1].isEmpty();
    }
}
