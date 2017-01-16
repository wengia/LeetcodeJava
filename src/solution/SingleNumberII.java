package solution;

public class SingleNumberII {
	public int singleNumber(int[] nums) {
		int ones = 0, twos = 0;
	    for(int i = 0; i < nums.length; i++){
	        ones = (ones ^ nums[i]) & ~twos;
	        twos = (twos ^ nums[i]) & ~ones;
	    }
	    return ones;
    }
	
	// General case
	public int singleNumberGeneral(int[] nums) {
		int res = 0;
		int K = 3;
		
		for(int i = 0; i < 32; i++) {
			int count = 0;
			int currentBit = 1 << i;
			for(int num : nums) {
				if ((num & currentBit) != 0)
					count++;
			}
			if (count % K != 0)
				res |= currentBit;
		}
		
	    return res;
    }
}
