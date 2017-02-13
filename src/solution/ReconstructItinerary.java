package solution;

import java.util.*;

/* Reconstruct Itinerary - Medium */
public class ReconstructItinerary {
	// Find Eulerian path
    public List<String> findItinerary(String[][] tickets) {
        LinkedList<String> res = new LinkedList<>();
        Map<String, PriorityQueue<String>> sortedTickets = new HashMap<>();
        
        // Re-arrange tickets
        for(String[] ticket: tickets) {
        	if (!sortedTickets.containsKey(ticket[0])) {
        		sortedTickets.put(ticket[0], new PriorityQueue<String>());
        	}
        	sortedTickets.get(ticket[0]).add(ticket[1]);
        }
        
        res.add("JFK");
        findItinerary(sortedTickets, res, "JFK");
        
        return res;
    }
    
    private void findItinerary(Map<String, PriorityQueue<String>> sortedTickets, 
    		LinkedList<String> res, String current) {
    	while(sortedTickets.containsKey(current) && !sortedTickets.get(current).isEmpty()) {
    		findItinerary(sortedTickets, res, sortedTickets.get(current).poll());
    	}
    	
    	res.addFirst(current);
    }
}
