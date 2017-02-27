package solution;

/* Rotate Function - Medium */
public class RotateFunction {
	/**
	 * sum = sum(A[0]..A[n - 1])
	 * f(0) = 0 * A[0] + 1 * A[1] + ... + (n - 1) * A[n - 1]
	 * f(1) = f(0) - (n - 1) * A[n - 1] + sum - A[n - 1] = f(0) - n * A[n - 1] + sum
	 * f(2) = f(1) - (n - 1) * A[n - 2] + sum - A[n - 2] = f(1) - n * A[n - 2] + sum
	 * ...
	 * f(n - 1) = f(n - 1) - n * A[1] + sum
	 * 
	 * 
	 * */
    public int maxRotateFunction(int[] A) {
    	if (A.length == 0) return 0;
    	int n = A.length, fk = 0;
        long sum = 0;
        
        for(int i = 0; i < n; i++) {
        	fk += i * A[i];
        	sum += A[i];
        }
        
        int res = fk;
        for(int k = 1; k < n; k++) {
        	long current = fk - n * A[n - k] + sum;
        	fk = (int) current;
        	res = Math.max(res, (int)current);
        }
        
        return res;
    }
}
