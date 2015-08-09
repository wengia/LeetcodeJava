package solution;

public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (divisor == 0)
        	return Integer.MAX_VALUE;
        else if (dividend == 0)
        	return 0;
        
    	long res = 0;
        long dividendCP = Math.abs((long)dividend);
        long divisorCP = Math.abs((long)divisor);
        boolean positive = (dividend < 0 && divisor < 0 || dividend > 0 && divisor > 0);
        
        while (divisorCP <= dividendCP) {
        	long quat = 1;
        	long tmp = divisorCP;
        	
        	while ((tmp << 1) <= dividendCP) {
        		tmp <<= 1;
        		quat <<= 1;
        	}
        	
        	res += quat;
        	if (positive && res > Integer.MAX_VALUE || !positive && -res < Integer.MIN_VALUE)
        		return Integer.MAX_VALUE;
        	dividendCP = dividendCP - tmp;		
        }
        
        return positive ? (int)res : - (int)res;
    }
}
