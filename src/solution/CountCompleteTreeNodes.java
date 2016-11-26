package solution;

import java.util.*;

public class CountCompleteTreeNodes {
	public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int left = getHeight(root, true);
        int right = getHeight(root, false);
        if (left == right) return (1 << left) -1;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
	
	private int getHeight(TreeNode pos, boolean countLeft) {
		int h = 0;
		while(pos != null) {
			if (countLeft) pos = pos.left;
			else pos = pos.right;
			h++;
		}
		
		return h;
	}
	
}
