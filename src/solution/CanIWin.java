package solution;

import java.util.HashMap;
import java.util.Map;

/* Can I Win - Medium */
public class CanIWin {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
    	int sum = (1 + maxChoosableInteger) * maxChoosableInteger / 2;
    	if (sum < desiredTotal) return false;
        if (maxChoosableInteger >= desiredTotal) return true;
        Integer used = 0;
        Map<Integer, Boolean> states = new HashMap<>();
        
        return helper(used, states, maxChoosableInteger, desiredTotal);
    }
    
    private Boolean helper(Integer used, Map<Integer, Boolean> states, 
    		int maxChoosableInteger, int desiredTotal) {
    	if (desiredTotal <= 0) return false;
    	if (states.containsKey(used)) return states.get(used);
    	boolean canWin = false;
    	
    	for(int i = 1; i <= maxChoosableInteger; i++) {
    		int mask = (1 << i);
    		if ((used & mask) != 0) continue; // Cannot used repeated number
    		
    		used |= mask;
    		if (!helper(used, states, maxChoosableInteger, desiredTotal - i)) {
    			canWin = true;
    			used &= ~mask;
    			break;
    		}
    		
    		used &= ~mask;
    	}
    	
    	states.put(used, canWin);
    	return canWin;
    }
}
