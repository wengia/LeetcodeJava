package solution;

import java.math.BigInteger;

/* Additive Number - Medium */
public class AdditiveNumber {
	public boolean isAdditiveNumber(String num) {
        int len = num.length();
        if (len < 3) return false;
        
        // Check for all zero
        if (num.charAt(0) == '0' && num.charAt(1) == '0')
        	for(int i = 2; i < len; i++)
        		if (num.charAt(i) != '0')
        			return false;
        
        // Find the initial two numbers
        for(int n1End = 1; n1End <= len / 2; n1End++) {
        	if (n1End > 1 && num.charAt(0) == '0') break;
        	
        	BigInteger n1 = new BigInteger(num.substring(0, n1End));
        	for(int n2End = n1End + 1; n2End <= len - n1End; n2End++) {
        		if (n2End - n1End > 1 && num.charAt(n1End) == '0') break;
            	
        		BigInteger n2 = new BigInteger(num.substring(n1End, n2End));
        		
        		// Find if n1 and n2 could construct the Additive List
        		if (isValid(num, n1, n2, n2End))
        			return true;
        	}
        }
        
        return false;
    }
	
	private boolean isValid(String num, BigInteger n1, BigInteger n2, int start) {
		if (start == num.length()) return true;
		if (num.charAt(start) == '0') return false;
		
		BigInteger n3 = n1.add(n2);
		String sum = n3.toString();
		int len = sum.length();
		if (start + len > num.length() || 
				!sum.equals(num.substring(start, start + len)))
			return false;
		
		return isValid(num, n2, n3, start + len);
	}
}
