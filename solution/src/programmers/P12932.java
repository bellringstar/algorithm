package programmers;

public class P12932 {

	class Solution {
		public int[] solution(long n) {
			StringBuilder sb = new StringBuilder(String.valueOf(n));
			sb.reverse();
			char[] arr = sb.toString().toCharArray();
			int[] result = new int[arr.length];

			for (int i = 0; i < arr.length; i++) {
				result[i] = arr[i] - '0';
			}

			return result;
		}
	}

}
