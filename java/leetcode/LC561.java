package leetcode;

import java.util.Arrays;

public class LC561 {
	// 2n 크기의 nums, n쌍 (a,b)의 최소들의 합이 최대가 되는 상태의 합
	// 정렬 후 0,2,4..의 인덱스만 더한다
	class Solution {
		public int arrayPairSum(int[] nums) {
			Arrays.sort(nums);
			int sum = 0;
			for (int i = 0; i < nums.length; i += 2) {
				sum += nums[i];
			}
			return sum;
		}
	}
}
