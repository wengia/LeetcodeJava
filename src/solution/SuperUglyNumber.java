package solution;


/* Super Ugly Number - Medium */
public class SuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n]; // ugly list
        int[] l = new int[primes.length];
        
        dp[0] = 1;
        for(int i = 1; i < n; i++) {
        	int localSmall = Integer.MAX_VALUE;
        	
        	// Find next ugly number
        	for(int j = 0; j < primes.length; j++) {
        		int tmp = dp[l[j]] * primes[j];
        		localSmall = Math.min(tmp, localSmall);
        	}
        	dp[i] = localSmall;
        	
        	// Update index list
        	for(int j = 0; j < primes.length; j++) {
        		if (dp[l[j]] * primes[j] == localSmall) l[j]++;
        	}
        }
        
        return dp[n - 1];
    }
}
