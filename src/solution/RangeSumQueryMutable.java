package solution;

/* Range Sum Query - Mutable - Medium 
 * 
 * Credit to http://www.hawstein.com/posts/binary-indexed-trees.html
 * Check class NumArray for segment tree method
 * 
 * */
public class RangeSumQueryMutable {
	private int[] BIT; // Binary Index Tree
	private int[] nums;

    //public NumArray(int[] nums) {
    public RangeSumQueryMutable(int[] nums) {
    	int n = nums.length;
    	this.nums = nums;
    	BIT = new int[n + 1];
    	for(int i = 1; i <= n; i++)
    		updateBIT(i, nums[i - 1]);
    }
    
    public void update(int i, int val) {
    	int diff = val - nums[i];
    	nums[i] = val;
    	updateBIT(i + 1, diff);
    }
    
    public int sumRange(int i, int j) {
    	return sumAtIndex(j + 1) - sumAtIndex(i); // O(2 * logN)
    }
    
    // Time: O(logN)
    private void updateBIT(int idx, int val) {
    	while(idx < BIT.length) {
    		BIT[idx] += val;
    		idx += (idx & -idx);
    	}
    }
    
    // Time: O(logN)
    private int sumAtIndex(int idx) {
    	int sum = 0;
    	while(idx > 0) {
    		sum += BIT[idx];
    		idx -= (idx & -idx);
    	}
    	
    	return sum;
    }
}
