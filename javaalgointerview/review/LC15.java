package review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC15 {
	/*
	합이 0이 되는 [nums[i], nums[j], nums[k]]의 묶음, i,j,k는 다 다르다.
	 */
	class Solution {
		public List<List<Integer>> threeSum(int[] nums) {
			int left, right, sum;
			List<List<Integer>> results = new ArrayList<>();
			Arrays.sort(nums);

			for (int i = 0; i < nums.length - 2; i++) {
				if (i > 0 && nums[i] == nums[i-1]) continue;
				left = i + 1;
				right = nums.length - 1;

				while (left < right) {
					sum = nums[i] + nums[left] + nums[right];
					if (sum < 0) {
						left++;
					} else if (sum > 0) {
						right--;
					} else {
						results.add(Arrays.asList(nums[i], nums[left], nums[right]));
						while (left < right && nums[left] == nums[left+1]){
							left++;
						}
						while (left < right && nums[right] == nums[right-1]) {
							right--;
						}
						left += 1;
						right -= 1;
					}
				}
			}
			return results;
		}
	}
}
