package solution;

import java.util.ArrayList;

/* Longest Absolute File Path - Medium */
public class LongestAbsoluteFilePath {
	// Example "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"
	
    public int lengthLongestPath(String input) {
        if (input == null || input.isEmpty()) return 0;
        int maxLength = 0, start = 0;
        ArrayList<Integer> level = new ArrayList<>();
        
        while(start < input.length()) {
        	// Count for level
        	int currentLevel = 0;
        	while(start < input.length() && 
        			'\t' == input.charAt(start)) {
        		start++;
        		currentLevel++;
        	}
        	int nextIndex = input.indexOf('\n', start);
        	if (nextIndex == -1) nextIndex = input.length();
        	String cur = input.substring(start, nextIndex);
        	
        	// Get length of previous level
        	int prev = (currentLevel == 0) ? 0 : level.get(currentLevel - 1);
        	
        	// If current location is a file, count for the length
        	if (cur.contains(".")) {
        		// If current location is a file, count for the length
        		// slashCount = currentLevel;
        		int len = prev + currentLevel + cur.length();
        		maxLength = Math.max(maxLength, len);
        	} else { 
    	    	// Re-calculate the currentLevel length
    	    	if (currentLevel == level.size()) {
    	    		level.add(prev + cur.length());
    	    	} else {
    	    		level.set(currentLevel, prev + cur.length());
    	    	}
        	}
        	
        	start = nextIndex + 1; // go for next '\t'
        }
        
        return maxLength;
    }
}
