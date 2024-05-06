package programmers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P12983 {

	class Solution {
		private static final int INF = 20_001;

		public int solution(String[] strs, String t) {
			int n = t.length();
			int[] dp = new int[n + 1];
			Arrays.fill(dp, INF);
			dp[0] = 0;

			Set<Integer> sizes = new HashSet<>();
			for (String str : strs) {
				sizes.add(str.length());
			}

			for (int i = 1; i <= n; i++) {
				for (int size : sizes) {
					if (i - size >= 0) {
						int idx = i;
						String sub = t.substring(idx - size, idx);
						if (Arrays.asList(strs).contains(sub)) {
							dp[i] = Math.min(dp[i], dp[i - size] + 1);
						}
					}
				}
			}
			return dp[n] < INF ? dp[n] : -1;
		}
	}
}
