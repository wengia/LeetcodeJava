package solution;

import java.util.Set;

public class MinimumWindowSubstring {
	public String minWindow(String s, String t) {
        int start = -1, end = s.length();
		int m = s.length(), n = t.length(), count = 0;
		int found[] = new int[256], need[] = new int[256];
		
		for (int i = 0; i < n; i++) {
			need[t.charAt(i)]++;
		}
		
		for (int curStart = 0, curEnd = 0; curEnd < m; curEnd++) {
			if (need[s.charAt(curEnd)] == 0) continue;
			
			// Find char needed
			if (found[s.charAt(curEnd)] < need[s.charAt(curEnd)])
				count++;
			found[s.charAt(curEnd)]++;
			
			// Not found all needed yet
			if (count != n) continue;
			
			// Find start
			for(; curStart < curEnd; curStart++) {
				if (need[s.charAt(curStart)] == 0) continue;
				if (found[s.charAt(curStart)] == need[s.charAt(curStart)]) break;
				found[s.charAt(curStart)]--;
			}
			
			if (end - start > curEnd - curStart) {
				end = curEnd;
				start = curStart;
			}
		}
		
		return start == -1 ? "" : s.substring(start, end + 1);
    }
	
	
	/**
	 * Another question for return the length of the shortest substing in s which
	 * contains all charaters in target.
	 * 
	 * @param s
	 * @param target
	 * @return
	 */
	public int searchCharacter(String s, Set<Character> target) {
		int count = 0, m = s.length();
		int start = -1, end = 0, res = m;
		int found[] = new int[256];

		for (; end < m; end++) {
			if (!target.contains(s.charAt(end))) continue;

			// when meeting char needed
			if (found[s.charAt(end)] == 0) count++;
			found[s.charAt(end)]++;
			
			if (count != target.size()) continue;

			// find start position when getting all needed
			for (; start < end; start++) {
				if (!target.contains(s.charAt(start))) continue;
			
				if (found[s.charAt(start)] == 1) break; // Delete all repeated
				found[s.charAt(start)]--;
			}
			
			if (res > end - start)
				res = end - start;
				
		}
		
		return (res == m + 1) ? 0 : res;
	}

}
