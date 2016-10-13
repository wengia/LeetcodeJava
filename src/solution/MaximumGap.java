package solution;

import java.util.*;

public class MaximumGap {
	public int maximumGap(int[] nums) {
		if (nums == null || nums.length < 2)
			return 0;
		
		int min = nums[0], max = nums[0];
		for (int n : nums) {
			if (n < min) min = n;
			if (n > max) max = n;
		}
		
		int gap = (max - min) / nums.length + 1;
		int [][]bucket = new int[2][nums.length];
		Arrays.fill(bucket[0], Integer.MAX_VALUE);
		Arrays.fill(bucket[1], Integer.MIN_VALUE);
		for (int n: nums) {
			int idx = (n - min) / gap;
			if (n < bucket[0][idx]) bucket[0][idx] = n;
			if (n > bucket[1][idx]) bucket[1][idx] = n;
		}
		
		int res = bucket[1][0] - bucket[0][0], prev = bucket[1][0];
		for (int i = 1; i < nums.length; i++) {
			if (bucket[0][i] > bucket[1][i]) continue;
			res = Math.max(res, bucket[0][i] - prev);
			prev = bucket[1][i];
		}
        
        return res;
    }

	public int quickSortmaximumGap(int[] nums) {
		int res = 0;
        Arrays.sort(nums); // No, nlogn
        for (int i = 1; i < nums.length; i++) {
        	if (nums[i] - nums[i - 1] > res) {
        		res = nums[i] - nums[i - 1];
        	}
        }
        
        return res;
    }
}
