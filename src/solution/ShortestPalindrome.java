package solution;

/* Shortest Palindrome - Hard */
public class ShortestPalindrome {
	// KMP, Time O(N)
	// c a t a c b # b c a t a c
	// 0 0 0 0 1 0 0 0 1 2 3 4 5
	public String shortestPalindrome(String s) {
		if (s == null || s.length() < 2) return s;
		
		// Find cutIdx
		String kmpString = s + "#" + new StringBuilder(s).reverse().toString();
		int[] kmpTable = new int[kmpString.length()];
		for(int pos = 1; pos < kmpString.length(); pos++) {
			int cnd = kmpTable[pos - 1];
			while(cnd > 0 && kmpString.charAt(cnd) != kmpString.charAt(pos))
				cnd = kmpTable[cnd - 1];
			
			if (kmpString.charAt(cnd) == kmpString.charAt(pos))
				cnd++;
			kmpTable[pos] = cnd;
		}
		
		// Construct result;
		int cutIdx = kmpTable[kmpString.length() - 1];
		if (cutIdx >= s.length()) return s;
		
		return new StringBuilder(s.substring(cutIdx)).reverse().append(s).toString();
    }
	
	// Time O(N^2). No Extra Space
    public String shortestPalindromeBruteForce(String s) {
        if (s == null || s.isEmpty()) return "";
        int cutIdx = s.length() - 1;
        for(; cutIdx > 0; cutIdx--) {
        	if (isPalindrome(s, cutIdx))
        		break;
        }
        
        StringBuilder res = new StringBuilder(s.substring(cutIdx + 1)).reverse().append(s);
        return res.toString();
    }
    
    private boolean isPalindrome(String s, int endIdx) {
    	int startIdx = 0;
    	while(startIdx < endIdx) {
    		if (s.charAt(startIdx++) != s.charAt(endIdx--))
    			return false;
    	}
    	
    	return true;
    }
}
