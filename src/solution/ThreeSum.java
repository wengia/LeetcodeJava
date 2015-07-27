package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (nums == null || nums.length < 3) return res;
		Arrays.sort(nums);
        
        for (int i = 0; i < nums.length; i++) {
        	if (i > 0 && nums[i] == nums[i - 1]) continue;
        	
        	int l = i + 1, r = nums.length - 1;
        	while (l < r) {
        		int twosum = nums[l] + nums[r];
        		if (twosum + nums[i] > 0)
        			r--;
        		else if (twosum + nums[i] < 0)
        			l++;
        		else {
        			res.add(Arrays.asList(nums[i], nums[l++], nums[r--]));
        			while (l < r && nums[l] == nums[l - 1]) l++;
        			while (l < r && nums[r] == nums[r + 1]) r--;
        		}
        		
        	}
        }
        
        return res;
    }
}
