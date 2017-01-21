package solution;

public class IntegertoEnglishWords {
	private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
	private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};
	
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        StringBuilder sb = new StringBuilder();
        int level = 0;
        while(num > 0) {
        	int current = num % 1000;
        	if (current > 0) {
        	    String currentString = numberToWordsHelper(current) + THOUSANDS[level] + " ";
        	    sb.insert(0, currentString);
        	}
        	
        	num /= 1000;
        	level++;
        }
        
        return sb.toString().trim();
    }
    
    // Calculate numbers < 10000
    private String numberToWordsHelper(int num) {
    	StringBuilder sb = new StringBuilder();
        if (num >= 100)
        	sb.append(LESS_THAN_20[num / 100]).append(" Hundred ");
        
        int firstTwo = num % 100;
        if (firstTwo < 20)
        	sb.append(LESS_THAN_20[firstTwo]);
        else if (firstTwo % 10 == 0)
        	sb.append(TENS[firstTwo / 10]);
        else
        	sb.append(TENS[firstTwo / 10]).append(" ").append(LESS_THAN_20[firstTwo % 10]);
        
        if(sb.length() != 0 && sb.charAt(sb.length() - 1) != ' ')
        	sb.append(' ');
        
        return sb.toString();
    }
}
