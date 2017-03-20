package solution;

import java.util.HashMap;
import java.util.Map;

/* Number of Boomerangs - Easy */
public class NumberofBoomerangs {
    public int numberOfBoomerangs(int[][] points) {
    	int res = 0;
    	Map<Integer, Integer> distanceCount = new HashMap<>();
    	
    	for(int i = 0; i < points.length; i++) {
    		for(int j = 0; j < points.length; j++) {
    			if (i == j) continue;
    			
    			int dist = (points[i][0] - points[j][0]) * (points[i][0] - points[j][0]) +
    					(points[i][1] - points[j][1]) * (points[i][1] - points[j][1]);
    			
    			int count = (distanceCount.containsKey(dist)) ?
    				count = distanceCount.get(dist): 0;
    			distanceCount.put(dist, ++count);
    		}
    		
    		for(int count: distanceCount.values()) {
    			res += count * (count - 1);
    		}
    		
    		distanceCount.clear();
    	}
    	
        return res;
    }
}
