package solution;

/* UTF-8 Validation - Medium */
public class UTF8Validation {
    public boolean validUtf8(int[] data) {
    	int pos = 0;
    	while(pos < data.length) {
    		int count = countLevel(data[pos]);
    		if (count == 1 || count > 4) return false;
    		while(--count > 0) {
    			if (++pos >= data.length || (data[pos] >> 6) != 2)
    				return false;
    		}
    		pos++;
    	}
    	
    	return true;
    }
    
    private int countLevel(int seq) {
    	int mask = (1 << 7);
    	int count = 0;
    	
    	while(mask > 0 && (mask & seq) != 0) {
    		mask >>= 1;
    		count++;
    	}
    	
    	return count;
    }
}
