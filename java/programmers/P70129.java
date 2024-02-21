package programmers;

public class P70129 {

	/*
	변환
	1. x의 모든 0을 제거
	2. 제거 후 x의 길이를 c라고 하면 c를 2진법으로 표현한 문자열을 리턴

	x가 1이 될때까지 변환작업을 반복 이 때 변환 횟수와 제거된 0의 개수를 return
	 */

	static class Solution {
		public int[] solution(String s) {
			int[] result = new int[2];
			int convertCount = 0;
			int zeroCount = 0;

			while (!s.equals("1")) {
				String excluded = excludeZero(s);
				zeroCount += s.length() - excluded.length();
				convertCount += 1;

				s = convert(excluded);
			}

			result[0] = convertCount;
			result[1] = zeroCount;

			return result;
		}

		private String excludeZero(String source) {
			StringBuilder sb = new StringBuilder();
			char[] arr = source.toCharArray();

			for (char c : arr) {
				if (c != '0')
					sb.append(c);
			}
			return sb.toString();
		}

		private String convert(String source) {

			int length = source.length();

			return Integer.toString(length, 2);
		}
	}

	class Solution2 {
		public int[] solution(String s) {
			int loop = 0;
			int removed = 0;

			while (!s.equals("1")) {
				int zeros = countZero(s);
				loop += 1;
				removed += zeros;

				int ones = s.length() - zeros;
				s = Integer.toString(ones, 2);

			}

			return new int[] {loop, removed};
		}

		private int countZero(String s) {
			int zeros = 0;
			for (char c : s.toCharArray()) {
				if (c == '0')
					zeros++;
			}
			return zeros;
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solution("110010101001");
	}
}
