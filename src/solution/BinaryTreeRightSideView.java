package solution;

import java.util.*;

public class BinaryTreeRightSideView {
	// Time O(n), Space O(n)
	public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if(root == null) return res;
        Queue<NodeWithLevel> que = new LinkedList<>();
        que.add(new NodeWithLevel(root, 1));
        
        while (!que.isEmpty()) {
        	NodeWithLevel current = que.poll();
        	if (current.level > res.size())
        		res.add(current.node.val);
        	
        	if(current.node.right != null) que.add(new NodeWithLevel(current.node.right, current.level + 1));
        	if(current.node.left != null) que.add(new NodeWithLevel(current.node.left, current.level + 1));
        }
        
        return res;
    }
	
	private class NodeWithLevel {
		private TreeNode node;
		private int level;
		
		private NodeWithLevel(TreeNode node, int level) {
			this.node = node;
			this.level = level;
		}
	}
	
	// Solution 2 no extra space
	public List<Integer> rightSideViewII(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if(root == null) return res;
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        
        while (!que.isEmpty()) {
        	int size = que.size();
        	
        	for (int i = 0; i < size; i++) {
    			TreeNode current = que.poll();
    			if (i == 0)
    				res.add(current.val);
        	
    			if(current.right != null) que.add(current.right);
    			if(current.left != null) que.add(current.left);
        	}
        }
        
        return res;
    }
}
