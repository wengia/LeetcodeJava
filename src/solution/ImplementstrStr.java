package solution;

public class ImplementstrStr {
	public int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) return -1;
        int kbase = 256, kmod = 997, len = needle.length();
        int h_hash = 0, n_hash = 0, power = 0;
        
        for (int i = 0; i < needle.length(); i++) {
        	h_hash = (h_hash * kbase + haystack.charAt(i)) % kmod;
        	n_hash = (n_hash * kbase + needle.charAt(i)) % kmod;
        	power = (i == 0) ? 1 : power * kbase % kmod;
        }
        
        for (int i = needle.length(); i < haystack.length(); i++) {
        	if (h_hash == n_hash && haystack.substring(i - len, i).equals(needle))
        		return i - len;
        	
        	h_hash -= (haystack.charAt(i - len) * power) % kmod;
        	if (h_hash < 0)
        		h_hash += kmod;
        	
        	h_hash = (h_hash * kbase + haystack.charAt(i)) % kmod;
        }
        
        if (h_hash == n_hash && haystack.substring(haystack.length() - len).equals(needle))
    		return haystack.length() - len;
        
        return -1;
    }
}
