package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC1 {
	class Solution {
		public int[] twoSum(int[] nums, int target) {
			for (int i = 0; i < nums.length - 1; i++) {
				for (int j = i + 1; j < nums.length; j++) {
					if (nums[i] + nums[j] == target) {
						return new int[] {i, j};
					}
				}
			}
			return new int[] {};
		}
	}

	class Solution2 {
		public int[] twoSum(int[] nums, int target) {
			int[] rst = new int[2];
			Elem[] elems = new Elem[nums.length];
			for (int i = 0; i < nums.length; i++) {
				elems[i] = new Elem(i, nums[i]);
			}
			Arrays.sort(elems, (s1, s2) -> {
				return s1.value - s2.value;
			});

			int start = 0;
			int end = nums.length - 1;
			while (start < end) {
				int sum = elems[start].value + elems[end].value;
				if (sum == target) {
					rst[0] = elems[start].index;
					rst[1] = elems[end].index;
					break;
				} else if (sum < target) {
					start++;
				} else {
					end--;
				}
			}
			return rst;
		}
	}

	class Elem {
		int index;
		int value;

		public Elem(int index, int value) {
			this.index = index;
			this.value = value;
		}
	}

	class Solution3 {
		public int[] twoSum(int[] nums, int target) {
			Map<Integer, Integer> numsMap = new HashMap<>();
			for (int i = 0; i < nums.length; i++) {
				if (numsMap.containsKey(target - nums[i])) {
					return new int[] {i, numsMap.get(target - nums[i])};
				}
				numsMap.put(nums[i], i);
			}
			return null;
		}
	}
}
