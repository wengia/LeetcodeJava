package solution;

import java.util.*;

/* Insert Delete GetRandom O(1) - Medium */
public class RandomizedSet {
	private Map<Integer, Integer> nums = new HashMap<>(); // <val, idx>
	private ArrayList<Integer> numList = new ArrayList<>(); // val list
	private Random rand = new Random();
	private int size = -1;

    /** Initialize your data structure here. */
    public RandomizedSet() {
    	
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
    	if (nums.containsKey(val)) return false;
    	nums.put(val, ++size);
    	if (size == numList.size())
    		numList.add(val);
    	else
    		numList.set(size, val);
        
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
    	if (!nums.containsKey(val)) return false;
    	int targetIdx = nums.get(val);
    	if (targetIdx != size) {
    		int moveVal = numList.get(size);
    		nums.put(moveVal, targetIdx);
    		numList.set(targetIdx, moveVal);
    	}
    	
    	nums.remove(val);
    	size--;
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
    	int idx = rand.nextInt(size + 1);
        return numList.get(idx);
    }
}
