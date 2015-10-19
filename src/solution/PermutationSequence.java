package solution;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * The math to solve the question.
 * 
 * For n = 4, k = 17. 
 * 1. Consider what should be the first number?
 * The permutation of (n-1)! = 3! = 6. If 1 is the first num, we have 6 different way for the following.
 * Thus use upper round to find the beginning: m = k mod (n - 1)! + 1 = 17 mod 6 + 1 = 2 + 1 = 3.
 * 2. Then to find the second number, we should find the k1 = k % (n - 1)! = 17 - 2 * 6 = 5 
 * permutation sequence of the remaining number, where the n1 = n - 1.
 * 
 * @author wenjiama
 *
 */
public class PermutationSequence {
	public String getPermutation(int n, int k) {
		StringBuilder res = new StringBuilder();
		int total = factorial(n);
		ArrayList<Integer> seq = new ArrayList<>();
		
		for (int i = 1; i <= n; i++)
			seq.add(i);
		
		// Find k as idx. 
		k--;
		
		// Construct the sequence
		for (int i = n; i > 0; i--) {
			total /= i;
			int m = k / total;
			res.append(seq.get(m));
			
			seq.remove(m);
			k %= total;
		}
		
        return res.toString();
    }
	
	private int factorial(int n) {
		int res = 1;
		for (int i = 2; i <= n; i++)
			res *= i;
		
		return res;
	}
}
