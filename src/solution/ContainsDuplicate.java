package solution;

import java.util.*;

public class ContainsDuplicate {
	public boolean containsDuplicate(int[] nums) {
		Set<Integer> hash = new HashSet<Integer>();
		for(int n : nums) {
			if(hash.contains(n))
				return true;
			hash.add(n);
		}
		
        return false;
    }
}
