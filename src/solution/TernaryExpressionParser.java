package solution;

import java.util.*;

public class TernaryExpressionParser {
	public String parseTernary(String expression) {
        if (expression == null || expression.isEmpty())
        	return "";
        Stack<Character> st = new Stack<>();
        
        for (int i = expression.length() - 1; i >= 0; i--) {
        	char cur = expression.charAt(i);
        	if (cur == ':')
        		continue;
        	if (cur == '?') {
        		char ch1 = st.pop();
        		char ch2 = st.pop();
        		st.push((expression.charAt(--i) == 'T') ? ch1 : ch2);
        	} else {
        		st.push(cur);
        	}
        }
        
        return String.valueOf(st.pop());
    }
}
