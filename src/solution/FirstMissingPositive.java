package solution;

public class FirstMissingPositive {
	public int firstMissingPositive(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
        	int repeat = -1;
			while(0 <= (nums[i] - 1) && (nums[i] - 1) < nums.length 
					&& (nums[i] - 1) != i
					&& repeat != nums[i]){
				repeat = nums[i];
				int index = nums[i] - 1;
				nums[i] = nums[index];
				nums[index] = index + 1;
			}
        }
        
        for(int i = 0; i < nums.length; i++) {
        	if (nums[i] != i + 1)
        		return i + 1;
        }
        
        return nums.length + 1;
    }
}
