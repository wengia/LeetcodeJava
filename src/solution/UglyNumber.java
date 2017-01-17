package solution;

public class UglyNumber {
	public boolean isUgly(int num) {
		while (num > 1) {
			if (num % 30 == 0) {
				num /= 30;
			} else if (num % 10 == 0) {
				num /= 10;
			} else if (num % 15 == 0) {
				num /= 15;
			} else if (num % 6 == 0) {
				num /= 6;
			} else if (num % 5 == 0) {
				num /= 5;
			} else if (num % 3 == 0) {
				num /= 3;
			} else if (num % 2 == 0) {
				num /= 2;
			} else {
				break;
			}
		}
		
        return num == 1;
    }
}
