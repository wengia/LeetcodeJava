package solution;

/* Integer Break - Medium */
public class IntegerBreak {
	// Math solution credit to "Why factor 2 or 3? The math behind this problem"
    public int integerBreak(int n) {
    	if (n <= 3) return n - 1;
        int[] lessTen = new int[]{0, 1, 2, 3, 4, 6, 9, 12, 18, 27, 36};
        int res = 1;
        while(n > 10) {
        	n -= 3;
        	res *= 3;
        }
        
        return res * lessTen[n];
    }
}
