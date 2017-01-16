package solution;

public class AddDigits {
	// Digital Root
	// https://en.wikipedia.org/wiki/Digital_root
	public int addDigits(int num) {
        if (num == 0) return 0;
        int res = num % 9;
        return (res == 0) ? 9 : res;
    }

}
