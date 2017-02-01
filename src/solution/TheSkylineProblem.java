package solution;

import java.util.*;

/* The Skyline Problem - Hard */
public class TheSkylineProblem {
	// Brute-force, O(N^2)
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new LinkedList<>();
        PriorityQueue<Integer> points = new PriorityQueue<>();
        
        // Find all possible points, O(NlogN) where N = buildings.length
        for(int i = 0; i < buildings.length; i++) {
        	points.add(buildings[i][0]);
        	points.add(buildings[i][1]);
        }
        
        // Build height with points, O(M) where M = number of possible points, M <= 2N
        int[][] heights = new int[points.size()][2];
        int length = 0;
        while(!points.isEmpty()) {
        	heights[length++][0] = points.poll();
        }
        
        // Update heights, O(M*N) = O(N^2)
        for(int i = 0; i < buildings.length; i++) {
        	for(int j = 0; j < length && heights[j][0] < buildings[i][1]; j++) {
        		if (heights[j][0] >= buildings[i][0]) {
        			heights[j][1] = Math.max(heights[j][1], buildings[i][2]);
        		}
        	}
        }
        
        // Record Skyline points, O(M) = O(N)
        for(int i = 0; i < length; i++) {
        	if (i == 0 || heights[i][1] != heights[i - 1][1]) {
        		res.add(new int[]{heights[i][0], heights[i][1]});
        	}
        }
        
        return res;
    }
    
    // Credit to https://briangordon.github.io/2014/08/the-skyline-problem.html
    // Space O(N), Time O(NlogN)
    public List<int[]> getSkylineTopSolution(int[][] buildings) {
    	LinkedList<int[]> res = new LinkedList<>();
        TreeMap<Integer, List<int[]>> points = new TreeMap<>();
        
        // Insert buildings according to start and end point
        // TreeMap adds node O(logN). Thus O(NlogN)
        for(int i = 0; i < buildings.length; i++) {
        	List<int[]> buildingList = points.get(buildings[i][0]);
        	if (buildingList == null) {
        		buildingList = new LinkedList<>();
        		points.put(buildings[i][0], buildingList);
        	}
        	buildingList.add(buildings[i]);
        	
        	buildingList = points.get(buildings[i][1]);
        	if (buildingList == null) {
        		buildingList = new LinkedList<>();
        		points.put(buildings[i][1], buildingList);
        	}
        	buildingList.add(buildings[i]);
        }
        
        // Update height
        PriorityQueue<int[]> overlap = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// Max Heap sorted by height
				if (o1[2] != o2[2])
					return o2[2] - o1[2]; // Higher height
				else if (o1[1] != o2[1])
					return o1[1] - o2[1]; // Finishing soon
				else
					return o2[0] - o1[0];
			}
        });
        
        // Count on each point, point number M <= 2*N
        // Time O(MlogM) -> O(NlogN)
        for(Map.Entry<Integer, List<int[]>> point: points.entrySet()) {
        	List<int[]> buildingList = point.getValue();
        	for(int[] b: buildingList) {
        		if (b[0] == point.getKey())
        			overlap.add(b);
        		else
        			overlap.remove(b);
        	}
        	
        	if (overlap.isEmpty()) {
        		res.add(new int[]{point.getKey(), 0});
        	} else if (res.isEmpty() || overlap.peek()[2] != res.peekLast()[1]) {
        		res.add(new int[]{point.getKey(), overlap.peek()[2]});
        	}
        }
        
        return res;
    }
}
