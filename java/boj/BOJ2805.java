package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2805 {

	static FastReader scan = new FastReader();
	static int N, M;
	static int[] heights;

	static void input() {
		N = scan.nextInt();
		M = scan.nextInt();
		heights = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			heights[i] = scan.nextInt();
		}
	}

	static long getWood(int h) {
		long sum = 0;
		for (int i = 1; i <= N; i++) {
			if (heights[i] - h > 0) {
				sum += heights[i] - h;
			}
		}
		return sum;
	}

	static void find() {
		long left = 0, right = 2000000000, h = 0;
		while (left <= right) {
			int mid = (int)((left + right) / 2);
			if (getWood(mid) >= M) {
				h = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		System.out.println(h);
	}

	public static void main(String[] args) {
		input();
		find();
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
