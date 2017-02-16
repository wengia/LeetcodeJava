package solution;

import java.util.*;

/* Top K Frequent Elements - Medium */
public class TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> frequency = new HashMap<>();
        
        // Count for all numbers frequency, O(N)
        for(int num: nums) {
        	int count = frequency.containsKey(num) ? frequency.get(num) : 0;
        	frequency.put(num, ++count);
        }
        
        // Count for top k, O(N)
        int[] fre = new int[frequency.size()];
        int[] elements = new int[frequency.size()];
        int left = 0, right = 0;
        for(int ele: frequency.keySet()) {
        	elements[right] = ele;
        	fre[right++] = frequency.get(ele);
        }
        right--; // right = frequency.size() - 1
        while(left < right) {
        	int pivot = theKLargestElement(fre, elements, left, right);
        	if (pivot == k) break;
        	else if (pivot < k) left = pivot + 1;
        	else right = pivot - 1;
        }
        
        // Construct result, O(k)
        List<Integer> res = new LinkedList<>();
        for(int i = 0; i < k; i++)
        	res.add(elements[i]);
        
        return res;
    }
    
    private int theKLargestElement(int[] frequency, int[] elements, int left, int right) {
    	Random rand = new Random();
    	int pivot = left + rand.nextInt(right - left);
    	int pivotNum = frequency[pivot];
    	swap(frequency, pivot, right);
    	swap(elements, pivot, right);
    	
    	for(int i = left; i < right; i++) {
    		if (frequency[i] > pivotNum) {
    			swap(frequency, left, i);
    			swap(elements, left++, i);
    		}
    	}
    	swap(frequency, left, right);
    	swap(elements, left, right);
    	
    	return left;
    }
    
    private void swap(int[] arr, int idx1, int idx2) {
    	int tmp = arr[idx1];
    	arr[idx1] = arr[idx2];
    	arr[idx2] = tmp;
    }
}
