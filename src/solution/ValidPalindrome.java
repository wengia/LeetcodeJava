package solution;

public class ValidPalindrome {

	public boolean isPalindrome(String s) {
		int left = 0, right = s.length() - 1;
		s = s.toLowerCase();
		
		while(left < right) {
			while(left < right && !isAlphanumeric(s.charAt((left)))) left++;
			while(left < right && !isAlphanumeric(s.charAt((right)))) right--;
			if(s.charAt(left++) != s.charAt(right--))
				return false;
		}
		
        return true;
    }
	
	private boolean isAlphanumeric(char ch) {
		return ('a' <= ch && ch <= 'z' || 
				'A' <= ch && ch <= 'Z' ||
				'0' <= ch && ch <= '9');
	}
}
