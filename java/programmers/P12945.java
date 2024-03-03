import java.util.Arrays;

public class P12945 {

	class Solution {

		private final int[] mem = new int[100001];

		public int solution(int n) {
			int[] mem = new int[100001];

			mem[0] = 0;
			mem[1] = 1;

			for (int i = 0; i <= n - 2; i++) {
				mem[i + 2] = (mem[i + 1] + mem[i])%1234567;
			}

			return mem[n];
		}

		public int solution2(int n) {
			Arrays.fill(mem, -1);
			for (int i = 0; i <= n; i++) {
				fibo(i);
			}

			return mem[n];
		}

		private int fibo(int n) {
			if (mem[n] != -1) return mem[n];
			if (n == 0 || n == 1) return n;

			return mem[n] = (fibo(n-1) + fibo(n-2)) % 1234567;
		}

	}
}
