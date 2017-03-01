package solution;

import java.util.*;

/* Binary Watch - Easy */
public class BinaryWatch {
    public List<String> readBinaryWatch(int num) {
        List<String> res = new LinkedList<>();
        for(int h = 0; h < 12; h++) {
        	for(int m = 0; m < 60; m++) {
        		if (Integer.bitCount(h) + Integer.bitCount(m) == num) {
        			String minute = (m < 10) ? "0" + m: "" + m;
        			res.add(h + ":" + minute);
        		}
        	}
        }
        
        return res;
    }
}
