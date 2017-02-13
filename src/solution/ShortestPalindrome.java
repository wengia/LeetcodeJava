package solution;

/* Shortest Palindrome - Hard */
public class ShortestPalindrome {
	public String shortestPalindrome(String s) {
		if (s == null || s.length() < 2) return s;
		return "";
    }
	
	// Return the cut
	public int shortestPalindromeFromBegin(String s) {
		boolean[][] isPalindrome = new boolean[2][s.length()];
		int ins = 0;
		
		for(; ins < s.length(); ins++) {
			int cur = (ins & 1);
			int first = ins + 2; // compare to s[1]
			int second = ins + 1; // compare to s[0]
			isPalindrome[cur][first] = (s.charAt(1) == s.charAt(first)) ? 
					isPalindrome[cur][first - 1] : false;
			isPalindrome[cur][second] = (s.charAt(0) == s.charAt(second)) ? 
					isPalindrome[cur][second - 1] : false;
		}
		
		return 0;
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
