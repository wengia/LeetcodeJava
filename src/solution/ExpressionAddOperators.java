package solution;

import java.util.*;

public class ExpressionAddOperators {
    public List<String> addOperators(String num, int target) {
        List<String> res = new LinkedList<>();
        // change String to char set in recording numbers and path, 
        // saving time in String Buffer
        char numbers[] = num.toCharArray();
        char path[] = new char[numbers.length * 2];
        
        long first = 0;
        for(int i = 0; i < numbers.length; i++) {
        	first = first * 10 + numbers[i] - '0';
        	path[i] = numbers[i];
        	dfs(res, path, numbers, target, 0, first, i + 1, i + 1);
        	if (first == 0) break; // number starts with 0 like 00 is not allowed
        }
        
        return res;
    }
    
    private void dfs(List<String> res, char[] path, final char[] numbers, final int target, 
    		long left, long cur, int pos, int len) {
    	if (pos == numbers.length) {
    		if (left + cur == target) {
    			res.add(new String(path, 0, len));
    		}
    		return;
    	}

    	long n = 0;
		for(int i = pos, j = len + 1; i < numbers.length; i++) {
			n = n * 10 + numbers[i] - '0';
			path[j++] = numbers[i];
			path[len] = '+';
			dfs(res, path, numbers, target, left + cur, n, i + 1, j);
			path[len] = '-';
			dfs(res, path, numbers, target, left + cur, -n, i + 1, j);
			path[len] = '*';
			dfs(res, path, numbers, target, left, cur * n, i + 1, j);
			if (n == 0) break; // number starts with 0 like 00 is not allowed
		}
    }
}
