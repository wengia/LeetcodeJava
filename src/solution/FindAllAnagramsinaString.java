package solution;

import java.util.*;

public class FindAllAnagramsinaString {
	public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new LinkedList<>();
        if (p.length() > s.length())
        	return res;
        
        int target[] = new int[26], found[] = new int[26];
        int count = 0, start = -1;
        for (int i = 0; i < p.length(); i++) {
        	target[p.charAt(i) - 'a']++;
        }
        
        for (int i = 0; i < s.length(); i++) {
        	int idx = s.charAt(i) - 'a';
        	if (target[idx] == 0) {
        		Arrays.fill(found, 0);
        		start = -1;
        		count = 0;
        		continue;
        	}
        	
        	if (start == -1) start = i;
        	found[idx]++;
        	count++;
        	
        	for (; start <= i && found[idx] > target[idx]; start++) {
        		found[s.charAt(start) - 'a']--;
        		count--;
        	}
        	
        	if (count == p.length())
        		res.add(start);
        }
        
        return res;
    }
}
