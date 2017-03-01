package solution;

import java.util.Stack;

/* Remove K Digits - Medium */
public class RemoveKDigits {
	// O(N + k) where n = num.length()
    public String removeKdigits(String num, int k) {
        Stack<Integer> minSt = new Stack<>();
        int len = num.length() - k;
        
        for(int i = 0; i < num.length(); i++) {
        	int cur = num.charAt(i) - '0';
        	int remain = num.length() - i;
        	
        	while(!minSt.isEmpty() && minSt.size() + remain > len && cur < minSt.peek())
        		minSt.pop();
        	
        	if (minSt.size() < len)
        		minSt.push(cur);
        }
        
        StringBuilder sb = new StringBuilder();
        while(!minSt.isEmpty()) {
        	sb.append(minSt.pop());
        }
        
        int cut = sb.length();
        while(cut > 0 && sb.charAt(cut - 1) == '0')
        	cut--;
        
        sb.setLength(cut);
        String res = (cut == 0) ? "0" : sb.reverse().toString();
        return res;
    }
}
