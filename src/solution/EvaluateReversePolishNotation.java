package solution;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
    	if (tokens == null || tokens.length == 0) return 0;
        Stack<Integer> numbers = new Stack<>();
        
        for(int i = 0; i < tokens.length; i++) {
        	String token = tokens[i];
        	try {
        		int num = Integer.parseInt(token);
        		numbers.push(num);
        	} catch(NumberFormatException ex) {
        		int num2 = numbers.pop();
        		int num1 = numbers.pop();
        		if ("+".equals(token))
        			numbers.push(num1 + num2);
        		else if ("-".equals(token))
        			numbers.push(num1 - num2);
        		else if ("*".equals(token))
        			numbers.push(num1 * num2);
        		else if ("/".equals(token))
        			numbers.push(num1 / num2);
        	}
        }
        
        return numbers.pop();
    }
}
