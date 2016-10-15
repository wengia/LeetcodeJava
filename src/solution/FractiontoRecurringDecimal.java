package solution;

import java.util.*;

public class FractiontoRecurringDecimal {
	public String fractionToDecimal(int numerator, int denominator) {
		String res = ((double) numerator / denominator < 0) ? "-" : "";
		long numerator_cp = Math.abs((long)numerator);
		long denominator_cp = Math.abs((long)denominator);
		
		Map<Long, Integer> repeats= new HashMap<>();
		List<Long> remainders = new LinkedList<>();
		long current = numerator_cp / denominator_cp;
		long remainder = numerator_cp % denominator_cp;
		
		if (remainder == 0) {
			res += String.valueOf(current);
			return res;
		} else {
			res = current + ".";
			repeats.put(remainder, 0);
		}
		
		while (true) {
			remainder *= 10;
			current = remainder / denominator_cp;
			remainder = remainder % denominator_cp;
			
			remainders.add(current);
			if (remainder == 0) {
				res += listToString(remainders);
				break;
			}
			else if (repeats.containsKey(remainder)) {
				int idx = repeats.get(remainder);
				res += (listToString(remainders.subList(0, idx)) + "(" + 
						listToString(remainders.subList(idx, remainders.size())) + ")");
				break;
			}
			else {
				repeats.put(remainder, remainders.size());
			}
		}
		
        return res;
    }
	
	private String listToString(List<Long> list) {
		StringBuilder sb = new StringBuilder();
		for (long num : list)
			sb.append(num);
		
		return sb.toString();
	}
}
