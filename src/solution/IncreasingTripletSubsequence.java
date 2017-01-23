package solution;

/* Increasing Triplet Subsequence - Medium */
public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
    	int count = 0;
    	int triplet[] = new int[3];
    	
    	for(int num: nums) {
    		if (count == 0 || num > triplet[count - 1]) 
    			triplet[count++] = num;
    		else if (num > triplet[0])
    			triplet[1] = num;
    		else
    			triplet[0] = num;
    		
    		if (count == 3) return true;
    	}
    	
        return false;
    }
}
