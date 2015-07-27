package solution;


public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.isEmpty()) return 0;
		int res = 0, start = 0;
		int noRepeat[] = new int[128];

        for (int end = 0; end < s.length(); end++) {
        	int currentChar = s.charAt(end);
        	if (noRepeat[currentChar] == 0) {
        		noRepeat[currentChar] = 1;
        	}
        	else {
        		for (;start < end; start++) {
        			if (s.charAt(start) == currentChar) {
        				start++;
        				break;
        			}
        			noRepeat[s.charAt(start)] = 0;
        		}
        	}
        	
        	int currentLength = end + 1 - start;
        	if (currentLength > res)
        		res = currentLength;
        }
		
		return res;
    }
}
