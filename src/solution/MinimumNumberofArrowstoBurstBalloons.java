package solution;

import java.util.Arrays;

/* Minimum Number of Arrows to Burst Balloons - Medium */
public class MinimumNumberofArrowstoBurstBalloons {
	// Time O(NlogN)
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> (a[1] - b[1]));
        int shots = 0, end = Integer.MIN_VALUE;
        
        for(int i = 0; i < points.length; i++) {
        	int[] point = points[i];
        	if (i == 0 || end < point[0]) {
        		end = point[1];
        		shots++;
        	}
        }
        
        return shots;
    }
}
