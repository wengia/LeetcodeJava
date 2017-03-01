package solution;

/* Nth Digit - Easy */
public class NthDigit {
    public int findNthDigit(int n) {
        int len = 1;
        int start = 1;
        long count = 9;
        
        while(len * count < n) {
        	n -= len * count;
        	len++;
        	count *= 10;
        	start *= 10;
        }
        
        start += (n - 1) / len;
        String s = Integer.toString(start);
        char res = s.charAt((n - 1) % len);
        return res - '0';
    }
}
