package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2579 {

	static FastReader scan = new FastReader();
	static int N;
	static int[] points;
	static int[][] dp;

	static void input() {
		N = scan.nextInt();
		points = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			points[i] = scan.nextInt();
		}
		dp = new int[302][2];
	}

	static void pro() {
		dp[1][0] = points[1];
		dp[2][0] = points[2];
		dp[2][1] = points[1] + points[2];
		for (int i = 3; i <= N; i++) {
			dp[i][0] = Math.max(dp[i - 2][1] + points[i], dp[i - 2][0] + points[i]);
			dp[i][1] = dp[i - 1][0] + points[i];
		}

	}

	public static void main(String[] args) {
		input();
		pro();
		System.out.println(Math.max(dp[N][0], dp[N][1]));
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
