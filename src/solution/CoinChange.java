package solution;

/* Coin Change - Medium */
public class CoinChange {
	// Time O(amount * N) , Space O(amount)
    public int coinChange(int[] coins, int amount) {
    	int[] dp = new int[amount + 1];
    	
    	for(int i = 1; i <= amount; i++) {
    		dp[i] = amount + 1;
    		for(int coin: coins) {
    			if (coin <= i)
    				dp[i] = Math.min(dp[i], dp[i - coin] + 1);
    		}
    	}
    	
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
