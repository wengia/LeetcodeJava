package solution;

public class LongestPalindromicSubstring {
	// Remove Double check for duplication. Faster
	public String longestPalindrome(String s) {
		if (s.length() < 2) return s;
		
        int len = s.length(), max_left = 0, max_len = 1, left, right;
        for (int start = 0; start < len && len - start > max_len / 2;) {
            left = right = start;
            while (right < len - 1 && s.charAt(right + 1) == s.charAt(right))
                ++right;
            start = right + 1;
            while (right < len - 1 && left > 0 && s.charAt(right + 1) == s.charAt(left - 1)) {
                ++right;
                --left;
            }
            if (max_len < right - left + 1) {
                max_left = left;
                max_len = right - left + 1;
            }
        }
        return s.substring(max_left, max_left + max_len);
	}
	
	
	// Time O(n * n), Space O(1)
	public String longestPalindromeIns(String s) {
        if (s == null || s.length() <= 1) return s;
        int start = 0, end = 0;
        
        for (int i = 1; i < s.length(); i++) {
        	int ins = 1;
        	
        	//odd
        	while (i - ins >= 0 && i + ins < s.length() && s.charAt(i - ins) == s.charAt(i + ins)) ins++;
        	if ((ins - 1) * 2 + 1 > end - start) {
        		start = i - ins + 1;
        		end = i + ins;
        	}
        	
        	//even
        	ins = 1;
        	while (i - ins >= 0 && i + ins <= s.length() && s.charAt(i - ins) == s.charAt(i + ins - 1)) ins++;
        	if ((ins - 1) * 2 > end - start) {
        		start = i - ins + 1;
        		end = i + ins - 1;
        	}
        }
        
        return s.substring(start, end);
    }
	
	// Time O(n*n), Space O(n)
	public String longestPalindrome_dp(String s) {
        if (s == null || s.length() <= 1) return s;
        int start = 0, end = 0, cur = 0;
        Boolean isPalindrome[][] = new Boolean[2][s.length()];
        
        for (int ins = 0; ins < s.length(); ins++) {
        	cur = (cur == 0) ? 1 : 0;
        	for (int i = s.length() - 1; i >= ins; i--) {
        		if (ins == 0 || ins == 1)
        			isPalindrome[cur][i] = (s.charAt(i) == s.charAt(i - ins));
        		else
        			isPalindrome[cur][i] = (s.charAt(i) == s.charAt(i - ins)) ? 
        					isPalindrome[cur][i - 1] : false;
        	
        		if (isPalindrome[cur][i] && ins > end - start) {
        			start = i - ins;
        			end = i;
        		}
        	}
        }
        
        return s.substring(start, end + 1);
    }
}
