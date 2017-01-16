package testdrive;

import java.util.*;
import solution.*;

public class Test {
	public static void main(String args[]) {
		int num = 208;
		System.out.println(Integer.toBinaryString(num));
		System.out.println(Integer.toBinaryString(-num));
		System.out.println(Integer.toBinaryString(num & -num));
	}

}
