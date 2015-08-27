package solution;

public class ValidAnagram {
	public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int sSet[] = new int[256];
        
        for (int i = 0; i < s.length(); i++)
        	sSet[s.charAt(i)]++;
        
        for (int i = 0; i < t.length(); i++) {
        	char current = t.charAt(i);
        	if (sSet[current] <= 0) return false;
        	sSet[current]--;
        }
        
        return true;
    }
}
