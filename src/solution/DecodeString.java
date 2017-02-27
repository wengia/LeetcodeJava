package solution;

import java.util.LinkedList;
import java.util.Stack;

/* Decode String - Medium */
public class DecodeString {
	// Use stack Simple one
	public String decodeStringStack(String s) {
		String res = "";
		Stack<Integer> countSt = new Stack<>();
		Stack<String> resSt = new Stack<>();
		int i = 0;
		while(i < s.length()) {
			if (isNumberic(s.charAt(i))) {
				int count = 0;
				while (isNumberic(s.charAt(i))) {
					count = count * 10 + (s.charAt(i++) - '0');
				}
				
				countSt.push(count);
			} else if (s.charAt(i) == '[') {
				resSt.push(res);
				res = "";
				i++;
			} else if (s.charAt(i) == ']') {
				StringBuilder tmp = new StringBuilder(resSt.pop());
				int count = countSt.pop();
				while(count-- > 0) {
					tmp.append(res);
				}
				res = tmp.toString();
				i++;
			} else {
				res += s.charAt(i++);
			}
		}
		
		return res;
	}
	
	// Use stack first one
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        LinkedList<String> repeatCount = new LinkedList<>();
        
        for(int i = 0; i < s.length(); i++) {
        	char ch = s.charAt(i);
        	if (isNumberic(ch)) {
        		if (sb.length() > 0) {
        			repeatCount.add(sb.toString());
        			sb.setLength(0);
        		}
        		int openBracket = s.indexOf("[", i);
        		repeatCount.add(s.substring(i, openBracket)); // Count Number
        		i = openBracket;
        	} else if (ch == ']') {
        		// Gain Repeat
        		while(!repeatCount.isEmpty() && getCount(repeatCount.getLast()) == -1) {
        			sb.insert(0, repeatCount.pollLast());
        		}
        		
        		int count = Integer.parseInt(repeatCount.pollLast());
        		String cur = sb.toString();
        		while(--count > 0) {
        			sb.append(cur);
        		}
        		
        		repeatCount.add(sb.toString());
        		sb.setLength(0);
        	} else {
        		sb.append(ch);
        	}
        }
        
        // Construct the res
        String end = sb.toString();
        sb.setLength(0);
        while(!repeatCount.isEmpty())
        	sb.append(repeatCount.poll());
        
        return sb.append(end).toString();
    }
    
    private boolean isNumberic(char ch) {
    	return ('0' <= ch && ch <= '9');
    }
    
    private int getCount(String s) {
    	try {
    		int count = Integer.parseInt(s);
    		return count;
    	} catch(NumberFormatException ex) {
    		return -1;
    	}
    }
}
