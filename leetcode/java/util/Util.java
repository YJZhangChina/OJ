package leetcode.java.util;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Util {

	public static void print(int[] ints) {
		int col = ints.length;
		System.out.print(ints[0]);
		for (int i = 1; i < col; ++i) {
			System.out.print("\t" + ints[i]);
		}
		System.out.println();
	}

	public static void print(int[][] ints) {
		int row = ints.length;
		for (int i = 0; i < row; ++i) {
			print(ints[i]);
		}
	}

	public static void print(int[][][] ints) {
		int level = ints.length;
		for (int i = 0; i < level; ++i) {
			System.out.println("Level: " + i);
			print(ints[i]);
		}
	}

	public static void print(long[] longs) {
		int col = longs.length;
		System.out.print(longs[0]);
		for (int i = 1; i < col; ++i) {
			System.out.print("\t" + longs[i]);
		}
		System.out.println();
	}

	public static void print(long[][] longs) {
		int row = longs.length;
		for (int i = 0; i < row; ++i) {
			print(longs[i]);
		}
	}

	public static void print(long[][][] longs) {
		int level = longs.length;
		for (int i = 0; i < level; ++i) {
			System.out.println("Level: " + i);
			print(longs[i]);
		}
	}

	public static void print(List<?> list) {
		int j = list.size();
		if (j > 0) {
			System.out.print(list.get(0));
		}
		for (int i = 1; i < j; i++) {
			System.out.print(" ");
			System.out.print(list.get(i));
		}
		System.out.println();
	}

	public static void print(Map<?, ?> map) {
		for (Entry<?, ?> entry : map.entrySet()) {
			System.out.println(entry.getKey() + "\t" + entry.getValue());
		}
	}

}
