public class LC238 {
    // 자기 자신을 제외한 곱, O(n) 시간제한, 나눗셈 사용하면 안된다.
    class Solution {
        public int[] productExceptSelf(int[] nums) {
            int[] left, right;
            left = leftProduct(nums);
            right = rightProduct(nums);
            int[] rst = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                rst[i] = left[i] * right[i];
            }
            return rst;
        }

        public int[] leftProduct(int[] nums) {
            int[] left = new int[nums.length];
            left[0] = 1;
            for (int i = 1; i < nums.length; i++) {
                left[i] = left[i-1] * nums[i-1];
            }
            return left;
        }

        public int[] rightProduct(int[] nums) {
            int[] right = new int[nums.length];
            int n = nums.length - 1;
            right[n] = 1;
            for (int i = n-1; i >= 0; i--) {
                right[i] = right[i+1] * nums[i+1];
            }
            return right;
        }
    }
}
