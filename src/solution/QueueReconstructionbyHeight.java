package solution;

import java.util.*;

/* Queue Reconstruction by Height - Medium */
public class QueueReconstructionbyHeight {
	/* Time O(NlogN), Space(O(N))
	 * 
	 * Desc: Each person is described by a pair of integers (h, k), 
	 * where h is the height of the person and k is the number of people 
	 * in front of this person who have a height greater than or equal to h.
	 * 
	 * Greedy in following methods:
	 * 1. Find tallest members in people and place them by k in result
	 * 2. Repeat first step until all people are placed.
	 * */
    public int[][] reconstructQueue(int[][] people) {
    	Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0])
                	return o2[0] - o1[0]; // Sorted by highest height first
                return o1[1] - o2[1]; // Sorted by smaller front members
            }
        });
    	
    	List<int[]> newQue = new ArrayList<>(people.length);
    	for(int[] eachperson: people) {
    		newQue.add(eachperson[1], eachperson);
    	}
    	
    	int[][] res = new int[people.length][];
    	for(int i = 0; i < people.length; i++)
    		res[i] = newQue.get(i);
    	
    	return res;
    }
}
