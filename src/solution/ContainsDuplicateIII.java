package solution;

import java.util.*;

public class ContainsDuplicateIII {
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		TreeSet<Integer> treeSet = new TreeSet<>();
		for(int i = 0; i < nums.length; i++) {
			int num = nums[i];
			if (treeSet.floor(num) != null && num <= treeSet.floor(num) + t ||
					treeSet.ceiling(num) != null && num >= treeSet.ceiling(num) - t)
				return true;
			
			treeSet.add(num);
			if (i >= k)
				treeSet.remove(nums[i - k]);
		}
		
        return false;
    }
}
