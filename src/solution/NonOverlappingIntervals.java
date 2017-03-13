package solution;

import java.util.Arrays;

/* Non-overlapping Intervals - Medium */
public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(Interval[] intervals) {
    	Arrays.sort(intervals, (a, b) -> (a.end - b.end));
        int maxIntervals = 0, end = Integer.MIN_VALUE;
        
        for(int i = 0; i < intervals.length; i++) {
        	if (end <= intervals[i].start) {
        		maxIntervals++;
        		end = intervals[i].end;
        	}
        }
        
        return intervals.length - maxIntervals;
    }
}
