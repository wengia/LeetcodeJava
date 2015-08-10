package solution;

import java.util.LinkedList;
import java.util.List;

public class Combinations {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res = new LinkedList<List<Integer>> ();
        if (k == 0) return res;
        
        combine(n, k, 1, new LinkedList<Integer>(), res);
        return res;
    }
	
	public void combine(final int n, int k, int pos, List<Integer> cur, List<List<Integer>> res) {
		if (k == 0) {
			res.add(new LinkedList<Integer>(cur));
			return;
		}
			
		for (; pos <= n; pos++) {
			cur.add(pos);
			combine(n, k - 1, pos + 1, cur, res);
			cur.remove(cur.size() - 1);
		}
	}
}
