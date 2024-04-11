package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ13702 {

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

	static int N, K;
	static int[] volumes;

	// 주전자 용량은 같은데 내용량은 랜덤. N 주전자, K명에게 똑같이 나눠주려고 한다. 분배 후 주전자에 막걸리가 남는다 -> 버린다.
	// K명에대 최대한의 많은 양의 막걸리 분배 용량

	static void input() {
		N = scan.nextInt();
		K = scan.nextInt(); // N<= K

		volumes = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			volumes[i] = scan.nextInt(); // 주전자 용량
		}
	}

	static boolean isPossible(long cand) {
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			cnt += volumes[i] / cand;
		}
		return cnt >= K;
	}

	static void pro() {
		long L = 0, R = Integer.MAX_VALUE, ans = 0;
		while (L <= R) {
			long mid = (L + R) / 2;
			if (isPossible(mid)) {
				ans = mid;
				L = mid + 1;
			} else {
				R = mid - 1;
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
			while (st == null || !st.hasMoreTokens()) {
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
