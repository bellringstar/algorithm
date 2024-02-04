package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11726 {

	static FastReader scan = new FastReader();
	static int N;
	static int[] dp;

	static void pro() {
		N = scan.nextInt();

		dp = new int[1002];
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i < 1001; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
		}
	}

	public static void main(String[] args) {
		pro();
		System.out.println(dp[N]);
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}
	}
}
