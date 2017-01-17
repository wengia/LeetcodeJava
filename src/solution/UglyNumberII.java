package solution;

public class UglyNumberII {
	public int nthUglyNumber(int n) {
        int uglyList[] = new int[n];
        int l2 = 0, l3 = 0, l5 = 0;
        
        uglyList[0] = 1;
        for(int i = 1; i < n; i++) {
        	int tmp2 = uglyList[l2] * 2;
        	int tmp3 = uglyList[l3] * 3;
        	int tmp5 = uglyList[l5] * 5;
        	uglyList[i] = Math.min(tmp2, Math.min(tmp3, tmp5));
        	if (uglyList[i] == tmp2) l2++;
        	if (uglyList[i] == tmp3) l3++;
        	if (uglyList[i] == tmp5) l5++;
        }
        
        return uglyList[n - 1];
    }
}
