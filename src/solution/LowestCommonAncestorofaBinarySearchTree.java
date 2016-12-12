package solution;

public class LowestCommonAncestorofaBinarySearchTree {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode largeVal = (p.val > q.val) ? p :q;
        TreeNode smallVal = (p.val > q.val) ? q :p;
        
        if (smallVal.val <= root.val && root.val <= largeVal.val) {
        	return root;
        } else if (largeVal.val < root.val) {
        	return lowestCommonAncestor(root.left, p, q);
        } else {
        	return lowestCommonAncestor(root.right, p, q);
        }
    }
}
