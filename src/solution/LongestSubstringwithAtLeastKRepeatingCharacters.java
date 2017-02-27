package solution;

/* Longest Substring with At Least K Repeating Characters - Medium */
public class LongestSubstringwithAtLeastKRepeatingCharacters {
    public int longestSubstring(String s, int k) {
    	int len = 0;
        
    	for(int first = 0; first + k <= s.length(); first++) {
        	int[] letterCount = new int[26];
        	int mask = 0;
        	int max_last = first;
        	for(int last = first; last < s.length(); last++) {
        		int idx = s.charAt(last) - 'a';
        		letterCount[idx]++;
        		
        		if (letterCount[idx] < k)
        			mask |= (1 << idx);
        		else
        			mask &= (~(1 << idx));
        		
        		if (mask == 0) {
        			len = Math.max(len, last - first + 1);
        			max_last = last;
        		}
        	}
        	first = max_last;
        }
        
        return len;
    }
}
