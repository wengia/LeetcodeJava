package solution;

import java.util.Stack;

/* Verify Preorder Serialization of a Binary Tree - Medium */
public class VerifyPreorderSerializationofaBinaryTree {
    public boolean isValidSerialization(String preorder) {
    	return isValidSerializationDegreeDiff(preorder);
    }
    
    /* Genius idea in Leetcode solution
     * 
     * all non-null node provides 2 outdegree and 1 indegree (2 children and 1 parent), except root
     * all null node provides 0 outdegree and 1 indegree (0 child and 1 parent).
     * 
     * */
    private boolean isValidSerializationDegreeDiff(String preorder) {
    	if (preorder == null || preorder.isEmpty()) return false;
    	String[] nodes = preorder.split(",");
    	int diff = 1;
    	
    	for(String node: nodes) {
    		if (--diff < 0) return false;
    		if (!"#".equals(node)) diff += 2;
    	}
    	
    	return diff == 0;
    }
    
    /* Stack */
    private boolean isValidSerializationStack(String preorder) {
    	if (preorder == null || preorder.isEmpty()) return false;
    	Stack<String> st = new Stack<>();
    	String[] nodes = preorder.split(",");
    	
    	for(String node: nodes) {
    		while("#".equals(node) && !st.isEmpty() && "#".equals(st.peek())) {
    			st.pop();
    			if (st.isEmpty()) return false;
    			st.pop();
    		}
    		st.push(node);
    	}
    	
    	return st.size() == 1 && "#".equals(st.peek());
    }
}
