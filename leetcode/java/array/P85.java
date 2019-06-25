package leetcode.java.array;

public class P85 {

	public int maximalRectangle(char[][] matrix) {
		int ans = 0, m = matrix.length;
        if(m == 0) {
            return ans;
        }
        int n = matrix[0].length;
		int[][] status = new int[m + 1][n];
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				status[i + 1][j] = matrix[i][j] == '1' ? status[i][j] + 1 : 0;
			}
		}
		for (int i = 0; i < m; ++i) {
			ans = Math.max(ans, largestRectangleArea(status[i + 1]));
		}
		return ans;
	}

	public int largestRectangleArea(int[] heights) {
		int length = heights.length;
		int sum = 0;
		if (length == 0) {
			return sum;
		}
		int[] widths = new int[length];
		for (int i = 0; i < length; i++) {
			int width = 1;
			for (int j = i - 1; j > -1; j--) {
				if (heights[j] >= heights[i]) {
					width += 1;
				} else {
					break;
				}
			}
			for (int j = i + 1; j < length; j++) {
				if (heights[j] >= heights[i]) {
					width += 1;
				} else {
					break;
				}
			}
			widths[i] = width;
		}
		for (int i = 0; i < length; i++) {
			sum = Math.max(sum, widths[i] * heights[i]);
		}
		return sum;
	}

}
