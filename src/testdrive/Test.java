package testdrive;

import java.util.*;
import solution.*;

public class Test {
	public static void main(String args[]) {
		String[] version = {"1.11", "2.0.0", "1.2", "2", "0.1", "1.2.1", "1.1.1", "2.0"};
		
//		for(String num: nums)
//			System.out.println(num);
		
		int[] nums = new int[]{0,1,3,4,5,7,9,10,14};
		ConvertaNumbertoHexadecimal test = new ConvertaNumbertoHexadecimal();
		
		char ch = 'a' + 10;
		int mask = (1 << 31) - 1;
		int i = -10;
		int j = i & mask;
		
//		System.out.println(test.toHex(-1));
		System.out.println(25 ^ 27);
		System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));
		System.out.println(Integer.toBinaryString(Integer.MIN_VALUE - 3));
	}
}
