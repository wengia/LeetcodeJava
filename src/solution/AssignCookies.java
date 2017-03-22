package solution;

import java.util.Arrays;

/* Assign Cookies - Easy */
public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        int res = 0, cookie = 0, child = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        
        while(cookie < s.length && child < g.length) {
        	if (s[cookie++] >= g[child]) {
        		child++;
        		res++;
        	}
        }
        
        return res;
    }
}
