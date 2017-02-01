package solution;

import java.util.*;

/* Minimum Height Trees - Medium */
public class MinimumHeightTrees {
	// Time: O(N) + O(edges.size)
	// For a valid tree, edges.size == n - 1
	// Thus Time is O(N)
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		if (n == 1) {
			List<Integer> res = new LinkedList<>();
			res.add(0);
			return res;
		}
		
        List<Set<Integer>> adj = new ArrayList<>(n);
        
        // Init adj and leaves
        for(int i = 0; i < n; i++) {
        	adj.add(new HashSet<Integer>());
        }
        	
        for(int i = 0; i < edges.length; i++) {
        	adj.get(edges[i][0]).add(edges[i][1]);
        	adj.get(edges[i][1]).add(edges[i][0]);
        }
        
        List<Integer> leaves = new LinkedList<>();
        for(int i = 0; i < adj.size(); i++) {
        	if (adj.get(i).size() == 1) leaves.add(i);
        }
        
        while(n > 2) {
        	n -= leaves.size();
        	List<Integer> newLeaves = new LinkedList<>();
        	for(Integer leave: leaves) {
        		Integer vertex = adj.get(leave).iterator().next();
        		adj.remove(leave);
        		adj.get(vertex).remove(leave);
        		if (adj.get(vertex).size() == 1) newLeaves.add(vertex);
        	}
        	leaves = newLeaves;
        }
        
        return leaves;
    }
}
