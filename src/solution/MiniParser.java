package solution;

import java.util.Stack;

/* Mini Parser - Medium */
public class MiniParser {
	// Time O(N), Space O(N)
	public NestedInteger deserialize(String s) {
		Stack<NestedInteger> st = new Stack<>();
		int number = 0, sign = 1;
		boolean numberInProcess = false;
		
		// Only one number. Like "-100"
		if (s.charAt(0) != '[') {
			return new NestedInteger(Integer.parseInt(s));
		}
		
		// Parse "[xxxxxxx]"
		for(int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == '[') {
				st.push(new NestedInteger());
				numberInProcess = false;
			} else if (ch == ']') {
				if(numberInProcess) { // number before ']'
					st.peek().add(new NestedInteger(sign * number));
					number = 0;
					sign = 1;
				}
				
				if (st.size() > 1 ) { // Add to prev level if have
					NestedInteger current = st.pop();
					st.peek().add(current);
				}
				numberInProcess = false;
			} else if (ch == ',') {
			    if (numberInProcess)
				    st.peek().add(new NestedInteger(sign * number));
				number = 0;
				sign = 1;
				numberInProcess = false;
			} else if (ch == '-') {
				sign = -1;
			} else {
				numberInProcess = true;
				number = number * 10 + (ch - '0');
			}
		}
		
		return st.pop();
    }
}
