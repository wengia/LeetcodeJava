package testdrive;

import java.util.*;
import solution.*;

public class Test {
	public static void main(String args[]) {
		String[] version = {"1.11", "2.0.0", "1.2", "2", "0.1", "1.2.1", "1.1.1", "2.0"};
		
//		for(String num: nums)
//			System.out.println(num);
		
		int[] nums = new int[]{250,145,145,145,145};
		IsSubsequence test = new IsSubsequence();
		
		for(int num: nums) {
			System.out.println(Integer.toBinaryString(num));
		}
		
	}
}
