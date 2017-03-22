package solution;

import java.util.HashMap;

/* 4Sum II - Medium */
public class FourSumII {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int res = 0, n = A.length;
        HashMap<Integer, Integer> twosum = new HashMap<>();
        
        for(int i = 0; i < n; i++) {
        	for(int j = 0; j < n; j++) {
        		int sum = A[i] + B[j];
        		twosum.put(sum, twosum.getOrDefault(sum, 0) + 1);
        	}
        }
        
        for(int i = 0; i < n; i++) {
        	for(int j = 0; j < n; j++) {
        		int sum = C[i] + D[j];
        		res += twosum.getOrDefault(-sum, 0);
        	}
        }
        
        return res;
    }
}
