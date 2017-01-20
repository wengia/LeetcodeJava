package solution;

public class FirstBadVersion {
	// Good practice of using: mid = left + (right - left) / 2;
	// When left == right == INT_MAX, the (left + right) / 2 will cause overflow.
	public int firstBadVersion(int n) {
        int left = 0, right = n;
        int res = 0;
        while(left <= right) {
        	int mid = left + (right - left) / 2;
        	if (isBadVersion(mid)) {
        		right = mid - 1;
        		res = mid;
        	} else
        		left = mid + 1;
        }
        
        return res;
    }
	
	boolean isBadVersion(int version) {
		//Just for grammar check
		return false;
	}
}
