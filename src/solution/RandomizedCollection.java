package solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;

public class RandomizedCollection {
	private Map<Integer, HashSet<Integer>> nums = new HashMap<>(); // <val, list<idx>>
	private ArrayList<Integer> numList = new ArrayList<>(); // val list
	private Random rand = new Random();
	private int size = -1;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
    	boolean succeeded = false;
    	if (!nums.containsKey(val)) {
    		succeeded = true;
    		nums.put(val, new HashSet<Integer>());
    	}
    	
    	nums.get(val).add(++size);
    	if (size == numList.size())
    		numList.add(val);
    	else
    		numList.set(size, val);
        
        return succeeded;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
    	if (!nums.containsKey(val)) return false;
    	
    	int targetIdx = nums.get(val).iterator().next();
    	nums.get(val).remove(targetIdx);
    	if (targetIdx != size) {
    		int moveVal = numList.get(size);
    		nums.get(moveVal).remove(size);
    		nums.get(moveVal).add(targetIdx);
    		numList.set(targetIdx, moveVal);
    	}
    	
    	if (nums.get(val).isEmpty())
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
