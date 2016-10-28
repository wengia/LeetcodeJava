package solution;

public class BitwiseANDofNumbersRange {
	// 0 <= m <= n <= 2147483647
	public int rangeBitwiseAnd(int m, int n) {
		if(m == n) return m;
        int mask = m & n;
        if (mask == 0) return 0;
        int res = 0;
        
        for(int i = 0; (mask >> i) > 0; i++) {
        	int curBit = 1 << i;
        	if((curBit & mask) != 0 && curBit > n - m) {
        		res |= curBit;
        	}
        }
        
        return res;
    }
}
