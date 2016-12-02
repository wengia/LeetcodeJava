package solution;

import java.util.Stack;

public class BasicCalculatorII {
	public int calculate(String s) {
		int res = 0, num = 0;
		char operator = '+';
		Stack<Integer> numbers = new Stack<>();
		
		for(int i = 0; i < s.length(); i++) {
			char cur = s.charAt(i);
			
			if (isNumber(cur)) {
				num = num * 10 + (cur - '0');
			}
			
			if (cur != ' ' && isNumber(cur) || i == s.length() - 1) {
				if (operator == '+') numbers.push(num);
				else if (operator == '-') numbers.push(-num);
				else {
					int tmp = (operator == '*') ? numbers.pop() * num : numbers.pop() / num;
					numbers.push(tmp);
				}
				operator = cur;
				num = 0;
			}
		}
		
		while(!numbers.isEmpty())
			res += numbers.pop();
		
		return res;
	}
	
	private boolean isNumber(char ch) {
		return '0' <= ch && ch <= '9';
	}
}
