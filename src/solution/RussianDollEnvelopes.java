package solution;

import java.util.Arrays;
import java.util.Comparator;

/* Russian Doll Envelopes - Hard */
public class RussianDollEnvelopes {
	// Simple DP O(N^2)
    public int maxEnvelopes(int[][] envelopes) {
    	if (envelopes.length == 0 || envelopes[0].length == 0)
    		return 0;
        int res = 0, len = envelopes.length;
        int dp[] = new int[len];
        Arrays.sort(envelopes, new Comparator<int[]>(){
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] != o2[0])
					return o1[0] - o2[0];
				else
					return o1[1] - o2[1];
			}
        });
        
        for(int i = 0; i < len; i++) {
        	dp[i] = 1;
        	for(int j = 0; j < i; j++) {
        		if (envelopes[i][0] > envelopes[j][0] &&
        				envelopes[i][1] > envelopes[j][1])
        			dp[i] = Math.max(dp[i], 1 + dp[j]);
        	}
        	res = Math.max(dp[i], res);
        }
        
        return res;
    }
    
 // Simple DP O(NlogN)
    public int maxEnvelopesBest(int[][] envelopes) {
    	if (envelopes.length == 0 || envelopes[0].length == 0)
    		return 0;
        int count = 0, len = envelopes.length;
        int dp[] = new int[len];
        Arrays.sort(envelopes, new Comparator<int[]>(){
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] != o2[0]) // Ascending width
					return o1[0] - o2[0];
				else // Descending height to ensure not increasing dp length with the same width envelope
					return o2[1] - o1[1];
			}
        });
        
        for(int i = 0; i < len; i++) {
        	int height = envelopes[i][1];
        	int left = 0, right = count;
        	while(left < right) {
        		int mid = left + (right - left) / 2;
        		if (height <= dp[mid])
        			right = mid;
        		else
        			left = mid + 1;
        	}
        	/* Since height is descending in same width,
        	 * the "left" won't exceed the current dp length (count)
        	 * */
        	dp[left] = height;
        	if (left == count)
        		count++;
        }
        
        return count;
    }
}
