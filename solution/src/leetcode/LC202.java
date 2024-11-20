package leetcode;

import java.util.HashSet;
import java.util.Set;

public class LC202 {
	class Solution {
		public boolean isHappy(int n) {
			Set<Long> cache = new HashSet<>();

			long num = n;
			while (num != 1) {
				if (cache.contains(num)) {
					return false;
				}
				cache.add(num);
				num = calc(num);
			}

			return true;
		}

		private long calc(long num) {
			long sum = 0;

			while (num != 0) {
				sum += Math.pow(num % 10, 2);
				num /= 10;
			}
			return sum;
		}
	}
}
