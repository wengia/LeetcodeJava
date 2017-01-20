package solution;

public class HIndexII {
	public int hIndex(int[] citations) {
		int res = 0;
		int left = 0, right = citations.length - 1;
		while(left <= right) {
			int mid = left + (right - left) / 2;
			if (citations.length - mid <= citations[mid]) {
				right = mid - 1;
				res = citations.length - mid;
			} else
				left = mid + 1;
		}
		
        return res;
    }
}
