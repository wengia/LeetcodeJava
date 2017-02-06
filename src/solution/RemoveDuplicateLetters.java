package solution;

/* Remove Duplicate Letters - Hard */
public class RemoveDuplicateLetters {
	/* Greedy Solution:
	 * In all duplicates, place the smallest one by one.
	 * 
	 * 1. Record the pos of smallest char until s[i], where s[i] is the last duplicates of char s[i]
	 * 2. Place the s[pos] and continue check on s[pos+1 .. end]
	 * 
	 * Time: O(26 * N)
	 * Each recursion takes O(N). There are at most 26 recursion
	 * */
    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() == 0) return "";
        int[] duplicates = new int[26];
        for(int i = 0; i < s.length(); i++)
        	duplicates[s.charAt(i) - 'a']++;
        
        int pos = 0;
        for(int i = 0; i < s.length(); i++) {
        	if (s.charAt(i) < s.charAt(pos)) pos = i;
        	if (--duplicates[s.charAt(i) - 'a'] == 0) break;
        }
        
        char head = s.charAt(pos);
        return head + removeDuplicateLetters(s.substring(pos + 1, s.length()).replaceAll("" + head, ""));
    }
}
