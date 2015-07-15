package solution;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfaPhoneNumber {
	private String[] keyboard = {" ", "", "abc", "def",
								"ghi", "jkl", "mno",
								"pqrs","tuv","wxyz"};
	
	public List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<String> ();
        if (digits == null || digits.isEmpty()) return res;
        
        StringBuilder combine = new StringBuilder();
        letterCombinations(0, digits, combine, res);
        return res;
    }
	
	private void letterCombinations(int pos, final String digits, StringBuilder combine, List<String> res) {
		if (pos >= digits.length()) {
			res.add(combine.toString());
			return;
		}
		
		try {
			int num = digits.charAt(pos) - '0';
			String cur = keyboard[num];
			
			for (int i = 0; i < cur.length(); i++) {
				char letter = cur.charAt(i);
				combine.append(letter);
				letterCombinations(pos + 1, digits, combine, res);
				combine.deleteCharAt(pos);
			}
		} 
		catch (Exception ex) {
			ex.printStackTrace();
		}
    }
}
