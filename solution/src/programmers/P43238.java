package programmers;

public class P43238 {

	class Solution {
		public long solution(int n, int[] times) {
			long start = 1;
			long end = 1000000000000000000L;

			while (end > start) {
				long t = (start + end) / 2;

				if (isValid(t, n, times)) {
					end = t;
				} else {
					start = t + 1;
				}
			}

			return start;
		}

		private boolean isValid(long t, int n, int[] times) {
			long c = 0;
			for (int time : times) {
				c += t / time;
			}
			return c >= n;
		}
	}
}
