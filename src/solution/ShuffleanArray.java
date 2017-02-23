package solution;

import java.util.Random;

/* Shuffle an Array - Medium */
public class ShuffleanArray {
	private int[] nums;
	Random rand = new Random();

    //public Solution(int[] nums) {
	public ShuffleanArray(int[] nums) {
        this.nums = nums;
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] res = nums.clone();
        for(int i = 0; i < nums.length; i++) {
        	int j = rand.nextInt(i + 1);
        	swap(res, i, j);
        }
        
        return res;
    }
    
    private void swap(int[] nums, int i, int j) {
    	int tmp = nums[i];
    	nums[i] = nums[j];
    	nums[j] = tmp;
    }
}
