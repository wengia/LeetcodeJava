package solution;

import java.util.*;

/* Find K Pairs with Smallest Sums - Medium */
public class FindKPairswithSmallestSums {
	// O(KlogK)
	public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		List<int[]> res = new LinkedList<>();
		if (nums1.length == 0 || nums2.length == 0 || k == 0) return res;
		PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> (a[0] + a[1] - b[0] - b[1]));
		
		for(int i = 0; i < nums1.length && i < k; i++) {
			heap.add(new int[]{nums1[i], nums2[0], 0});
		}
		
		while(k-- > 0 && !heap.isEmpty()) {
			int[] cur = heap.poll();
			res.add(new int[]{cur[0], cur[1]});
			if (cur[2] == nums2.length - 1) continue;
			heap.add(new int[]{cur[0], nums2[cur[2] + 1], cur[2] + 1});
		}
		
		return res;
	}
	
	// Brute-Force, O(N*logN) where N = Math.min(m * n, K ^ 2)
    public List<int[]> kSmallestPairsBF(int[] nums1, int[] nums2, int k) {
    	List<int[]> res = new LinkedList<>();
        if (nums1.length == 0 || nums2.length == 0) return res;
        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return (o1[0] + o1[1]) - (o2[0] + o2[1]);
			}
        	
        });
        
        for(int i = 0; i < nums1.length && i < k; i++) {
        	for(int j = 0; j < nums2.length && j < k; j++) {
        		heap.add(new int[]{nums1[i], nums2[j]});
        	}
        }
        
        while(k-- > 0 && !heap.isEmpty()) {
        	res.add(heap.poll());
        }
        
        return res;
    }
}
