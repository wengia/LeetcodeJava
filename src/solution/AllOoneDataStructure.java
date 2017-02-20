package solution;

import java.util.*;

/* All O`one Data Structure - Hard */
public class AllOoneDataStructure {
	private HashMap<String, FreNode> words = new HashMap<>();
	private FreNode head;
	
    /** Initialize your data structure here. */
    //public AllOne() 
    public AllOoneDataStructure() {
    	head = new FreNode(0);
        head.next = head;
        head.prev = head;
    }
	
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
    	if (words.containsKey(key)) {
    		FreNode cur = words.get(key);
    		if (cur.next.count != cur.count + 1) {
    			if (cur.members.size() == 1)
    				cur.count++;
    			else {
    				cur.members.remove(key);
    				
    				FreNode newNode = new FreNode(cur.count + 1);
    				newNode.members.add(key);
    				cur.next.prev = newNode;
    				newNode.next = cur.next;
    				newNode.prev = cur;
    				cur.next = newNode;
    				
    				words.put(key, newNode);
    			}
    		} else {
    			cur.next.members.add(key);
    			words.put(key, cur.next);
    			
    			cur.members.remove(key);
    			if (cur.members.isEmpty()) {
    				cur.prev.next = cur.next;
    				cur.next.prev = cur.prev;
    			}
    		}
    	} else {
    		if (head.next.count == 1) {
    			head.next.members.add(key);
    		} else {
	    		FreNode cur = new FreNode(1);
	    		cur.members.add(key);
	    		
	    		cur.next = head.next;
	    		head.next.prev = cur;
	    		head.next = cur;
	    		cur.prev = head;
    		}
    		words.put(key, head.next);
    	}
    }
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
    	if (!words.containsKey(key)) return;
    	
    	FreNode cur = words.get(key);
    	cur.members.remove(key);
    	
    	if (cur.count != 1) {
    		if (cur.prev.count == cur.count - 1) {
        		cur.prev.members.add(key);
        	} else {
        		FreNode newNode = new FreNode(cur.count - 1);
        		newNode.members.add(key);
        		cur.prev.next = newNode;
        		newNode.prev = cur.prev;
        		cur.prev = newNode;
        		newNode.next = cur;
        	}
    		words.put(key, cur.prev);
    	} else {
    		words.remove(key);
    	}
    	
    	if (cur.members.isEmpty()) {
    		cur.prev.next = cur.next;
    		cur.next.prev = cur.prev;
    	}
    }
    
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if (head.prev == head) return "";
        return head.prev.members.iterator().next();
    }
    
    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if(head.next == head) return "";
        return head.next.members.iterator().next();
    }
    
    private class FreNode {
    	int count;
    	Set<String> members = new HashSet<>();
    	FreNode prev, next;
    	
    	private FreNode(int count) {
    		this.count = count;
    	}
    }
}
