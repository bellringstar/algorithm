package programmers;

public class P12900 {
	class Solution {
		public int solution(int n) {

			int[] mem = new int[n + 1];
			mem[1] = 1;
			mem[2] = 2;

			for (int i = 3; i <= n; i++) {
				mem[i] = (mem[i - 1] + mem[i - 2]) % 1_000_000_007;
			}
			return mem[n];
		}
	}
}
