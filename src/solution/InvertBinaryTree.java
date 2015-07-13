package solution;

public class InvertBinaryTree {
	public TreeNode invertTree(TreeNode root) {
        invertTreeHelper(root);
        
        return root;
    }
    
    private void invertTreeHelper(TreeNode cur) {
        if (cur == null) return;
        
        invertTree(cur.left);
        invertTree(cur.right);
        
        TreeNode left = cur.left;
        cur.left = cur.right;
        cur.right = left;
    }

}
