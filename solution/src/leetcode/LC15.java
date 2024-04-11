package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC15 {
	class Solution {
		public List<List<Integer>> threeSum(int[] nums) {
			// 전부 서로 다른 위치에 존재하는 합이 0인 수의 조합
			Set<List<Integer>> rst = new HashSet<>();
			int target, start, end, sum;
			Arrays.sort(nums);
			for (int i = 0; i < nums.length - 2; i++) {
				target = -nums[i];
				start = i + 1;
				end = nums.length - 1;
				while (start < end) {
					sum = nums[start] + nums[end];
					if (sum > target) {
						end--;
					} else if (sum < target) {
						start++;
					} else {
						rst.add(new ArrayList<>(List.of(nums[i], nums[start], nums[end])));
						while (start < nums.length - 1 && nums[start] == nums[start + 1]) {
							start++;
						}
						while (end > 0 && nums[end] == nums[end - 1]) {
							end--;
						}
						start++;
						end--;
					}
				}
			}
			return new ArrayList<>(rst);
		}
	}
}
