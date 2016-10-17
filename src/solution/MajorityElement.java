package solution;

import java.util.*;

public class MajorityElement {
	// Hash, Time O(n), Space O(n)
	public int majorityElement(int[] nums) {
		if (nums.length < 3) return nums[0];
        Map<Integer, Integer> count = new HashMap<>();
        
        for (int n: nums) {
        	int times = 1;
        	if (count.containsKey(n))
        		times = count.get(n) + 1;
        	count.put(n, times);
        }
        
        for (Map.Entry<Integer, Integer> number : count.entrySet()) {
        	if (number.getValue() > nums.length / 2)
        		return number.getKey();
        }
        
        return nums[0];
    }
	
	// Hash, Time O(n), Space O(1)!
	// The key point is major element > (but not equal) n / 2
	public int majorityElementGenius(int[] nums) {
		int major = nums[0], count = 1;
        for(int i = 1; i < nums.length;i++){
            if(count==0){
                count++;
                major = nums[i];
            } else if(major == nums[i]){
                count++;
            } else
            	count--;
        }
        return major;
	}
}
