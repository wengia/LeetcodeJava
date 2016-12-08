package solution;

import java.util.*;

public class SummaryRanges {
	public List<String> summaryRanges(int[] nums) {
		List<String> res = new LinkedList<>();
		int i = 0, n = nums.length;
		
		while(i < n) {
			int j = 1;
			while(i + j < n && nums[i + j] - nums[i] == j) j++;
			if (j == 1)
				res.add(nums[i] + "");
			else
				res.add(nums[i] + "->" + nums[i + j - 1]);
			i += j;
		}
		
		return res;
	}
	
	public List<String> summaryRangesFirstThought(int[] nums) {
        List<String> res = new LinkedList<>();
        if (nums.length == 0) return res;
        if (nums.length == 1) {
        	res.add(String.valueOf(nums[0]));
        	return res;
        }
        
        int lastStart = nums[0];
        for(int i = 1; i < nums.length; i++) {
        	if (nums[i] == nums[i - 1] + 1 && i != nums.length - 1)
        		continue;
        	
        	if (nums[i] != nums[i - 1] + 1) {
        		if (lastStart == nums[i - 1])
            		res.add(String.valueOf(lastStart));
            	else
            		res.add(lastStart + "->" + nums[i - 1]);
        		
        		if (i == nums.length - 1)
            		res.add(String.valueOf(nums[i]));
        		lastStart = nums[i];
        	} else {
        		res.add(lastStart + "->" + nums[i]);
        	}
        }
        
        return res;
    }
}
