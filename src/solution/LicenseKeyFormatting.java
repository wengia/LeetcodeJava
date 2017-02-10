package solution;

/* License Key Formatting - Medium */
public class LicenseKeyFormatting {
    public String licenseKeyFormatting(String S, int K) {
StringBuilder sb = new StringBuilder();
        
        for(int i = S.length() - 1, count = K; i >= 0; i--) {
        	if (S.charAt(i) == '-') continue;
    		
        	if (count == 0) {
        		sb.append('-');
        		count = K;
        	}
        	sb.append(convertChar(S.charAt(i)));
        	count--;
        }
        
        return sb.reverse().toString();
    }
    
    private char convertChar(char ch) {
    	if ('a' <= ch  && ch <= 'z') 
    		return (char) (ch + 'A' - 'a');
    	return ch;
    }
}
