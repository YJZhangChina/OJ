package leetcode.java;

public class Util {
	
	public static void print(int[] ints) {
		for(int i = 0; i < ints.length; i++) {
			System.out.print(ints[i] + " ");
		}
		System.out.println();
	}
	
	public static void print(int[][] ints) {
		for(int i = 0; i < ints.length; i++) {
			for(int j = 0; j < ints[i].length; j++) {
				System.out.print(ints[i][j] + " ");
			}
			System.out.println();
		}
	}

}
