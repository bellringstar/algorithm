package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LC78 {
	class Solution {
		public List<List<Integer>> subsets(int[] nums) {

			List<List<Integer>> results = new ArrayList<>();
			dfs(results, nums, 0, new ArrayDeque<>());

			return results;

		}

		public void dfs(List<List<Integer>> results, int[] nums, int index, Deque<Integer> current) {
			results.add(new ArrayList<>(current));

			for (int i = index; i < nums.length; i++) {
				current.add(nums[i]);
				dfs(results, nums, i + 1, current);
				current.removeLast();
			}
		}
	}
}
