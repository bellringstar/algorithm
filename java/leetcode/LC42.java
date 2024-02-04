package leetcode;

public class LC42 {
	class Solution {
		public int trap(int[] height) {
			int globalMaxIndex, volume;
			globalMaxIndex = getMaxHeightIndex(height);
			int start = 0;
			int end = height.length - 1;
			int leftMax = height[start];
			volume = 0;
			while (start <= globalMaxIndex) {
				leftMax = Math.max(leftMax, height[start]);
				volume += leftMax - height[start];
				start++;
			}
			int rightMax = height[end];
			while (end >= globalMaxIndex) {
				rightMax = Math.max(rightMax, height[end]);
				volume += rightMax - height[end];
				end--;
			}
			return volume;
		}

		public int getMaxHeightIndex(int[] height) {
			int globalMax = height[0];
			int globalMaxIndex = 0;
			for (int i = 1; i < height.length; i++) {
				if (globalMax < height[i]) {
					globalMax = height[i];
					globalMaxIndex = i;
				}
			}
			return globalMaxIndex;
		}
	}

	class Solution2 {
		public int trap(int[] height) {
			int volume = 0;
			int left = 0;
			int right = height.length - 1;
			int leftMax = height[left];
			int rightMax = height[right];

			while (left < right) {
				leftMax = Math.max(height[left], leftMax);
				rightMax = Math.max(height[right], rightMax);

				if (leftMax <= rightMax) {
					volume += leftMax - height[left];
					left++;
				} else {
					volume += rightMax - height[right];
					right--;
				}
			}
			return volume;
		}
	}
}
