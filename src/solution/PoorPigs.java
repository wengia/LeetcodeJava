package solution;

/* Poor Pigs - Easy although I think it is medium */
public class PoorPigs {
	/* Credits to ifyouseewendy
	 * https://discuss.leetcode.com/topic/67482/solution-with-detailed-explanation
	 * 
	 * */
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int r = minutesToTest / minutesToDie;
        double pigs = Math.log(buckets) / Math.log(r);
        int res = (int)Math.ceil(pigs);
        
        return res;
    }
}
