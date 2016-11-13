package solution;

import java.util.*;

public class ContainsDuplicateII {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		Map<Integer, Integer> hash = new HashMap<>();
		for(int i = 0; i < nums.length; i++) {
			if(hash.containsKey(nums[i]) && i - hash.get(nums[i]) <= k)
				return true;
			hash.put(nums[i], i);
		}
		
        return false;
    }
}
