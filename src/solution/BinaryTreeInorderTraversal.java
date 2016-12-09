package solution;

import java.util.*;

public class BinaryTreeInorderTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        inorderTraversalRecursion(root, res);
        return res;
    }
	
	protected void inorderTraversalRecursion(TreeNode root, List<Integer> res) {
		if (root == null) return;
		inorderTraversalRecursion(root.left, res);
		res.add(root.val);
		inorderTraversalRecursion(root.right, res);
	}
	
	protected List<Integer> inorderTraversalStackNoExtra(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> st = new Stack<>();
        
        while(root != null || !st.isEmpty()) {
        	while(root != null) {
        		st.push(root);
        		root = root.left;
        	}
        	
        	root = st.pop();
        	res.add(root.val);
        	root = root.right;
        }
        
        return res;
    }
	
	protected List<Integer> inorderTraversalStack(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Stack<TreeNodeCount> st = new Stack<>();
        if (root != null)
        	st.push(new TreeNodeCount(root));
        while(!st.isEmpty()) {
        	TreeNodeCount current = st.pop();
        	if (current.count == 0) {
        		current.count++;
        		st.push(current);
        		if (current.node.left != null)
        			st.push(new TreeNodeCount(current.node.left));
        	} else {
        		res.add(current.node.val);
        		if (current.node.right != null)
        			st.push(new TreeNodeCount(current.node.right));
        	}
        }
        
        return res;
    }
	
	private class TreeNodeCount {
		private TreeNode node;
		private int count;
		
		private TreeNodeCount(TreeNode node) {
			this.node = node;
			this.count = 0;
		}
	}
}
