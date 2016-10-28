package solution;

import java.util.*;

public class HappyNumber {
	public boolean isHappy(int n) {
		Set<Integer> repeats = new HashSet<>();
		int current = n;
		
		while(current != 1) {
			if(repeats.contains(current))
				return false;
			repeats.add(current);
			// Get next number
			int next = 0;
			while(current > 0) {
				int tmp = current % 10;
				next += tmp * tmp;
				current /= 10;
			}
			current = next;
		}
		
        return true;
    }
}
