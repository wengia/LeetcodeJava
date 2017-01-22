package testdrive;

import java.util.*;
import solution.*;

public class Test {
	public static void main(String args[]) {
		int[] board = {1,3,3,6,7};
		SlidingWindowMedian test = new SlidingWindowMedian();
		System.out.println(test.medianSlidingWindow(board, 3));
		
		int a = Integer.MIN_VALUE, b = Integer.MIN_VALUE;
		double c = ((double)a + (double)b) / 2.0;
		System.out.println(c);
	}

}
