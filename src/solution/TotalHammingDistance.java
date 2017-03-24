package solution;

import java.util.HashMap;

/* Total Hamming Distance - Medium */
public class TotalHammingDistance {
	public int totalHammingDistance(int[] nums) {
		int total = 0, n = nums.length;
		for(int i = 0; i < 32; i++) {
			int oneCount = 0;
			for(int num: nums)
				oneCount += (num >>> i) & 1;
			total += oneCount * (n - oneCount);
		}
		
		return total;
	}
	
	
	// Too slow!
    public int totalHammingDistanceSlow(int[] nums) {
        int res = 0;
        HashMap<Integer, Integer> distinct = new HashMap<>();
        for(int num: nums) {
        	distinct.put(num, distinct.getOrDefault(num, 0) + 1);
        }
        
        while(!distinct.isEmpty()) {
        	int i = distinct.keySet().iterator().next();
        	int iCount = distinct.get(i);
        	distinct.remove(i);
        	for(int j: distinct.keySet()) {
        		int cur = i ^ j;
        		res += Integer.bitCount(cur) * iCount * distinct.get(j);
        	}
        }
        
        return res;
    }
}
