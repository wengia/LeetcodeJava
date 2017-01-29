package solution;

/* Range Sum Query - Mutable - Medium 
 * 
 * Check class RangeSumQueryMutable for binary index tree method
 * 
 * */
public class NumArray {
	private SegmentTreeNode root = null;

    public NumArray(int[] nums) {
    	root = buildTree(nums, 0, nums.length - 1);
    }
    
    public void update(int i, int val) {
    	updateTree(root, i, val);
    }
    
    public int sumRange(int i, int j) {
    	return sumRangeTree(i, j, root);
    }
    
    private class SegmentTreeNode {
    	private int sum;
    	private SegmentTreeNode left, right;
    	private int start, end; // [start, end]
    	
    	SegmentTreeNode(int val, int start, int end, 
    			SegmentTreeNode left, SegmentTreeNode right) {
    		this.sum = val;
    		this.start = start;
    		this.end = end;
    		this.left = left;
    		this.right = right;
    	}
    }
    
    private SegmentTreeNode buildTree(int[] num, int start, int end) {
    	if (start > end) return null;
    	if (start == end) {
    		return new SegmentTreeNode(num[start], start, end, null, null);
    	}
    	
    	int mid = start + (end - start) / 2;
    	SegmentTreeNode leftNode = buildTree(num, start, mid);
    	SegmentTreeNode rightNode = buildTree(num, mid + 1, end);
    	
    	return new SegmentTreeNode(leftNode.sum + rightNode.sum, start, end, leftNode, rightNode);
    }
    
    private void updateTree(SegmentTreeNode node, final int pos, final int val) {
    	if (node == null) return;
    	if (pos == node.start && pos == node.end) {
    		node.sum = val;
    		return;
    	}
    	
    	int mid = node.start + (node.end - node.start) / 2;
    	if (pos <= mid)
    		updateTree(node.left, pos, val);
    	else if (pos > mid)
    		updateTree(node.right, pos, val);
    	
    	node.sum = node.left.sum + node.right.sum;
    }
    
    private int sumRangeTree(int start, int end, SegmentTreeNode node) {
    	if (node == null) return 0;
    	if (node.start == start && node.end == end)
    		return node.sum;
    	
    	int mid = node.start + (node.end - node.start) / 2;
    	if (end <= mid)
    		return sumRangeTree(start, end, node.left);
    	else if (start > mid)
    		return sumRangeTree(start, end, node.right);
    	
    	return sumRangeTree(start, mid, node.left) + sumRangeTree(mid + 1, end, node.right);
    }
}
