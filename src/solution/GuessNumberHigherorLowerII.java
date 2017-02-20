package solution;

/* Guess Number Higher or Lower II - Medium */
public class GuessNumberHigherorLowerII {
	/**
	 * 1 - 0
	 * 2 - 1
	 * 3 - 2
	 * 4 - 1 + 3 win or 2 + 3
	 * 5 - 2 + 4 win or 3 + 4
	 * 6 - 2 + 3 + 5 or 3 + 5 win or 4 + 5
	 * ...
	 * 
	 * dp[i][j], min price to pay when guess between [i, j]
	 * 
	 * */
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for(int j = 2; j <= n; j++) {
        	for(int i = j - 1; i >= 1; i--) {
        		dp[i][j] = Integer.MAX_VALUE;
        		for(int k = i; k < j; k++) {
        			int localprice = k + Math.max(dp[i][k - 1], dp[k + 1][j]);
        			dp[i][j] = Math.min(dp[i][j], localprice);
        		}
        	}
        }
        
        return dp[1][n];
    }
}
