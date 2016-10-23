package solution;

public class PathSumIII {
	public int pathSum(TreeNode root, int sum) {
		if (root == null)
			return 0;
		
        return pathSumWithParent(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
	
	private int pathSumWithParent(TreeNode root, int sum) {
		if (root == null)
			return 0;
		
		int res = 0;
		if (root.val == sum)
			res += 1;
		
		res += pathSumWithParent(root.left, sum - root.val); // With current node
		res += pathSumWithParent(root.right, sum - root.val); // With current node
		
        return res;
	}
}
