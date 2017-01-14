package solution;

import java.util.*;

public class UniqueBinarySearchTreesII {
	public List<TreeNode> generateTrees(int n) {
		if (n == 0) return new LinkedList<TreeNode>();
		return generateTreesSimple(1, n);
    }
	
	private List<TreeNode> generateTreesSimple(int start, int end) {
		List<TreeNode> res = new LinkedList<TreeNode>();
		if (start > end) {
			res.add(null);
			return res;
		}
		if (start == end) {
			res.add(new TreeNode(start));
			return res;
		}
		
		for(int i = start; i <= end; i++) {
			List<TreeNode> listL = generateTreesSimple(start, i - 1);
			List<TreeNode> listR = generateTreesSimple(i + 1, end);
			for(TreeNode nodeL : listL) {
				for(TreeNode nodeR : listR) {
					if (nodeL == null && listR == null)
						continue;
					TreeNode root = new TreeNode(i);
					root.left = nodeL;
					root.right = nodeR;
					res.add(root);
				}
			}
		}
		
		return res;
	}
	
	// Use DP
	private List<TreeNode> generateTreesDP(int n) {
		List<TreeNode>[] res = new List[n + 1];
		res[0] = new LinkedList<>();
		res[0].add(null);
		
		for(int len = 1; len < n; len++) {
			res[len] = new LinkedList<>();
			for(int num = 0; num < len; num++) {
				List<TreeNode> listL = res[num];
				List<TreeNode> listR = res[len - num - 1];
				for(TreeNode nodeL : listL) {
					for(TreeNode nodeR : listR) {
						TreeNode root = new TreeNode(num + 1);
						root.left = nodeL;
						root.right = cloneTree(nodeR, num + 1);
						res[len].add(root);
					}
				}
			}
		}
		
		return res[n];
	}
	
	private TreeNode cloneTree(TreeNode node, int offset) {
		if (node == null) return null;
		TreeNode root = new TreeNode(node.val + offset);
		root.left = cloneTree(node.left, offset);
		root.right = cloneTree(node.right, offset);
		return root;
	}
}
