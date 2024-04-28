package programmers;

import java.util.Arrays;
import java.util.Collections;

public class P12933 {
	class Solution {
		public long solution(long n) {
			String[] arr = String.valueOf(n).split("");
			Arrays.sort(arr, Collections.reverseOrder());
			StringBuilder sb = new StringBuilder();
			for (String s : arr) {
				sb.append(s);
			}

			return Long.parseLong(sb.toString());
		}
	}

	class Solution2 {
		public long solution(long n) {
			int[] counts = new int[10];

			while (n > 0) {
				counts[(int)(n % 10)]++;
				n /= 10;
			}

			long answer = 0;
			for (int i = 9; i >= 0; i--) {
				for (int j = 0; j < counts[i]; j++) {
					answer += i;
					answer *= 10;
				}

			}
			return answer / 10;
		}

	}
}
