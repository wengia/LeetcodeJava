package testdrive;

import java.util.*;
import solution.*;

public class Test {
	public static void main(String args[]) {
		int[] nums = new int[]{8,3,5};
		int[] copy = Arrays.copyOfRange(nums, 0, 6);
		System.out.println(copy.length + "|" + copy[0]);
	}

}
