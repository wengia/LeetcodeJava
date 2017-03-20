package solution;

/* Count The Repetitions - Hard */
public class CountTheRepetitions {
	// Credit to "C++ solution inspired by @70664914 with organized explanation"
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int[] repeatCount = new int[n1 + 1];
        int[] nextIdx = new int[n1 + 1];
        int cnt = 0, j = 0;
        
        for(int k = 1; k <= n1; k++) {
        	// Check each loop
        	for(int i = 0; i < s1.length(); i++) {
        		if (s1.charAt(i) == s2.charAt(j)) j++;
        		if (j == s2.length()) {
        			j = 0;
        			cnt++;
        		}
        	}
        	
        	// Update repeatCount & nextIdx
        	repeatCount[k] = cnt;
        	nextIdx[k] = j;
        	
        	// Check if loop found
        	for(int start = 0; start < k; start++) {
        		if (nextIdx[start] == nextIdx[k]) {
        			int prefixCount = repeatCount[start];
        			int patternCount = (repeatCount[k] - repeatCount[start]) * (n1 - start) / (k - start);
        			int suffixCount = repeatCount[start + (n1 - start) % (k - start)] - repeatCount[start];
        			return (prefixCount + patternCount + suffixCount) / n2;
        		}
        	}
        }
        
        return repeatCount[n1] / n2;
    }
}
