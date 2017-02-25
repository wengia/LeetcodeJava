package solution;

import java.util.HashMap;
import java.util.Map;

/* Perfect Rectangle - Hard */
public class PerfectRectangle {
	/**                |         |
	 * y2 = rect[3] -----------------
	 *                 |         |
	 * y1 = rect[1] -----------------
	 *                 |         |
	 *           x1 = rect[0]   x2 = rect[2]
	 * 
	 * Assign
	 * left-bottom : (0001) = 1
	 * left-top    : (0010) = 2
	 * right-top   : (0100) = 4
	 * right-bottom: (1000) = 8
	 * 
	 * All valid joint
	 * 1 + 2 + 4 + 8 = 15
	 * 1 + 2 = 3
	 * 4 + 8 = 12
	 * 2 + 4 = 6
	 * 1 + 8 = 9
	 * 
	 * */
    public boolean isRectangleCover(int[][] rectangles) {
    	if (rectangles == null || rectangles.length == 0) return true;
        int sum = 0;
        int x1 = rectangles[0][0], y1 = rectangles[0][1];
        int x2 = rectangles[0][2], y2 = rectangles[0][3];
        Map<String, Integer> corner = new HashMap<>();
        
        // Time O(N). N = rectangles.length
        for(int[] rect: rectangles) {
        	x1 = Math.min(x1, rect[0]);
        	y1 = Math.min(y1, rect[1]);
        	x2 = Math.max(x2, rect[2]);
        	y2 = Math.max(y2, rect[3]);
        	
        	sum += (rect[2] - rect[0]) * (rect[3] - rect[1]);
        	
        	if (found(corner, rect[0] + " " + rect[1], 1)) return false;
        	if (found(corner, rect[0] + " " + rect[3], 2)) return false;
        	if (found(corner, rect[2] + " " + rect[3], 4)) return false;
        	if (found(corner, rect[2] + " " + rect[1], 8)) return false;
        }
        
        // Check invalid joint. Time O(N) because check at most 4 * N times.
        corner.remove(x1 + " " + y1);
        corner.remove(x1 + " " + y2);
        corner.remove(x2 + " " + y2);
        corner.remove(x2 + " " + y1);
        
        for(Integer jointCount: corner.values()) {
        	if (jointCount == 15 ||
        			jointCount == 3 ||
        			jointCount == 12 ||
        			jointCount == 6 ||
        			jointCount == 9) continue;
        	
        	return false;
        }
        
        return sum == (x2 - x1) * (y2 - y1);
    }
    
    private boolean found(Map<String, Integer> corner, String point, int type) {
    	if (!corner.containsKey(point)) {
    		corner.put(point, type);
    		return false;
    	}
    	
    	int count = corner.get(point);
    	boolean res = (count & type) != 0;
    	corner.put(point, count | type);
    	
    	return res;
    }
}
