package solution;

import java.util.HashMap;
import java.util.Map;

/* Arithmetic Slices II - Hard */
public class ArithmeticSlicesII {
    public int numberOfArithmeticSlices(int[] A) {
        int res = 0;
        Map<Integer, Integer>[] arithmeticList = new HashMap[A.length]; 
        
        for(int i = 0; i < A.length; i++) {
        	arithmeticList[i] = new HashMap<>();
        	for(int j = 0; j < i; j++) {
        		long diff = (long)A[i] - A[j];
        		if (diff > Integer.MAX_VALUE || diff < Integer.MIN_VALUE) continue;
        		
        		int count1 = arithmeticList[i].getOrDefault((int)diff, 0);
        		int count2 = arithmeticList[j].getOrDefault((int)diff, 0);
        		res += count2;
        		arithmeticList[i].put((int)diff, count1 + count2 + 1);
        	}
        }
        
        return res;
    }
}
