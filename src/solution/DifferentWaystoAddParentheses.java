package solution;

import java.util.*;

public class DifferentWaystoAddParentheses {
	public List<Integer> diffWaysToCompute(String input) {
    	List<Integer> res = new LinkedList<>();
        int len = input.length();
        for(int i = 0; i < len; i++) {
        	char ch = input.charAt(i);
        	if (ch == '+' || ch == '-' || ch == '*') {
        		List<Integer> part1 = diffWaysToCompute(input.substring(0, i));
                List<Integer> part2 = diffWaysToCompute(input.substring(i + 1, len));
                for(int num1 : part1) {
                	for(int num2 : part2) {
                		int num = calculateNumber(num1, num2, ch);
                		res.add(num);
                	}
                }
        	}
        }
        
        if (res.isEmpty())
        	res.add(Integer.parseInt(input));
        
        return res;
    }
	
	private int calculateNumber(int num1, int num2, char op) {
		if (op == '+') return num1 + num2;
		else if (op == '-') return num1 - num2;
		else return num1 * num2;
	}
	
	// Take advantage of already calculated value
	private Map<String, List<Integer>> visited = new HashMap<>();
	public List<Integer> diffWaysToComputeImprove(String input) {
    	List<Integer> res = new LinkedList<>();
        int len = input.length();
        for(int i = 0; i < len; i++) {
        	char ch = input.charAt(i);
        	if (ch == '+' || ch == '-' || ch == '*') {
        		List<Integer> part1, part2;
        		
        		String before = input.substring(0, i);
        		if (visited.containsKey(before))
        			part1 = visited.get(before);
        		else {
        			part1 = diffWaysToComputeImprove(before);
        			visited.put(before, part1);
        		}
        		
        		String after = input.substring(i + 1);
        		if (visited.containsKey(after))
        			part2 = visited.get(after);
        		else {
        			part2 = diffWaysToComputeImprove(after);
        			visited.put(after, part2);
        		}
        		
        		for(int num1 : part1) {
                	for(int num2 : part2) {
                		int num = calculateNumber(num1, num2, ch);
                		res.add(num);
                	}
                }
        	}
        }
        
        if (res.isEmpty())
        	res.add(Integer.parseInt(input));
        
        return res;
    }
}
