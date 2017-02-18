package solution;

/* Count Numbers with Unique Digits - Medium */
public class CountNumberswithUniqueDigits {
	/* 0      1              2           ...     10
	 * 1    9 * A(9, 0)    9 * A(9, 1)   ...   9 * A(9, 9)
	 * 
	 * When the digits make by more than 10 digits, there must be duplicates.
	 * 
	 * */
    public int countNumbersWithUniqueDigits(int n) {
    	if (n == 0) return 1; // dp[0] = 1
        int sum = 10; // dp[1] = 9
    	//int[] dp = new int[10];
    	int base = 9;
    	for(int i = 2; i <= Math.min(n, 10); i++) {
    		base *= (9 - i + 2); // do permutation
    		sum += base;
    	}
    	
        return sum;
    }
}
