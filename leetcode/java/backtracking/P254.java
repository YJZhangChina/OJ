package leetcode.java.backtracking;

import java.util.ArrayList;
import java.util.List;

public class P254 {

	private List<List<Integer>> ans = new ArrayList<>();

	public List<List<Integer>> getFactors(int n) {
		ans.clear();
		backtracking(n, new ArrayList<>());
		System.out.println(ans.size());
		return ans;
	}

	public void backtracking(int n, List<Integer> list) {
		if (n == 1) {
			return;
		}
		for (int i = 2, j = (int) (Math.sqrt(n) + 1); i < j; ++i) {
			if (n % i == 0 && i >= (list.isEmpty() ? 1 : list.get(list.size() - 1))) {
				System.out.println(n + " " + i);
				List<Integer> copy = new ArrayList<>(list.size() + 2);
				copy.addAll(list);
				copy.add(i);
				copy.add(n / i);
				ans.add(copy);
				list.add(i);
				backtracking(n / i, list);
				list.remove(list.size() - 1);
			}
		}
	}

}
