package solution;

import java.util.*;

/* Serialize and Deserialize Binary Tree - Hard */
public class SerializeandDeserializeBinaryTree {
	
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
    	if (root == null) return "";
    	StringBuilder sb = new StringBuilder();
    	
    	// Level Order Tree
    	Queue<TreeNode> que = new LinkedList<>();
    	que.add(root);
    	while(!que.isEmpty()) {
    		TreeNode current = que.poll();
    		if (current == null) {
    			sb.append("null ");
    			continue;
    		}
    		
    		sb.append(current.val).append(' ');
    		que.add(current.left);
    		que.add(current.right);
    	}
        
    	return sb.toString().trim();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) return null;
        TreeNode dummyHead = new TreeNode(-1);
        String[] numbers = data.split(" ");
        Queue<TreeNode> que = new LinkedList<>();
        
        Integer rootVal = Integer.parseInt(numbers[0]);
        dummyHead.left = new TreeNode(rootVal);
        que.add(dummyHead.left);
        
        for(int i = 1; i < numbers.length; i += 2) {
        	TreeNode current = que.poll();
        	current.left = stringToTeeNode(numbers[i]);
        	if (current.left != null) que.add(current.left);
        	
        	if (i + 1 < numbers.length) {
        		current.right = stringToTeeNode(numbers[i + 1]);
        		if (current.right != null) que.add(current.right);
        	}
        }
        
        return dummyHead.left;
        
    }
    
    private TreeNode stringToTeeNode(String s) {
    	if (s == null || s.isEmpty() || "null".equals(s))
    		return null;
    	
    	return new TreeNode(Integer.parseInt(s));
    }
}
