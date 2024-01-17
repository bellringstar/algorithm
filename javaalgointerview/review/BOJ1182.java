package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1182 {

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

	static int N, S, ans;
	static int[] nums;

	static void input() {
		N = scan.nextInt();
		S = scan.nextInt();
		nums = new int[N+1];
		for (int i = 1; i <= N; i++) {
			nums[i] = scan.nextInt();
		}
	}

	static void recFunc(int k, int value) {
		if (k == N+1) {
			if (value == S) ans++;
		} else {
			recFunc(k+1, value + nums[k]);
			recFunc(k+1, value);
		}
	}

	public static void main(String[] args) {
		input();
		recFunc(1, 0);
		if (S == 0) {
			ans--;
		}
		System.out.println(ans);

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
