package solution;

public class ValidateBinarySearchTree {
	public boolean isValidBST(TreeNode root) {
        return isValidBSTRecursion(root);
    }
	
	private Integer previous = null;
	private boolean isValidBSTRecursion(TreeNode root) {
        if (root == null) return true;
        if (!isValidBSTRecursion(root.left))
        	return false;
        
        if (previous != null && root.val <= previous)
        	return false;
        previous = root.val;
        return isValidBSTRecursion(root.right);
    }
}
