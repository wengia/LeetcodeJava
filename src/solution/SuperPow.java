package solution;

/* Super Pow - Medium */
public class SuperPow {
	/* Math part:
	 * Theory: (a * b) % k = (a % k) * (b % k) % k;
	 * thus
	 * a ^ 1234567 % k = (a ^ 1234560 % k) * (a ^ 7 % k) % k
	 * where
	 * a ^ 1234560 % k = (a ^ 123456) ^ 10 % k
	 *                 = (a ^ 123456 % k) ^ 10 % k;
	 * 
	 * */
	private final int base = 1337; 
    public int superPow(int a, int[] b) {
        double res = 1, len = b.length;
        for(int i = 0; i < len; i++) {
        	res = powMod((int)res, 10) * powMod(a, b[i]) % base;
        }
        
        return (int)res;
    }
    
    private int powMod(int a, int p) {
    	double res = 1;
    	while(p-- > 0) {
    		res = res * (a % base) % base;
    	}
    	
    	return (int)res;
    }
}
