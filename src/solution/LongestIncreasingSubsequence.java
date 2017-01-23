package solution;

/* Longest Increasing Subsequence - Medium */
public class LongestIncreasingSubsequence {
	// use DP to reduce the time on searching back. O(N) -> O(logN)
	// tails[i] represents the last number in the increasing list of size == i + 1
	// if multiple increasing list share the same size, tails[i] would be the smallest tail.
	// Solution:
	// if num > tails[size - 1], add tails[size++] = num
	// if tails[i - 1] < num <= tails[i], update tails[i] = num
	public int lengthOfLIS(int[] nums) {
        int size = 0;
        int tails[] = new int[nums.length];
        for(int num: nums) {
        	int i = 0, j = size;
        	while(i != j) {
        		int mid = i + (j - i) / 2;
        		if (tails[mid] < num)
        			i = mid + 1;
        		else
        			j = mid;
        	}
        	
        	tails[i] = num;
        	if (i == size) size++;
        }
        
        return size;
    }
}
