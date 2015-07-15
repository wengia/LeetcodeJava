package testdrive;

import java.util.List;

import solution.LetterCombinationsOfaPhoneNumber;

public class Test {
	public static void main(String args[]) {
		String num = "23";
		LetterCombinationsOfaPhoneNumber test = new LetterCombinationsOfaPhoneNumber();
		List<String> res = test.letterCombinations(num);
		
		System.out.println(res);
	}

}
