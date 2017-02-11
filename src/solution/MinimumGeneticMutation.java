package solution;

import java.util.*;

/* Minimum Genetic Mutation - Medium */
public class MinimumGeneticMutation {
    public int minMutation(String start, String end, String[] bank) {
    	int n = bank.length;
        int[] visited = new int[n];
        Queue<Integer> candidates = new LinkedList<>();
        
        // Find end in bank
        for(int i = 0; i < n; i++) {
        	if (end.equals(bank[i])) {
        		visited[i] = 1;
        		candidates.add(i);
        		break;
        	}
        }
        
        while(!candidates.isEmpty()) {
        	int currentIdx = candidates.poll();
        	// Already find the shortest one
        	if (mutable(start, bank[currentIdx])) {
    			return visited[currentIdx];
    		}
        	
        	for(int i = 0; i < n; i++) {
        		if (visited[i] > 0) continue;
        		if (!mutable(bank[currentIdx], bank[i])) continue;
        		
        		visited[i] = visited[currentIdx] + 1;
        		candidates.add(i);
        	}
        }
        
        return -1;
    }
    
    private boolean mutable(String s1, String s2) {
    	int diff = 0;
    	for(int i = 0; i < s1.length(); i++) {
    		if (s1.charAt(i) == s2.charAt(i)) continue;
    		if (++diff > 1) return false;
    	}
    	
    	return diff == 1;
    }
}
