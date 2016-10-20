package solution;

public class DungeonGame {
	public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon.length == 0 || dungeon[0].length == 0) return 0;
		int m = dungeon.length, n = dungeon[0].length;
		int dp[][] = new int[m][n];
		
		dp[m - 1][n - 1] = (dungeon[m - 1][n - 1] >= 0) ? 0 : -dungeon[m - 1][n - 1];
		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				if (i == m - 1 && j == n - 1)
					continue;
				
				int right = (i == m - 1) ? Integer.MAX_VALUE : dp[i + 1][j];
				int down = (j == n - 1) ? Integer.MAX_VALUE : dp[i][j + 1];
				int minNextHp = Math.min(right, down);
				int curHp = dungeon[i][j] - minNextHp;
				
				dp[i][j] = (curHp >= 0) ? 0 : -curHp;
			}
		}
		
        return dp[0][0] + 1;
    }
	
}
