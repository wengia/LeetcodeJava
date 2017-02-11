package solution;

import java.util.*;

/* LFU (Least Frequently Used) Cache - Hard 
 * 
 * There are one hidden requirement:
 * LRU (Least Recently Used) cache also included. The "least frequently used" means
 * 1. Element been visited in the lowest frequency
 * 2. Element not been visited for a long time
 * 
 * Example
 * ["LFUCache","put","put","put","put","get","get","get","get","put","get","get","get","get","get"]
 * [[3],[1,1],[2,2],[3,3],[4,4],[4],[3],[2],[1],[5,5],[1],[2],[3],[4],[5]]
 * 
 * [null,null,null,null,null,4,3,2,-1,null,-1,2,3,-1,5]
 * 
 * */
public class LFUCache {
	private int capacity;
	private int lowestFre = 0;
	private HashMap<Integer, Node> cache;
	// frequencyMap: key - frequency, value - items in sequence of oldest -> newest
	private HashMap<Integer, LinkedHashSet<Integer>> frequencyMap;
	
	public LFUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        frequencyMap = new LinkedHashMap<>();
    }
    
    public int get(int key) {
    	if (capacity == 0) return -1;
    	Node target = findKey(key);
    	return (target == null) ? -1 : target.val;
    }
    
    public void put(int key, int value) {
    	if (capacity == 0) return;
    	
    	// Update current maps if key is included
    	if (cache.containsKey(key)) {
    		Node node = findKey(key);
    		node.val = value;
    		return;
    	}
    	
    	// Add new item
    	if (cache.size() == capacity) {
    		int lastItem = frequencyMap.get(lowestFre).iterator().next();
    		frequencyMap.get(lowestFre).remove(lastItem);
    		cache.remove(lastItem);
    	}
    	Node current = new Node(key, value);
    	lowestFre = current.frequency;
    	cache.put(key, current);
    	if (!frequencyMap.containsKey(0))
    		frequencyMap.put(0, new LinkedHashSet<Integer>());
    	
    	frequencyMap.get(0).add(key);
    }
    
    private Node findKey(int key) {
    	if (!cache.containsKey(key)) return null;
    	
    	Node current = cache.get(key);
    	
    	// Update frequency map
    	int fre = current.frequency++;
    	frequencyMap.get(fre).remove(key);
    	
    	if (!frequencyMap.containsKey(current.frequency)) {
    		frequencyMap.put(current.frequency, new LinkedHashSet<Integer>());
    	}
    	frequencyMap.get(current.frequency).add(key);
    	
    	// update lowestFre
    	if (lowestFre == fre && frequencyMap.get(fre).isEmpty()) {
    		lowestFre++;
    	}
    	
    	return current;
    }
    
    private class Node {
    	int key, val; // In fact key is not needed.
    	int frequency = 0;
    	
    	private Node(int key, int val) {
    		this.key = key;
    		this.val = val;
    	}
    }
}
