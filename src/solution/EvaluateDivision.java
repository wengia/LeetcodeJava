package solution;

import java.util.*;

/* Evaluate Division - Medium */
public class EvaluateDivision {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, Map<String, Double>> adj = new HashMap<>();
        // Construct Adjacency matrix
        for(int i = 0; i < values.length; i++) {
        	String from = equations[i][0];
        	String to = equations[i][1];
        	addToAdj(adj, from, to, values[i]);
        	addToAdj(adj, to, from, 1.0 / values[i]);
        }
        
        double[] res = new double[queries.length];
        for(int i = 0; i < queries.length; i++) {
        	Double localCount = findPath(adj, new HashSet<String>(), queries[i][0], queries[i][1]);
        	res[i] = (localCount != null) ? localCount: -1.0;
        }
        
        return res;
    }
    
    private void addToAdj(Map<String, Map<String, Double>> adj, 
    		String from, String to, double val) {
    	if (!adj.containsKey(from))
    		adj.put(from, new HashMap<>());
    	adj.get(from).put(to, val);
    }
    
    private Double findPath(Map<String, Map<String, Double>> adj, Set<String> visited,
    		String from, String to) {
    	if (!adj.containsKey(from) || !adj.containsKey(to)) return null;
    	visited.add(from);
    	if (from.equals(to)) return 1.0;
    	
    	for(String next: adj.get(from).keySet()) {
    		if (visited.contains(next)) continue;
    		Double pathCount = findPath(adj, visited, next, to);
    		if (pathCount != null) {
    			return pathCount * adj.get(from).get(next);
    		}
    	}
    	
    	return null;
    }
}
