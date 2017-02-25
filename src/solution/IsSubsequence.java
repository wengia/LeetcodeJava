package solution;

import java.util.ArrayList;
import java.util.List;

/* Is Subsequence - Medium */
public class IsSubsequence {
	public boolean isSubsequence(String s, String t) {
		List<Integer>[] idx = new ArrayList[26];
		for(int i = 0; i < t.length(); i++) {
			int ch = t.charAt(i) - 'a';
			if (idx[ch] == null)
				idx[ch] = new ArrayList<>();
			idx[ch].add(i);
		}
		
		// Search for the s
		int prev = 0;
		for(int i = 0; i < s.length(); i++) {
			int ch = s.charAt(i) - 'a';
			if (idx[ch] == null) return false;
			
			int cur = binarySearch(idx[ch], prev);
			if (cur >= idx[ch].size()) return false;
			prev = idx[ch].get(cur) + 1;
		}
		
		return true;
	}
	
	private int binarySearch(List<Integer> nums, int target) {
		int left = 0, right = nums.size() - 1;
		while(left < right) {
			int mid = left + (right - left) / 2;
			if (nums.get(mid) == target)
				return mid;
			else if (nums.get(mid) > target)
				right = mid - 1;
			else
				left = mid + 1;
		}
		
		return nums.get(left) < target ? left + 1: left;
	}
	
	/* For just compare one s with a long t */
    public boolean isSubsequenceOne(String s, String t) {
        int posS = 0;
        for(int i = 0; i < t.length() && posS < s.length(); i++) {
        	if (s.charAt(posS) == t.charAt(i)) posS++;
        }
        
        return posS == s.length();
    }
}
