package solution;

import java.util.*;

public class FindAllNumbersDisappearedinanArray {
	public List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> res = new LinkedList<>();
        for(int num: nums) {
        	int index = Math.abs(num) - 1;
        	nums[index] = -Math.abs(nums[index]);
        }
        
        for(int i = 0; i < nums.length; i++) {
        	if (nums[i] > 0) {
        		res.add(i + 1);
        	}
        }
        
        return res;
    }
}
