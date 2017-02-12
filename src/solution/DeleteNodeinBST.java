package solution;

/* Delete Node in a BST - Medium */
public class DeleteNodeinBST {
	
	public TreeNode deleteNode(TreeNode root, int key) {
		TreeNode dummyHead = new TreeNode(-1);
		dummyHead.left = root;
        TreeNode parent = dummyHead, pos = root;
        
        // Find the target node
        while(pos != null && pos.val != key) {
        	parent = pos;
        	pos = (key < pos.val) ? pos.left : pos.right;
        }
        deleteNode(parent, pos);

		return dummyHead.left;
    }
	
	public void deleteNode(TreeNode parent, TreeNode target) {
		if (parent == null || target == null) return;
		
		TreeNode moveUp = (target.left != null) ? target.left : target.right;
		TreeNode moveDown = (target.left != null) ? target.right : target.left;
		
		// Remove target
		if (parent.left == target) parent.left = moveUp;
		else parent.right = moveUp;
		
		if (moveDown == null) return;
		
		// Add moveDown to moveUp's right tree. 
		// Because moveUp is the left tree of target. All nodes in moveUp < moveDown
		while(moveUp.right != null) moveUp = moveUp.right;
		moveUp.right = moveDown;
	}

}
