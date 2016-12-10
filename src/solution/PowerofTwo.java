package solution;

public class PowerofTwo {
	// If n <= 0, return false
	public boolean isPowerOfTwo(int n) {
		while(n > 1) {
			if (n % 2 != 0)
				return false;
			n /= 2;
		}
		
        return n == 1;
    }
}
