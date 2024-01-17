public class LC42 {
	/**
	 * 얼마나 많은 물을 가둘 수 있는가.
 	 */
	class Solution {
		int globalMaxIndex;
		int globalMax;
		public int trap(int[] height) {
			int ans = 0;
			for (int i = 0; i < height.length; i++) {
				if (height[i] > globalMax) {
					globalMaxIndex = i;
					globalMax = height[i];
				}
			}

			int left = 0, right = height.length - 1;
			int leftLocalMax = height[left], rightLocalMax = height[right];
			while (left < globalMaxIndex) {
				leftLocalMax = Math.max(leftLocalMax, height[left]);
				ans += leftLocalMax - height[left];
				left++;
			}

			while (right > globalMaxIndex) {
				rightLocalMax = Math.max(rightLocalMax, height[right]);
				ans += rightLocalMax - height[right];
				right--;
			}

			return ans;
		}
	}
}
