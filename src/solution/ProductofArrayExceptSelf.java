package solution;

public class ProductofArrayExceptSelf {
	public int[] productExceptSelf(int[] nums) {
		int len = nums.length, fromLeft = 1, fromRight = 1;
        int res[] = new int[len];
        
        for(int i = 0; i < len; i++) {
        	res[i] = 1;
        }
        
        for(int i = 0; i < len; i++) {
        	res[i] *= fromLeft;
        	res[len - 1 - i] *= fromRight;
        	
        	fromLeft *= nums[i];
        	fromRight *= nums[len - 1 - i];
        }
        
        return res;
    }
}
