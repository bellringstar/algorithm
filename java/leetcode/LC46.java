package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LC46 {

	/*
	순열
	 */

	class Solution {
		public List<List<Integer>> permute(int[] nums) {
			List<List<Integer>> answer = new ArrayList<>();
			dfs(0, nums, new int[nums.length], new int[nums.length], answer);
			return answer;
		}

		public void dfs(int k, int[] nums, int[] selected, int[] used, List<List<Integer>> answer) {
			if (k == nums.length) {
				List<Integer> result = new ArrayList<>();
				for (int idx : selected) {
					result.add(nums[idx]);
				}
				answer.add(result);
			} else {
				for (int cand = 0; cand < nums.length; cand++) {
					if (used[cand] == 1)
						continue;
					;
					selected[k] = cand;
					used[cand] = 1;
					dfs(k + 1, nums, selected, used, answer);
					selected[k] = 0;
					used[cand] = 0;
				}
			}
		}
	}

	class Solution2 {
		public List<List<Integer>> permute(int[] nums) {
			List<List<Integer>> results = new ArrayList<>();
			List<Integer> lst = Arrays.stream(nums).boxed().collect(Collectors.toList());
			dfs(results, new ArrayList<>(), lst);

			return results;

		}

		public void dfs(List<List<Integer>> results, List<Integer> prevElements, List<Integer> elements) {
			if (elements.isEmpty()) {
				results.add(prevElements.stream().collect(Collectors.toList()));
			}

			for (Integer e : elements) {
				List<Integer> nextElements = new ArrayList<>(elements);
				nextElements.remove(e);

				prevElements.add(e);
				dfs(results, prevElements, nextElements);
				prevElements.remove(e);
			}
		}
	}
}
