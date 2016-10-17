package solution;

public class FactorialTrailingZeroes {
	public int trailingZeroes(int n) {
		int res = 0;
		long factor = 5;
		while (factor <= n) {
			res += n / factor;
			factor *= 5;
		}
        return res;
    }
}
