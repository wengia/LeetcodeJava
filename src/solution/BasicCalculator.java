package solution;

import java.util.Stack;

public class BasicCalculator {
	public int calculate(String s) {
		Stack<Character> operator = new Stack<>();
        Stack<Integer> numbers = new Stack<>();
		
        StringBuilder sb = new StringBuilder();
		for(int i = s.length() - 1; i >= 0; i--) {
			char cur = s.charAt(i);
			if (cur == ' ') continue;
			
			if (isNumber(cur)) {
				sb.insert(0, cur - '0');
			} else {
				if (sb.length() > 0) {
					numbers.push(Integer.parseInt(sb.toString()));
					sb = new StringBuilder();
				}
				
				if (cur == '(') {
					while(!operator.isEmpty() && operator.peek() != ')') {
						int num1 = numbers.pop();
						int num2 = numbers.pop();
						int num = calculate(num1, num2, operator.pop());
						numbers.push(num);
					}
					operator.pop();
				} else
					operator.push(cur);
			}
		}
		
		if (sb.length() > 0) numbers.push(Integer.parseInt(sb.toString()));
		while (!operator.isEmpty()) {
			int num1 = numbers.pop();
			int num2 = numbers.pop();
			int num = calculate(num1, num2, operator.pop());
			numbers.push(num);
		}
		
		return numbers.isEmpty() ? 0 : numbers.pop();
    }
	
	private boolean isNumber(char ch) {
		return '0' <= ch && ch <= '9';
	}
	
	private int calculate(int num1, int num2, char ch) {
		if (ch == '-') return num1 - num2;
		return num1 + num2;
	}
}
