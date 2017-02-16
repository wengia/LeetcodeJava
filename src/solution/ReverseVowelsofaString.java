package solution;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* Reverse Vowels of a String - Easy */
public class ReverseVowelsofaString {
    public String reverseVowels(String s) {
        if (s == null || s.isEmpty()) return "";
        Set<Character> vowel = new HashSet<>(Arrays.asList(
        		'a','e','i','o','u','A','E','I','O','U'));
        char[] res = s.toCharArray();
        int left = 0, right = s.length() - 1;
        while(left < right) {
        	while(left < right && !vowel.contains(res[left])) left++;
        	while(left < right && !vowel.contains(res[right])) right--;
        	
        	if (left >= right) break;
        	
        	char tmp = res[left];
        	res[left++] = res[right];
        	res[right--] = tmp;
        }
        
        return new String(res);
    }
}
