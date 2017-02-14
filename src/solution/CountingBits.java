package solution;

/* Counting Bits - Medium */
public class CountingBits {
	public int[] countBits(int num) {
		int[] dp = new int[num + 1];
		for(int i = 1; i <= num; i++)
			dp[i] = dp[i >> 1] + (i & 1);
		
		return dp;
	}
	
    public int[] countBitsMe(int num) {
        int[] dp = new int[num + 1];
        int start = 1;
        
        while(start <= num) {
        	long next = start << 1;
        	int end = (int) (next > Integer.MAX_VALUE ? num : Math.min(next - 1, num));
        	for(int idx = start; idx <= end; start++) {
        		dp[idx] = dp[idx - start] + 1;
        	}
        	
        	start = end + 1;
        }
        
        return dp;
    }
}
