package solution;

public class Numberof1Bits {
	public int hammingWeight(int n) {
		int res = 0, times = 32;
        while(times-- > 0 && n != 0) {
        	res += (n & 1);
        	n >>= 1;
        }
        
        return res;
    }
}
