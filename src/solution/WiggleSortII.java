package solution;

/* Wiggle Sort II - Medium */
public class WiggleSortII {
    public void wiggleSort(int[] nums) {
        if (nums.length < 2) return;
        int n = nums.length;
        // after the sort below, the array becomes
        // .. small .. median .. large ..
        int median = findKLargestNumber(nums, (n + 1) / 2);
        
        
        int i = 0, left = 0, right = n - 1;
        while(i <= right) {
        	if (nums[newIdx(i, n)] > median)
        		swap(nums, newIdx(left++, n), newIdx(i++, n));
        	else if (nums[newIdx(i, n)] < median)
        		swap(nums, newIdx(right--, n), newIdx(i, n));
        	else
        		i++;
        }
    }
    
    private int findKLargestNumber(int[] nums, int k) {
    	return findKLargestNumber(nums, nums.length - k, 0, nums.length - 1);
    }
    
    private int findKLargestNumber(int[] nums, int k, int left, int right) {
    	if (left == right) return nums[left];
    	int l = left, r = right;
    	int pivotNum = nums[r];
    	
    	// Small left, large right
    	for(int i = l; i < r; i++) {
    		if (nums[i] < pivotNum)
    			swap(nums, l++, i);
    	}
    	swap(nums, l, r);
    	
    	if (l == k) return nums[l];
    	if (l < k) return findKLargestNumber(nums, k, l + 1, right);
    	else return findKLargestNumber(nums, k, left, l - 1);
    }
    
    private void swap(int[] nums, int idx1, int idx2) {
    	if (idx1 == idx2) return;
    	int tmp = nums[idx1];
    	nums[idx1] = nums[idx2];
    	nums[idx2] = tmp;
    }
    
    /* Find the new idx from current idx
     * 
     * Original idx: 0    1    2    3    4    5  
     * Mapped idx:   1    3    5    0    2    4 
     * 
     * n | 1 returns the nearest odd >= n
     * 
     * */
    private int newIdx(int idx, int n) {
    	return (1 + idx * 2) % (n | 1);
    }
}
