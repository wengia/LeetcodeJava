package solution;

public class FindtheDuplicateNumber {
	/* Question: Given an array nums containing n + 1 integers 
	 * where each integer is between 1 and n (inclusive), 
	 * prove that at least one duplicate number must exist. 
	 * Assume that there is only one duplicate number, find the duplicate one.
	 */
	
	/* Solution: The list of numbers in ascending order could be
	 * 1, 2, 3, ..., n-1, n, n
	 * Noted that if len = nums.length, then last number must <= len - 1.
	 * (Which means the following example is not existing
	 * 1,2,1,4)
	 * 
	 * Thus nums[len - 1] != len. Choose last number as a starter
	 * Then use the slow/fast as find cycle in single linked list
	 * */
	public int findDuplicate(int[] nums) {
		int len = nums.length;
        int slow = len;
        int fast = len;
        do {
        	slow = nums[slow - 1];
        	fast = nums[nums[fast - 1] - 1];
        } while(slow != fast);
        
        slow = len;
        while(slow != fast) {
        	slow = nums[slow - 1];
        	fast = nums[fast - 1];
        }
        
        return slow;
    }
}
