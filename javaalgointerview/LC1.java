import java.util.HashMap;
import java.util.Map;

public class LC1 {
	class Solution {
		public int[] twoSum(int[] nums, int target) {
			Map<Integer, Integer> indexMap = new HashMap<>();
			for (int i = 0; i < nums.length; i++) {
				if (indexMap.containsKey(target - nums[i])) {
					return new int[]{i, indexMap.get(target - nums[i])};
				}
				indexMap.put(nums[i], i);
			}
			return null;
		}
	}
}
