package programmers;

public class P68935 {

	class Solution {
		public int solution(int n) {

			String number = Integer.toString(n, 3);
			StringBuilder sb = new StringBuilder(number);
			String reversed = sb.reverse().toString();
			return Integer.parseInt(reversed, 3);
		}
	}
}
