package leetcode.java.dp;

import leetcode.java.util.Util;

public class P1039 {

    public static void main(String[] args) {
//        new P1039().minScoreTriangulation(new int[]{1, 2, 3});
//        new P1039().minScoreTriangulation(new int[]{3, 7, 4, 5});
        new P1039().minScoreTriangulation(new int[]{1, 3, 1, 4, 1, 5});
    }

    public int minScoreTriangulation(int[] A) {
        int length = A.length;
        int[][] status = new int[length - 2][length];
        for (int i = 0; i < length; ++i) {
            int x = i, y = (i + 1) % length, z = (x + 2) % length;
            status[length - 2 - 1][i] = A[x] * A[y] * A[z];
        }
        for (int i = length - 2 - 2; i >= 0; --i) {
            for (int j = 0; j < length; ++j) {
                int min = Integer.MAX_VALUE;
                for (int k = 0, l = length - 2 - i; k < l; ++k) {
                    System.out.println("i: " + i + ",j: " + j + ",k: " + k + ",l:" + l);
                    int x = (j + k) % length, y = (j + k + l) % length, z = (j + k + l + 1) % length;
//                    System.out.println("x: " + x + ",y: " + y + ",z: " + z);
                    int value = status[i + 1][x] + A[x] * A[y] * A[z];
                    min = Math.min(min, value);
                }
                status[i][j] = min;
            }
        }
        Util.print(status);
        return 0;
    }

//    public int minScoreTriangulation(int[] A) {
//        int length = A.length;
//        int[][] status = new int[length - 2][length];
//        for(int i = 0; i < length; ++i) {
//            int x = i, y = (i + 1) % length, z = (x + 2) % length;
//            status[length - 2 - 1][i] = A[x] * A[y] * A[z];
//        }
//        for(int i = length - 2 - 2; i >=0; --i) {
//            for(int j = 0; j <length; ++j) {
//                int min = Integer.MAX_VALUE;
//                for(int k = 0, l = length - 2 - i; k < l; ++k) {
//
//                    int x = (j + k) % length, y = (x + l) %length, z = (x + l + 1) % length;
//                    System.out.println(x +" " +y +" "+z);
//                    int value = status[i+ 1][x] + A[x] * A[y] * A[z];
//                    min =  Math.min(min, value);
//                }
//                status[i][j] = min;
//            }
//        }
//        Util.print(status);
//        return 0;
//    }

}
