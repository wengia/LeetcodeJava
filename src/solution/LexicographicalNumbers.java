package solution;

import java.util.LinkedList;
import java.util.List;

/* Lexicographical Numbers - Medium */
public class LexicographicalNumbers {
	public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new LinkedList<>();
        
        int cur = 1;
        for(int i = 1; i <= n; i++) {
        	res.add(cur);
        	
        	// Generate next
        	if (cur * 10 <= n)
        		cur *= 10;
        	else if (cur % 10 != 9 && cur + 1 <= n)
        		cur++;
        	else { // Get next level
        		while((cur / 10) % 10 == 9) cur /= 10;
        		cur = cur / 10 + 1;
        	}
        }
        
        return res;
    }
	
	
	
	
	// Time O(N), Space O(log(10, n))
    public List<Integer> lexicalOrderFirstInMind(int n) {
        List<Integer> res = new LinkedList<>();
        
        for(int first = 1; first <= 9 && first <= n; first++) {
        	res.add(first);
        	lexicalOrder(n, first, res);
        }
        
        return res;
    }
    
    private void lexicalOrder(final int n, int first, List<Integer> res) {
    	if (first * 10 > n) return;
    	
    	// followed by 0
    	int cur = first;
    	while(cur * 10 <= n) {
    		cur *= 10;
    		res.add(cur);
    	}
    	
    	// count from 1 - 9
    	for(int i = 1; i <= 9 && i + cur <= n; i++) {
    		res.add(cur + i);
    	}
    	
    	// check cur = cur/10
    	cur /= 10;
    	while(cur > first) {
    		for(int i = 1; i <= 9 && i + cur <= n; i++) {
    			res.add(cur + i);
    			lexicalOrder(n, cur + i, res);
        	}
    		cur /= 10;
    	}
    }
}
