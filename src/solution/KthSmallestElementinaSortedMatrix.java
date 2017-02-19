package solution;

import java.util.PriorityQueue;

/* Kth Smallest Element in a Sorted Matrix - Medium */
public class KthSmallestElementinaSortedMatrix {
	// Time O(KlogK), Space O(K)
	public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        int n = matrix.length;
        
        for(int i = 0; i < n && i < k; i++)
            heap.add(new int[]{matrix[i][0], i, 0});
        
        while(--k > 0) {
        	int[] cur = heap.poll();
        	int i = cur[1], j = cur[2];
        	
        	if (j + 1 < n) {
        		heap.add(new int[]{matrix[i][j + 1], i, j + 1});
        	}
        }
        
        return heap.peek()[0];
    }
	
	/* The matrix[i][j] >= i * j members.
	 * Time O(KlogK), Space O(N^2)
	 * 
	 * */
    public int kthSmallestFirst(int[][] matrix, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        int n = matrix.length;
        boolean[][] visited = new boolean[n][n];
        
        heap.add(new int[]{matrix[0][0], 0, 0});
        visited[0][0] = true;
        while(--k > 0) {
        	int[] cur = heap.poll();
        	int i = cur[1], j = cur[2];
        	
        	if (i + 1 < n && !visited[i + 1][j]) {
        		visited[i + 1][j] = true;
        		heap.add(new int[]{matrix[i + 1][j], i + 1, j});
        	}
        	if (j + 1 < n && !visited[i][j + 1]) {
        		visited[i][j + 1] = true;
        		heap.add(new int[]{matrix[i][j + 1], i, j + 1});
        	}
        }
        
        return heap.peek()[0];
    }
}
