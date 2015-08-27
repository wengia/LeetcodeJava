package solution;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> res = new LinkedList<List<String>>();
		if (strs.length == 0) return res;
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		
		for (int i = 0; i < strs.length; i++) {
			String current = strs[i];
			
			// Sort the string
			char tmp[] = current.toCharArray();
			Arrays.sort(tmp);
			String copy = new String(tmp);
			
			// Put into map
			if (!map.containsKey(copy)) {
				map.put(copy, new LinkedList<String>());
			}
			map.get(copy).add(current);
		}
		
		for (List<String> l: map.values()) {
			Collections.sort(l);
			res.add(l);
		}
		
		return res;
    }
}
