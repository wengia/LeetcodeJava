package solution;

import java.util.*;

public class BinaryTreePaths {
	public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new LinkedList<>();
        if (root == null) return res;
        
        String s = String.valueOf(root.val);
        if (root.left == null && root.right == null) {
        	res.add(s);
        	return res;
        }
        
        List<String> listL = binaryTreePaths(root.left);
        List<String> listR = binaryTreePaths(root.right);
        for(String l : listL)
        	res.add(s + "->" + l);
        for(String r : listR)
        	res.add(s + "->" + r);
        return res;
    }
}
