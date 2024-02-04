package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ6236 {

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

	static int N, M;
	static int[] money;

	static void input() {
		N = scan.nextInt();
		M = scan.nextInt();
		money = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			money[i] = scan.nextInt();
		}
	}

	static boolean isPossilbe(int m) {
		int cnt = 1, sum = 0;
		for (int i = 1; i <= N; i++) {
			if (sum + money[i] > m) {
				cnt++;
				sum = money[i];
			} else {
				sum += money[i];
			}
		}
		return cnt <= M;
	}

	static void pro() {
		int L = 0, R = 1000000000, ans = 0;
		for (int i = 1; i <= N; i++)
			L = Math.max(L, money[i]);
		while (L <= R) {
			int mid = (L + R) / 2;
			if (isPossilbe(mid)) {
				ans = mid;
				R = mid - 1;
			} else {
				L = mid + 1;
			}
		}
		System.out.println(ans);
	}

	public static void main(String[] args) {
		input();
		pro();
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

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
