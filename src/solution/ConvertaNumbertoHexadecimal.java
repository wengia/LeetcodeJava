package solution;

/* Convert a Number to Hexadecimal - Easy */
public class ConvertaNumbertoHexadecimal {
    public String toHex(int num) {
        if (num == 0) return "0";
        int mask = (1 << 4) - 1;
        StringBuilder sb = new StringBuilder();
        while(num != 0) {
            int lowestBase = num & mask;
            sb.append(baseUnit(lowestBase));
            num >>>= 4;
        }
        return sb.reverse().toString();
    }
    
    private char baseUnit(int num) {
        char ch = (char) ((num < 10) ? '0' + num: 'a' + (num - 10));
        return ch;
    }
}
