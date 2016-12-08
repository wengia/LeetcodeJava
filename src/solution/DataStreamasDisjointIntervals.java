package solution;

import java.util.*;

public class DataStreamasDisjointIntervals {
	private TreeMap<Integer, Integer> intervals = new TreeMap<>();
	
	/** Initialize your data structure here. */
    public DataStreamasDisjointIntervals() {
        
    }
    
    public void addNum(int val) {
        Integer startKey = intervals.floorKey(val);
        Integer endKey = intervals.ceilingKey(val);
        Integer startEnd = (startKey == null) ? null : intervals.get(startKey);
        
        if (startEnd != null && endKey != null && 
        		startEnd + 1 == val && val + 1 == endKey) {
        	Integer end = intervals.get(endKey);
    		intervals.remove(endKey);
    		intervals.put(startKey, end);
        } else if (startEnd != null && val == startEnd + 1) {
        	intervals.put(startKey, val);
        } else if (endKey != null && val == endKey - 1) {
        	Integer end = intervals.get(endKey);
    		intervals.remove(endKey);
    		intervals.put(val, end);
        } else if ((startEnd == null || val > startEnd + 1) &&
        		(endKey == null || val < endKey - 1)) {
        	intervals.put(val, val);
        }
    }
    
    public List<Interval> getIntervals() {
        List<Interval> res = new LinkedList<>();
        for(int start: intervals.keySet()) {
        	res.add(new Interval(start, intervals.get(start)));
        }
        
        return res;
    }
}
