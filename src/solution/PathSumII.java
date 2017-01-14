package solution;

import java.util.*;

public class PathSumII {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        pathSum(root, sum, new LinkedList<Integer>(), res);
        return res;
    }
	
	private void pathSum(TreeNode root, int sum, 
			LinkedList<Integer> current, List<List<Integer>> res) {
		if (root == null) return;
		if (root.left == null && root.right == null) {
			if (sum == root.val) {
				current.add(root.val);
				res.add(new LinkedList<Integer>(current));
				current.removeLast();
			}
			return;
		}
		
		current.add(root.val);
		pathSum(root.left, sum - root.val, current, res);
		pathSum(root.right, sum - root.val, current, res);
		current.removeLast();
	}
}
