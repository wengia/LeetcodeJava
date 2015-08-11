package solution;

public class UniquePathsII {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0)
        	return 0;
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int dp[] = new int[n];
        
        // If entrance or exit has obstacle, return 0
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1)
        	return 0;
        
        dp[0] = 1;
        for (int j = 1; j < n; j++)
        	dp[j] = (obstacleGrid[0][j] == 1) ? 0 : dp[j - 1];
        
        for (int i = 1; i < m; i++) {
        	dp[0] = (obstacleGrid[i][0] == 1) ? 0 : dp[0];
        	for (int j = 1; j < n; j++)
        		dp[j] = (obstacleGrid[i][j] == 1) ? 0 : dp[j] + dp[j - 1];
        }
        
        return dp[n - 1];
    }
}
