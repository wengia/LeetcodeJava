package solution;

import java.util.HashMap;

/* Word Pattern - Easy*/
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
    	String[] tokens = str.split(" ");
    	if (pattern.length() != tokens.length) return false;
    	HashMap<Character, Integer> patternHash = new HashMap<>();
    	HashMap<String, Integer> tokenHash = new HashMap<>();
    	
    	for(Integer i = 0; i < pattern.length(); i++) {
    		if (patternHash.put(pattern.charAt(i), i) != tokenHash.put(tokens[i], i))
    			return false;
    	}
    	
        return true;
    }
}
