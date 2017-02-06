package solution;

/* Maximum Product of Word Lengths - Medium */
public class MaximumProductofWordLengths {
    public int maxProduct(String[] words) {
        if (words == null || words.length < 2) return 0;
        int res = 0;
        int[][] wordInBits = new int[words.length][2]; // first word, second word length
        
        for(int i = 0; i < words.length; i++) {
        	wordInBits[i][0] = convertWordToBit(words[i]);
        	wordInBits[i][1] = words[i].length();
        	for(int j = 0; j < i; j++) {
        		if ((wordInBits[j][0] & wordInBits[i][0]) == 0) {
        			res = Math.max(res, wordInBits[j][1] * wordInBits[i][1]);
        		}
        	}
        }
        
        return res;
    }
    
    private int convertWordToBit(String word) {
    	int bitString = 0;
    	for(int i = 0; i < word.length(); i++) {
    		int pos = word.charAt(i) - 'a';
    		bitString |= (1 << pos);
    	}
    	
    	return bitString;
    }
}
