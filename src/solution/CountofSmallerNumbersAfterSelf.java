package solution;

import java.util.*;

/* Count of Smaller Numbers After Self - Hard */
public class CountofSmallerNumbersAfterSelf {
	/*--------------------- Binary Search Tree Solution -------------------------*/
	// BST. Space O(N), Time avg O(NlogN) but worst O(N^2))
	public List<Integer> countSmallerBST(int[] nums) {
		List<Integer> res = new LinkedList<>();
		if (nums.length == 0) return res;
		
		Node root = new Node(nums[nums.length - 1], 0);
		res.add(0);
		for(int i = nums.length - 2; i >= 0; i--)
			buildBST(root, 0, nums[i], res);
		
		Collections.reverse(res);
		return res;
	}
	
	// Insert one node costs average O(logN), worst case O(N)
	private Node buildBST(Node root, int prevSum, int num, List<Integer> res) {
		if (root == null) {
			Node node = new Node(num, 0);
			res.add(prevSum);
			return node;
		} else if (num == root.val) {
			root.duplicated++;
			res.add(prevSum + root.sum);
		} else if (num < root.val) {
			root.sum++;
			root.left = buildBST(root.left, prevSum, num, res);
		} else { // num > root.val
			root.right = buildBST(root.right, prevSum + root.sum + root.duplicated, num, res);
		}
		
		return root;
	}
	
	private class Node {
		Node left, right;
		int val, sum; // Sum of left children numbers
		int duplicated = 1;
		
		private Node(int val, int sum) {
			this.val = val;
			this.sum = sum;
		}
	}
	
	/*------------------ Binary Index Tree Solution ------------------ */
	// BIT, Time O(NlogN), Space O(N)
    public List<Integer> countSmallerBIT(int[] nums) {
        Integer[] res = new Integer[nums.length];
        if (nums.length == 0) return new LinkedList<>();
        
        // Build Array with index for Binary Index Tree. O(NlogN)
        TreeSet<Integer> distinctiveNumbers = new TreeSet<>();
        for(int i = 0; i < nums.length; i++) {
        	distinctiveNumbers.add(nums[i]);
        }
        
        HashMap<Integer, Integer> numberIndexMap = new HashMap<Integer, Integer>();
        int index = 1; // BIT index go from 1
        while(!distinctiveNumbers.isEmpty()) {
        	numberIndexMap.put(distinctiveNumbers.pollFirst(), index++);
        }
        
        // Count for smaller numbers with BIT. O(NlogN)
        int[] BIT = new int[index];
        for(int i = nums.length - 1; i >= 0; i--) {
        	int idx = numberIndexMap.get(nums[i]);
        	
        	// Find the count of smaller number
        	res[i] = sumAtIndex(BIT, idx - 1);
        	
        	// Increase frequency of current number
        	updateBIT(BIT, 1, idx);
        }
        
        return Arrays.asList(res);
    }
    
    // O(logN)
    private void updateBIT(int[] BIT, int val, int idx) {
    	while(idx < BIT.length) {
    		BIT[idx] += val;
    		idx += (idx & -idx);
    	}
    }
    
    // O(logN)
    private int sumAtIndex(int[] BIT, int idx) {
    	int sum = 0;
    	while(idx > 0) {
    		sum += BIT[idx];
    		idx -= (idx & -idx);
    	}
    	
    	return sum;
    }
}
