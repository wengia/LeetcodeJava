package solution;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
	public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        if (n == 0) return res;
        
        StringBuilder current = new StringBuilder();
        generateParenthesis(n, n, current, res);
        
        return res;
    }
	
	private void generateParenthesis(int left, int right, StringBuilder cur, List<String> res) {
		if (left == 0 && right == 0) {
			res.add(cur.toString());
			return;
		}
		
		if (left == 0) {
			generateParenthesis(left, right - 1, cur.append(")"), res);
			cur.deleteCharAt(cur.length() - 1);
		}
		else if (left == right) {
			generateParenthesis(left - 1, right, cur.append("("), res);
			cur.deleteCharAt(cur.length() - 1);
		}
		else {
			generateParenthesis(left - 1, right, cur.append("("), res);
			cur.deleteCharAt(cur.length() - 1);
			generateParenthesis(left, right - 1, cur.append(")"), res);
			cur.deleteCharAt(cur.length() - 1);
		}
	}
}
