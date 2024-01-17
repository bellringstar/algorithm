package rhs.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 높이 H를 설정해 적어도 M미터를 가져가려고한다. H의 최대값은?
 4 7
 20 15 10 17
 */

public class BOJ2805 {

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

	static int N, H;
	static int[] heights;

	static void input() {
		N = scan.nextInt();
		H = scan.nextInt();
		heights = new int[N];
		for (int i = 0; i < N; i++) {
			heights[i] = scan.nextInt();
		}
	}

	static void pro() {
		System.out.println(binarySearch(0, 2000000000));
	}

	static int binarySearch(long left, long right) {
		int res = 0;
		while (left <= right) {
			int mid = (int)((left + right) / 2);
			if (isPossible(mid)) {
				res = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return res;
	}

	static boolean isPossible(int height) {
		long heightSum = 0;
		for (int i = 0; i < N; i++) {
			heightSum += heights[i] - height > 0 ? heights[i] - height: 0;
		}
		return heightSum >= H;
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

		public String next() {
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
	}
}
