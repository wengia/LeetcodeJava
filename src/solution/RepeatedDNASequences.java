package solution;

import java.util.*;

public class RepeatedDNASequences {
	public List<String> findRepeatedDnaSequences(String s) {
        Set<String> res = new HashSet<>();
        if (s.length() <= 10) return new LinkedList<>();
        Set<Integer> repeats = new HashSet<>();
        int tmp = 0, mask = (1 << 20) - 1;
        
        for (int i = 0; i < s.length(); i++) {
        	tmp = (tmp << 2) + convert(s.charAt(i));
        	tmp = tmp & mask;
        	if (i < 9)
        		continue;
        	
        	if (!repeats.isEmpty() && repeats.contains(tmp))
        		res.add(s.substring(i - 9, i + 1));
        	else 
        		repeats.add(tmp);
        }	
        
        return new LinkedList<String>(res);
    }
	
	private int convert(char ch) {
		switch(ch) {
			case 'A': return 0; // A - 00
			case 'C': return 1; // C - 01
			case 'G': return 2; // G - 10
		}
		
		return 3; // T - 11
	}
}
