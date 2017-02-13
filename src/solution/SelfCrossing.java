package solution;

/* Self Crossing - Hard */
public class SelfCrossing {
	/* 
	 * Crossing at the following three postions:
	 * 1. i >= 3 && x[i] >= x[i - 2] && x[i - 3] >= x[i - 1]
	 *    i-3   /|\
	 *   --------|---
	 *  |        |
	 *  |i-2     |i
	 *  |        |
	 *   -------- 
	 *    i-1 
	 * 
	 * 2. i >= 4 && x[i - 3] == x[i - 1] && x[i] + x[i - 4] >= x[i - 2]
	 *     i-3
	 *  ----------
	 * |          |i-4
	 * |i-2      /|\
	 * |          |i
	 *  ----------
	 *     i-1
	 *     
	 * 3. i >= 5 && x[i - 2] >= x[i - 4] && x[i] + x[i - 4] >= x[i - 2] &&
	 *    x[i - 1] <= x[i - 3] && x[i - 1] + x[i - 5] >= x[i - 3]
	 *     i-3
	 *  -----------
	 * |           |i-4
	 * |      i-5  |
	 * |     ------
	 * |i-2  /|\
	 * |      |i
	 *  ------
	 *     i-1
	 * 
	 * */
    public boolean isSelfCrossing(int[] x) {
        if (x == null || x.length < 4) return false;
        
        for(int i = 3; i < x.length; i++) {
        	if (i >= 3 && x[i] >= x[i - 2] && x[i - 3] >= x[i - 1]) return true;
        	if (i >= 4 && x[i - 3] == x[i - 1] && x[i] + x[i - 4] >= x[i - 2]) return true;
        	if (i >= 5 && x[i - 2] > x[i - 4] && x[i] + x[i - 4] > x[i - 2] &&
        			x[i - 1] <= x[i - 3] && x[i - 1] + x[i - 5] >= x[i - 3]) return true;
        }
        
        return false;
    }
}
