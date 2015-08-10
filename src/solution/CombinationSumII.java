package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>> ();
        if (candidates.length == 0) return res;
        Arrays.sort(candidates);
        combinationSum(candidates, target, 0, new ArrayList<Integer>(), res);
        return res;
    }
	
	private void combinationSum(final int[] candidates, int target, int pos,
			List<Integer> current, List<List<Integer>> res) {
		if (target == 0) {
			res.add(new ArrayList<Integer>(current));
			return;
		}
		
		for (int i = pos; i < candidates.length; i++) {
			if (i > pos && candidates[i] == candidates[i - 1])
				continue;
			
			if (candidates[i] > target) return;
			current.add(candidates[i]);
			combinationSum(candidates, target - candidates[i], i + 1, current, res);
			current.remove(current.size() - 1);
		}
	}

}
