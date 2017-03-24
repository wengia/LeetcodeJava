package solution;

/* Repeated Substring Pattern - Medium */
public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
    	if (s == null || s.length() < 2) return false;
        int len = s.length();
    	
        for(int i = 1; i < s.length(); i++) {
        	if (len % i == 0) {
        		String repeat = s.substring(0, i);
        		String shiftLeft = s.substring(i) + repeat;
        		if (shiftLeft.equals(s)) return true;
        	}
        }
        
        return false;
    }
    
    public boolean repeatedSubstringPatternKMP(String s) {
    	if (s == null || s.length() < 2) return false;
    	int n = s.length();
    	int[] t = new int[n];
    	kmp(s, t);
    	int len = t[n - 1];
    	return len > 0 && n % (n - len) == 0;
    }
    
    private void kmp(String s, int[] t) {
    	int i = 0, j = 1;
    	while(i < s.length() && j < s.length()) {
    		if (s.charAt(i) == s.charAt(j)) {
    			t[j++] = ++i;
    		} else {
    			if (i == 0)
    				t[j++] = 0;
    			else
    				i = t[i - 1];
    		}
    	}
    }
}
