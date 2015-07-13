package solution;

import java.util.Stack;

public class BinarySearchTreeIterator {
	private Stack<TreeNode> st = new Stack<TreeNode>();
	
    public BinarySearchTreeIterator(TreeNode root) {
        TreeNode leftNode = root;
        while (leftNode != null) {
        	st.push(leftNode);
        	leftNode = leftNode.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !st.empty();
    }

    /** @return the next smallest number */
    public int next() {
    	TreeNode cur = st.pop();
    	
    	TreeNode rightTreeLeftChild = cur.right;
    	while (rightTreeLeftChild != null) {
    		st.push(rightTreeLeftChild);
    		rightTreeLeftChild = rightTreeLeftChild.left;
    	}
    	
    	return cur.val;
    }

}
