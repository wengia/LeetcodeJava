package testdrive;

import java.util.*;
import solution.*;

public class Test {
	public static void main(String args[]) {
		String[] version = {"1.11", "2.0.0", "1.2", "2", "0.1", "1.2.1", "1.1.1", "2.0"};
		
//		for(String num: nums)
//			System.out.println(num);
		
		int[] nums = new int[]{0,1,3,4,5,7,9,10,14};
		
		RepeatedSubstringPattern test = new RepeatedSubstringPattern();
		Integer.bitCount(0);
		
		
		int mask = 1 << 8;
		int used = 16 | mask;
		
		System.out.println(used);
		used &= ~mask;
		System.out.println(used);
	}
}
