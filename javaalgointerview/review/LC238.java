package review;

public class LC238 {
	class Solution {
		public int[] productExceptSelf(int[] nums) {
			int[] result = new int[nums.length];

			int p = 1;
			for (int i = 0; i < nums.length; i++) {
				result[i] = p;
				p *= nums[i];
			}

			p = 1;
			for (int i = nums.length - 1; i >= 0; i--) {
				result[i] *= p;
				p *= nums[i];
			}
			return result;
		}
	}
}
