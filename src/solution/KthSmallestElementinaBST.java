package solution;

public class KthSmallestElementinaBST {
	private int count = 0;
	private int res = 0;
	
	public int kthSmallest(TreeNode root, int k) {
		kthSmallestRecursion(root, k);
		
		return res;
    }
	
	private void kthSmallestRecursion(TreeNode root, final int k) {
		if (root == null || count >= k) return;
		
		kthSmallestRecursion(root.left, k);
		if (++count == k)
			res = root.val;
		kthSmallestRecursion(root.right, k);
	}
}
