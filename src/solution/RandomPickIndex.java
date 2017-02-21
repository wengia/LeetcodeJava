package solution;

import java.util.*;

/* Random Pick Index - Medium */
public class RandomPickIndex {
	private int[] nums;
	
	/*--------Reservoir sampling, O(1) Space, O(1) time init, O(N) time pick ------*/
//	public Solution(int[] nums) {
//		this.nums = nums;
//	}
	
	public int pickR(int target) {
        int count = 0, res = -1;
        for(int i = 0; i < nums.length; i++) {
        	if (nums[i] != target) continue;
        	
        	int select = rand.nextInt(++count);
        	if (select == 0)
        		res = i;
        }
        return res;
    }
	
	/*----------- Intuitive O(N) Space, O(N) time init, O(1) time pick ---------*/
	private Map<Integer, List<Integer>> numIdx = new HashMap<>();
    private Random rand = new Random();

    public RandomPickIndex(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
        	if (!numIdx.containsKey(nums[i])) {
        		numIdx.put(nums[i], new ArrayList<Integer>());
        	}
        	numIdx.get(nums[i]).add(i);
        }
    }
    
    public int pick(int target) {
        List<Integer> idxList = numIdx.get(target);
        if (idxList == null) return -1;
        int res = rand.nextInt(idxList.size());
        return idxList.get(res);
    }
}
