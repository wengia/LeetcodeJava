package solution;

import java.util.*;

/* Serialize and Deserialize BST - Medium */
public class SerializeandDeserializeBST {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
    	if (root == null) return "";
    	StringBuilder sb = new StringBuilder();
    	
    	// Pre-Order Tree
    	Stack<TreeNode> st = new Stack<>();
    	st.push(root);
    	
    	while(!st.isEmpty()) {
    		TreeNode current = st.pop();
    		sb.append(current.val).append(" ");
    		
    		if (current.right != null) st.push(current.right);
    		if (current.left != null) st.push(current.left);
    	}
        
    	return sb.toString().trim();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) return null;
        String[] tokens = data.split(" ");
        Queue<Integer> que = new LinkedList<>();
        for(int i = 0; i < tokens.length; i++) {
        	que.offer(Integer.parseInt(tokens[i]));
        }
        
        return buildTree(que);
    }
    
    private TreeNode buildTree(Queue<Integer> que) {
    	if (que.isEmpty()) return null;
    	TreeNode root = new TreeNode(que.poll());
    	Queue<Integer> leftChildren = new LinkedList<>();
    	while(!que.isEmpty() && que.peek() < root.val)
    		leftChildren.offer(que.poll());
    	
    	root.left = buildTree(leftChildren);
    	root.right = buildTree(que);
    	
    	return root;
    }
	
}
