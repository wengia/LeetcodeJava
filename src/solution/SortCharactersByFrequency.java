package solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/* Sort Characters By Frequency - Medium */
public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        int len = s.length();
        HashMap<Character, Integer> frequency = new HashMap<>();
        
        // Count frequency, O(N)
        for(int i = 0; i < len; i++) {
        	int count = frequency.containsKey(s.charAt(i)) ? frequency.get(s.charAt(i)) : 0;
        	frequency.put(s.charAt(i), ++count);
        }
        
        // Sort frequency, O(M) where M is the amount of distinct char in s
        List<Character>[] sortedChar = new List[len + 1];
        for(char ch: frequency.keySet()) {
        	int fre = frequency.get(ch);
        	if (sortedChar[fre] == null) {
        		sortedChar[fre] = new LinkedList<Character>();
        	}
        	sortedChar[fre].add(ch);
        }
        
        // Construct result, O(N)
        StringBuilder sb = new StringBuilder();
        for(int i = len; i > 0; i--) {
        	if (sortedChar[i] == null) continue;
        	for(char ch: sortedChar[i]) {
        		char[] chArr = new char[i];
        		Arrays.fill(chArr, ch);
        		sb.append(chArr);
        	}
        }
        
        return sb.toString();
    }
}
