package solution;

/* Best Time to Buy and Sell Stock with Cooldown - Medium */
public class BestTimetoBuyandSellStockwithCooldown {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
    	int len = prices.length;
        int buy[] = new int[len];
        int sell[] = new int[len];
        int rest[] = new int[len];
        
        buy[0] = -prices[0];
        sell[0] = 0;
        rest[0] = 0;
        for(int i = 1; i < prices.length; i++) {
        	buy[i] = Math.max(buy[i - 1], rest[i - 1] - prices[i]); // Spend minimum, could only buy after rest on day i - 1
        	sell[i] = Math.max(sell[i - 1], prices[i] + buy[i - 1]); // Best profit
        	//rest[i] = Math.max(rest[i - 1], Math.max(sell[i - 1], buy[i - 1])); // Do nothing
        	rest[i] = Math.max(rest[i - 1], sell[i - 1]); // Do nothing and remain last best profit
        }
        
        return sell[len - 1];
    }
    
    // Saving space to O(1)
    public int maxProfitBetter(int[] prices) {
        if (prices.length < 2) return 0;
    	int buy = -prices[0], last_buy = -prices[0];
        int sell = 0, last_sell = 0;
        int rest = 0, last_rest = 0;
        for(int i = 1; i < prices.length; i++) {
        	last_buy = buy;
        	last_sell = sell;
        	last_rest = rest;
        	
        	buy = Math.max(last_buy, last_rest - prices[i]);
        	sell = Math.max(last_sell, prices[i] + last_buy);
        	rest = Math.max(last_rest, last_sell);
        }
        
        return sell;
    }
}
