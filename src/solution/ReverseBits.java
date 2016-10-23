package solution;

public class ReverseBits {
	public int reverseBits(int n) {
        int res = 0, times = 32;
        while(times-- > 0) {
        	res = (res << 1) + (n & 1);
        	n >>= 1;
        }
        
        return res;
    }
}
