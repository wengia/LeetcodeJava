package solution;

/* Minimum Moves to Equal Array Elements - Easy */
public class MinimumMovestoEqualArrayElements {
    public int minMoves(int[] nums) {
        int res = 0, minNum = Integer.MAX_VALUE;
        for(int num: nums) {
        	minNum = Math.min(minNum, num);
        }
        for(int num: nums) {
        	res += (num - minNum);
        }
        
        return res;
    }
}
