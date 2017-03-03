package solution;

/* Longest Palindrome - Easy */
public class LongestPalindrome {
	public int longestPalindrome(String s) {
		if (s == null || s.length() == 0) return 0;
        int[] hash = new int[54];
        
        for(int i = 0; i < s.length(); i++) {
        	hash[charToIdx(s.charAt(i))]++;
        }
        
        // Calculate the palindrome length
        int odd = 0;
        for(int count: hash) {
        	odd += (count & 1);
        }
        
        return s.length() - odd + (odd > 0 ? 1 : 0);
    }
	
	private int charToIdx(char ch) {
		if ('a' <= ch && ch <= 'z') return ch - 'a';
		return 26 + ch - 'A';
	}
}
