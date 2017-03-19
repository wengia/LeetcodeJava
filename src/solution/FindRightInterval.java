package solution;

import java.util.TreeMap;

/* Find Right Interval - Medium */
public class FindRightInterval {
	// Time O(NlogN)
    public int[] findRightInterval(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return new int[0];
        int[] res = new int[intervals.length];
        TreeMap<Integer, Integer> startPoints = new TreeMap<>();
        
        // Sort by start point
        for(int i = 0; i < intervals.length; i++) {
        	startPoints.put(intervals[i].start, i);
        }
        
        // find nearest right start point
        for(int i = 0; i < intervals.length; i++) {
        	Integer nearest = startPoints.ceilingKey(intervals[i].end);
        	res[i] = (nearest == null) ? -1 : startPoints.get(nearest);
        }
        
        return res;
    }
}
