package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class LC77 {
	/*
	1~n 중 k개를 선택한 조합
	 */

	class Solution {
		public List<List<Integer>> combine(int n, int k) {
			List<List<Integer>> results = new ArrayList<>();
			dfs(0, k, n, results, new int[k]);

			return results;
		}

		public void dfs(int depth, int k, int n, List<List<Integer>> results, int[] selected) {
			if (depth == k) {
				results.add(Arrays.stream(selected).boxed().collect(Collectors.toList()));
			} else {
				int start = depth == 0 ? 1 : selected[depth - 1] + 1;
				for (int cand = start; cand <= n; cand++) {
					selected[depth] = cand;
					dfs(depth + 1, k, n, results, selected);
					selected[depth] = 0;
				}
			}
		}
	}

	class Solution2 {
		public List<List<Integer>> combine(int n, int k) {
			List<List<Integer>> results = new ArrayList<>();
			dfs(results, new LinkedList<>(), n, 1, k);
			return results;

		}

		public void dfs(List<List<Integer>> results, LinkedList<Integer> elements, int n, int start, int k) {
			if (k == 0) {
				results.add(elements.stream().collect(Collectors.toList()));
				return;
			}
			for (int i = start; i <= n; i++) {
				elements.add(i);
				dfs(results, elements, n, i + 1, k - 1);
				elements.removeLast();
			}
		}
	}
}
