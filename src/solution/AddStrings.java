package solution;

/* Add Strings - Easy */
public class AddStrings {
    public String addStrings(String num1, String num2) {
        if (num1 == null || num1.isEmpty()) return num2;
        int len1 = num1.length(), len2 = num2.length();
        int len = len1 > len2 ? len1: len2;
        int carry = 0;
        char[] sum = new char[len];
        
        for(int i = len - 1, idx1 = len1, idx2 = len2; i >= 0; i--) {
            int n1 = (--idx1 >= 0) ? num1.charAt(idx1) - '0': 0;
            int n2 = (--idx2 >= 0) ? num2.charAt(idx2) - '0': 0;
            int cur = (n1 + n2 + carry) % 10;
            sum[i] = (char) ('0' + cur);
            carry = (n1 + n2 + carry) / 10;
        }
        
        String res = new String(sum);
        return (carry == 0) ? res : carry + res;
    }
}
