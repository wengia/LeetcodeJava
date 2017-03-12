package solution;

import java.util.HashSet;
import java.util.Set;

/* Maximum XOR of Two Numbers in an Array - Medium */
public class MaximumXORofTwoNumbersinanArray {
	public int findMaximumXOR(int[] nums) {
        int maxXOR = 0, mask = 0;
        
        for(int i = 31; i >= 0; i--) {
        	mask |= (1 << i);
        	Set<Integer> prefixSet = new HashSet<>();
        	for(int num: nums) {
        		prefixSet.add(num & mask);
        	}
        	
        	int tmp = maxXOR | (1 << i);
        	for(Integer prefix: prefixSet) {
        		if (prefixSet.contains(prefix ^ tmp)) {
        			maxXOR = tmp;
        			break;
        		}
        	}
        }
        
        return maxXOR;
    }
	
    public int findMaximumXORTrie(int[] nums) {
        int maxXOR = 0;
        Trie root = new Trie();
        
        // Init Trie
        for(int num: nums) {
        	Trie cur = root;
        	for(int i = 31; i >= 0; i--) {
        		int curBit = (num >>> i) & 1;
        		if (cur.children[curBit] == null) {
        			cur.children[curBit] = new Trie();
        		}
        		cur = cur.children[curBit];
        	}
        }
        
        // Check max sum
        for(int num: nums) {
        	Trie cur = root;
        	int sum = 0;
        	for(int i = 31; i >= 0; i--) {
        		int curBit = (num >>> i) & 1;
        		if (cur.children[curBit ^ 1] != null) {
        			sum += (1 << i);
        			cur = cur.children[curBit ^ 1];
        		} else {
        			cur = cur.children[curBit];
        		}
        	}
        	maxXOR = Math.max(maxXOR, sum);
        }
        		
        return maxXOR;		
    }
	
    private class Trie {
    	Trie[] children;
    	private Trie() {
    		children = new Trie[2]; 
    	}
    }
}
