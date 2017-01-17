package solution;

public class MissingNumber {
	// Sort the nums to check missing number
    public int missingNumber(int[] nums) {
    	int MISSING_FLAG = -1;
    	for(int i = 0; i < nums.length; i++) {
    		if (nums[i] == i) continue;
    		
    		// Put nums[i] to where it should be
    		int pos = i;
    		while(nums[pos] != MISSING_FLAG && nums[pos] != pos) {
    			int index = nums[pos];
	    		if (index == nums.length) {
	    			nums[pos] = MISSING_FLAG;
	    		} else {
	    			nums[pos] = nums[index];
	    			nums[index] = index;
	    		}
    		}
    	}
    	
    	for(int i = 0; i < nums.length; i++) {
    		if (nums[i] == -1)
    			return i;
    	}
    	
        return nums.length;
    }
    
    // Sum
    public int missingNumberBySum(int[] nums) {
    	int res = nums.length * (nums.length + 1) / 2;
    	for(int i = 0; i < nums.length; i++) {
    		res -= nums[i];
    	}
    	return res;
    }
    
    // XOR, based on a^b^b = a
    public int missingNumberByXOR(int[] nums) {
    	int res = nums.length;
    	for(int i = 0; i < nums.length; i++) {
    		res = res ^ i ^ nums[i];
    	}
    	return res;
    }
}
