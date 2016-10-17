package solution;

import java.util.*;

public class LargestNumber {
	public String largestNumber(int[] nums) {
		int idx = 0;
		String numsObj[] = new String[nums.length];
		for (int num: nums) numsObj[idx++] = Integer.toString(num);
		Arrays.sort(numsObj, new CompareByString());
		
		StringBuilder sb = new StringBuilder();
		for (String num: numsObj) {
			sb.append(num);
		}
		String s = sb.toString();
        return (s.length() == 0 || s.charAt(0) == '0') ? "0" : s;
    }
	
	private class CompareByString implements Comparator<String> {
		@Override
		public int compare(String o1, String o2) {
			String s1 = o1 + o2;
			String s2 = o2 + o1;
			
			return s2.compareTo(s1); // Descending
		}
	}
}
