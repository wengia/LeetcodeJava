package testdrive;

import java.util.*;
import solution.*;

public class Test {
	public static void main(String args[]) {
		String[] version = {"1.11", "2.0.0", "1.2", "2", "0.1", "1.2.1", "1.1.1", "2.0"};
		
//		for(String num: nums)
//			System.out.println(num);
		
		int[] nums = new int[]{250,145,145,145,145};
		IntegerReplacement test = new IntegerReplacement();
		
		double a = 3.0;
		System.out.println(a);
		Test.foo(a);
		System.out.println(a);
		System.out.println();
	}
	
	public static void foo(Double a) {
		a = 4.4;
	}
}
