package solution;

import java.util.LinkedList;
import java.util.List;

/* Find All Duplicates in an Array - Medium */
public class FindAllDuplicatesinanArray {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new LinkedList<>();
        
        for(int num: nums) {
        	int idx = Math.abs(num) - 1;
        	if (nums[idx] < 0)
        		res.add(Math.abs(num));
        	nums[idx] = -nums[idx];
        }
        
        return res;
    }
}
