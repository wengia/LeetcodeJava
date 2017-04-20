package solution;

/* Implement strStr() - Easy */
public class ImplementstrStr {
	// Better KMP see 
	// http://www.geeksforgeeks.org/searching-for-patterns-set-2-kmp-algorithm/
	public int strStrKMP(String haystack, String needle) {
		if (needle.length() == 0) return 0;
		if (haystack.length() < needle.length()) return -1;
		char[] needleArr = needle.toCharArray();
		int[] t = kmp(needleArr);
		
		for(int posh = 0, posn = 0, len = haystack.length(); posh < len;) {
			if (posn == -1 || haystack.charAt(posh) == needleArr[posn]) {
				posh++;
				posn++;
				if (posn == needle.length())
					return posh - posn;
			}
			if (posh < len && haystack.charAt(posh) != needleArr[posn])
				posn = t[posn];
		}
		
		return -1;
	}
	
	private int[] kmp(char[] needle) {
		int n = needle.length;
		int[] t = new int[n];
		
		t[0] = -1;
		for(int pos = 0, cnt = -1; pos + 1 < n;) {
			if (cnt == -1 || needle[pos] == needle[cnt]) {
				t[pos + 1] = cnt + 1;
				if (needle[pos + 1] == needle[cnt + 1])
					t[pos + 1] = t[cnt + 1];
				pos++;
				cnt++;
			}
			if (needle[pos] != needle[cnt])
				cnt = t[cnt];
		}
		
		return t;
	}
	
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
