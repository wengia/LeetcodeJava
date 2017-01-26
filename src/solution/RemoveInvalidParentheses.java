package solution;

import java.util.*;

/* Remove Invalid Parentheses - Hard
 * 
 * Special thanks to dietpepsi, who gave the genius DFS solution
 * http://52.20.106.37/remove-invalid-parentheses/
 * */
public class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
    	List<String> res = new LinkedList<>();
    	removeExtra(s, res, 0, 0, new char[] {'(', ')'});
    	return res;
    }
    
    // DFS
    // Use s from left to right to remove invalid ')'
    // Then use s in reverse order to remove invalid '('
    public void removeExtra(String s, List<String> res, int last_i, int last_j, char[] checkP) {
    	// Find the first invalid right part. either extra ')' or '(' in reverse order
    	int stack = 0, i = last_i;
    	for(; i < s.length(); i++) {
    		if (s.charAt(i) == checkP[0]) stack++;
    		else if (s.charAt(i) == checkP[1]) stack--;
    		if (stack < 0) break;
    	}
    	
    	// One by one remove all possible ')', 
    	// which is either the head ')' or first ')' after '(' or character
    	if (stack < 0) {
    		for(int j = last_j; j <= i; j++) {
    			if (s.charAt(j) == checkP[1] && (j == last_j || s.charAt(j - 1) != checkP[1])) {
    				String candidate = s.substring(0, j) + s.substring(j + 1, s.length());
    				removeExtra(candidate, res, i, j, checkP);
    			}
    		}
    		
    		return; // Not valid Parenthese
    	}
    	
    	// No extra right part, like ')'. Now check for extra left part, like '('
    	String reverseS = new StringBuilder(s).reverse().toString();
    	if (checkP[0] == '(')
    		removeExtra(reverseS, res, 0, 0, new char[] {')', '('});
    	else
    		res.add(reverseS);
    }
}
