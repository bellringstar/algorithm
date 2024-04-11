package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class LC39 {
	/*
	조합을 찾는데 합이 target인 조합, 같은 수 선택 가능
	 */

	class Solution {
		public List<List<Integer>> combinationSum(int[] candidates, int target) {
			List<List<Integer>> results = new ArrayList<>();
			dfs(new LinkedList<Integer>(), candidates, target, results, 0);
			return results;
		}

		public void dfs(LinkedList<Integer> current, int[] candidates, int target, List<List<Integer>> results,
			int start) {
			if (current.stream().mapToInt(Integer::intValue).sum() > target) {
				return;
			}
			if (current.stream().mapToInt(Integer::intValue).sum() == target) {
				results.add(current.stream().collect(Collectors.toList()));
				return;
			}

			for (int i = start; i < candidates.length; i++) {
				current.add(candidates[i]);
				dfs(current, candidates, target, results, i);
				current.removeLast();
			}
		}
	}
}
