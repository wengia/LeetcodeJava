package solution;

public class HIndex {
    public int hIndex(int[] citations) {
    	int length = citations.length;
        int citationCount[] = new int[length + 1];
        for(int citation: citations) {
        	if (citation > length)
        		citationCount[length]++;
        	else
        		citationCount[citation]++;
        }
        
        int sum = 0;
        for(int i = length; i >= 0; i--) {
        	sum += citationCount[i];
        	if (sum >= i)
        		return i;
        }
        
        return 0;
    }
}
