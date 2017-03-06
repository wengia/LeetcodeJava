package solution;

/* Arithmetic Slices - Medium */
public class ArithmeticSlices {
	public int numberOfArithmeticSlices(int[] A) {
		int res = 0, current = 0;
		for(int i = 2; i < A.length; i++) {
        	if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
        		current++;
        		res += current;
        	} else
        		current = 0;
		}
		return res;
	}
	
    public int numberOfArithmeticSlicesThinkingProcess(int[] A) {
        int start = 0, end = 1, pos = 0;
        int[] arithmetic = new int[A.length];
        
        for(int i = 2; i < A.length; i++) {
        	if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
        		end++;
        	} else {
        		arithmetic[pos++] = end - start + 1;
        		start = i - 1;
        		end = i;
        	}
        }
        
        if (end - start + 1 >= 3) {
        	arithmetic[pos++] = end - start + 1;
        }
        
        int res = 0;
        for(int i = 0; i < pos; i++) {
        	if (arithmetic[i] < 3) continue;
        	int len = arithmetic[i] - 3 + 1;
        	res += (1 + len) * len / 2;
        }
        
        return res;
    }
}
