package solution;

/* Reconstruct Original Digits from English - Medium */
public class ReconstructOriginalDigitsfromEnglish {
	/**
	 * Unique Letters
	 * 0 - zero - 'z'
	 * 2 - two  - 'w'
	 * 4 - four - 'u'
	 * 6 - six  - 'x'
	 * 8 - eight- 'g'
	 * 7 & 6 - six, seven  - 's'
	 * 5 & 7 - five, seven - 'v'
	 * 3 & 8 - three, eight- 'h'
	 * 1 & 0 & 2 & 4 - one     - 'o'
	 * 9 & 5 & 6 & 8 - nine    - 'i'
	 * 
	 * */
    public String originalDigits(String s) {
        int[] digits = new int[10];
        
        // Check Unique, 0, 2, 4, 6, 8 will be confirmed here
        for(int i = 0; i < s.length(); i++) {
        	char ch = s.charAt(i);
        	if (ch == 'z') digits[0]++;
        	else if (ch == 'w') digits[2]++;
        	else if (ch == 'u') digits[4]++;
        	else if (ch == 'x') digits[6]++;
        	else if (ch == 'g') digits[8]++;
        	else if (ch == 's') digits[7]++;
        	else if (ch == 'v') digits[5]++;
        	else if (ch == 'h') digits[3]++;
        	else if (ch == 'o') digits[1]++;
        	else if (ch == 'i') digits[9]++;
        }
        
        // Check 7, 5, 3
        digits[7] = digits[7] > digits[6] ? digits[7] - digits[6]: 0;
        digits[5] = digits[5] > digits[7] ? digits[5] - digits[7]: 0;
        digits[3] = digits[3] > digits[8] ? digits[3] - digits[8]: 0;
        
        // Check 1, 9
        digits[1] -= (digits[0] + digits[2] + digits[4]);
        digits[9] -= (digits[5] + digits[6] + digits[8]);
        
        // Construct Result
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i <= 9; i++) {
        	int count = digits[i] > 0 ? digits[i]: 0;
        	while(count-- > 0)
        		sb.append(i);
        }
        
        return sb.toString();
    }
}
