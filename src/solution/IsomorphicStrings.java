package solution;

import java.util.*;

public class IsomorphicStrings {
	// Warning part: If using "int", two Integer objects are created from "int" (or taken from that cache), 
	// and they might not be the same. Operation == compares object.
	public boolean isIsomorphic(String s, String t) {
		Map<Character, Integer> sMap = new HashMap<>();
		Map<Character, Integer> tMap = new HashMap<>();
		for (Integer i = 0; i < s.length(); i++) { // Key part
			if (sMap.put(s.charAt(i), i) != tMap.put(t.charAt(i), i))
				return false;
		}
		
        return true;
    }
}
