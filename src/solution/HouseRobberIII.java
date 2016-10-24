package solution;


public class HouseRobberIII {

	public int rob(TreeNode root) {
        if (root == null) return 0;
        Pair predictRob = robCheckChildren(root);
        
        return Math.max(predictRob.curMax, predictRob.withoutCurMax);
    }
	
	private Pair robCheckChildren(TreeNode root) {
		if (root == null) return new Pair(0, 0);
		if (root.left == null && root.right == null) return new Pair(root.val, 0);
		Pair checkLeft = robCheckChildren(root.left);
		Pair checkRight = robCheckChildren(root.right);
		
		int withCurrent = root.val + checkLeft.withoutCurMax + checkRight.withoutCurMax;
		int withoutCurrent = Math.max(checkLeft.curMax, checkLeft.withoutCurMax) +
							Math.max(checkRight.curMax, checkRight.withoutCurMax);
		
		return new Pair(withCurrent, withoutCurrent);
	}
	
	private class Pair {
		private int curMax, withoutCurMax;
		
		private Pair(int currentMax, int withoutCurMax) {
			this.withoutCurMax = withoutCurMax;
			this.curMax = currentMax;
		}
	}
}
