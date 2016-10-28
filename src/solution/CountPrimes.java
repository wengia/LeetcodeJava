package solution;


public class CountPrimes {
	public int countPrimes(int n) {
		if (n <= 2) return 0;
		boolean notPrime[] = new boolean[n];
		int count = 0;
		
		for(int i = 2; i < n; i++) {
			// Check if current is Prime number
			if (notPrime[i]) continue;
			
			count++;
			for(long j = (long)i; j * i < n; j++) {
				notPrime[(int)(j * i)] = true;
			}
		}
		
        return count;
    }
}
