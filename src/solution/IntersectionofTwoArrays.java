package solution;

import java.util.HashSet;

/* Intersection of Two Arrays II - Easy */
public class IntersectionofTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> nums1cp = new HashSet<>();
        for(Integer num: nums1)
        	nums1cp.add(num);
        
        HashSet<Integer> intersection = new HashSet<>();
        for(Integer num: nums2) {
        	if (nums1cp.contains(num))
        		intersection.add(num);
        }
        
        int[] res = new int[intersection.size()];
        int idx = 0;
        for(int num: intersection)
        	res[idx++] = num;
        
        return res;
    }
}
