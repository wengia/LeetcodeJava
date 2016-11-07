package solution;

public class LongestPalindromicSubstring {
	// Time O(n * n), Space O(1)
	public String longestPalindrome(String s) {
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
        		if (ins == 0 || ins ==1)
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
