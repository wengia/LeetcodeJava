package solution;

import java.util.*;

// Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. 
// The algorithm should run in linear time and in O(1) space.
public class MajorityElementII {
	// Time O(n), Space O(n)
	public List<Integer> majorityElement(int[] nums) {
		Map<Integer, Integer> count = new HashMap<>();
		List<Integer> majors = new LinkedList<>();
        
        for (int n: nums) {
        	int times = 1;
        	if (count.containsKey(n))
        		times = count.get(n) + 1;
        	count.put(n, times);
        }
        
        for (Map.Entry<Integer, Integer> number : count.entrySet()) {
        	if (number.getValue() > nums.length / 3)
        		majors.add(number.getKey());
        }
        
        return majors;
    }
	
	// For general case of elements appears > n / k
	// // Time O(kn), Space O(k)
	public List<Integer> majorityElementGenius(int[] nums) {
		List<Integer> majors = new LinkedList<>();
		if (nums == null || nums.length == 0) return majors;
		int n = nums.length, k = 3; // majors should be the elements appears > n/k
		int candidates[] = new int[k - 1]; // At most there is (k - 1) elements;
		int counter[] = new int[k - 1];
		Arrays.fill(candidates, nums[0]);
		Arrays.fill(counter, 0);
		
		// Find candidates
		for (int num : nums) {
			boolean selected = false;
			for (int i = 0; i < k - 1; i++) {
				if (num == candidates[i]) {
					counter[i]++;
					selected = true;
					break;
				}
			}
			if (selected) continue;
			
			for (int i = 0; i < k - 1; i++) {
				if (counter[i] == 0) {
					candidates[i] = num;
					counter[i] = 1;
					selected = true;
					break;
				}
			}
			if (selected) continue;
			
			for (int i = 0; i < k - 1; i++) {
				if (counter[i] > 0) counter[i]--;
			}
		}
		
		// calculate appearance times of candidates
		Arrays.fill(counter, 0);
		for (int num : nums) {
			for (int i = 0; i < k - 1; i++) {
				if (candidates[i] == num) {
					counter[i]++;
					break;
				}
			}
		}
		
		// Get majors
		for (int i = 0; i < k - 1; i++) {
			if (counter[i] > n / k)
				majors.add(candidates[i]);
		}
		
		return majors;
	}
}
