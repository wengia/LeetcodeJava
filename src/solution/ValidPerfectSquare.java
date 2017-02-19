package solution;

/* Valid Perfect Square - Easy */
public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
    	int start = 0, end = num;
    	
    	while(start <= end) {
    		int mid = start + (end - start) / 2;
    		long midSqr = (long)mid * mid;
    		if (midSqr == num)
    			return true;
    		else if (midSqr < num)
    			start = mid + 1;
    		else
    			end = mid - 1;
    	}
    	
        return false;
    }
}
