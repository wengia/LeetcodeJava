package solution;

import java.util.LinkedList;
import java.util.List;

public class CombinationSumIII {
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> res = new LinkedList<List<Integer>> ();
        if (k == 0) return res;
        
        combinationSum3_improve(k, n, 1, new LinkedList<Integer>(), res);
        return res;
    }
	
	private void combinationSum3(int k, int target, int pos,
			List<Integer> current, List<List<Integer>> res) {
		if (k == 0 && target == 0) {
			res.add(new LinkedList<Integer>(current));
			return;
		}
		if (k == 0) return;
		
		for (; pos < 10; pos++) {
			if (pos > target) return;
			current.add(pos);
			combinationSum3(k - 1, target - pos, pos + 1, current, res);
			current.remove(current.size() - 1);
		}
	}
	
	private void combinationSum3_improve(int k, int target, int pos,
			List<Integer> current, List<List<Integer>> res) {
		if (k < 1)
			return;
		if (k == 1) {
			if (target >= pos && target < 10) {
				current.add(target);
				res.add(new LinkedList<Integer>(current));
				current.remove(current.size() - 1);
			}
			return;
		}
		
		for (; pos < 10; pos++) {
			if (pos > target) return;
			current.add(pos);
			combinationSum3_improve(k - 1, target - pos, pos + 1, current, res);
			current.remove(current.size() - 1);
		}
	}
}
