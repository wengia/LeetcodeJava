package solution;

import java.util.LinkedList;
import java.util.List;

/* Fizz Buzz - Easy */
public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> res = new LinkedList<>();
        
        for(int i = 1; i <= n; i++) {
        	String cur = "";
        	if (i % 3 == 0) cur += "Fizz";
        	if (i % 5 == 0) cur += "Buzz";
        	if (cur.isEmpty()) cur += i;
        	res.add(cur);
        }
        
        return res;
    }
}
