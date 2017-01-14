package testdrive;

import java.util.*;
import solution.*;

public class Test {
	public static void main(String args[]) {
		SlidingWindowMaximum test = new SlidingWindowMaximum();
		int res[] = test.maxSlidingWindow(new int[]{1,2,3}, 2);
		for (int i: res)
			System.out.println(i);
	}

}
