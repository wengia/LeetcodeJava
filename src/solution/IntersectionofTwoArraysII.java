package solution;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/* Intersection of Two Arrays II - Easy */
public class IntersectionofTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> nums1cp = new HashMap<>();
        for(int num: nums1) {
        	int count = nums1cp.containsKey(num) ? nums1cp.get(num) : 0;
        	nums1cp.put(num, ++count);
        }
        
        List<Integer> intersection = new LinkedList<>();
        for(int num: nums2) {
        	Integer count = nums1cp.get(num);
        	if (count != null && count > 0) {
        		intersection.add(num);
        		nums1cp.put(num, --count);
        	}
        }
        
        int idx = 0;
        int[] res = new int[intersection.size()];
        for(int num: intersection) {
        	res[idx++] = num;
        }
        
        return res;
    }
}
