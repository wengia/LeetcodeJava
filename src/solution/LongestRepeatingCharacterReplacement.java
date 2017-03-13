package solution;

/* Longest Repeating Character Replacement - Medium */
public class LongestRepeatingCharacterReplacement {
	// Window sliding
	public int characterReplacement(String s, int k) {
		if (s == null) return 0;
		int maxLen = 0;
		int[] counts = new int[26];
		int start = 0, end = 0, maxCount = 0;
		
		for(; end < s.length(); end++) {
			int ch = s.charAt(end) - 'A';
			maxCount = Math.max(maxCount, ++counts[ch]);
			while(end - start + 1 - maxCount > k) {
				counts[s.charAt(start) - 'A']--;
				start++;
			}
			maxLen = Math.max(maxLen, end - start + 1);
		}
		
        return maxLen;
    }
}
