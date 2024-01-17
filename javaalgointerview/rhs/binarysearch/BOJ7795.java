package rhs.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ7795 {

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

	static int T, N, M;
	static int[] A, B;


	static void input() {
		N = scan.nextInt();
		M = scan.nextInt();
		A = new int[N+1];
		for (int i = 1; i <= N; i++) {
			A[i] = scan.nextInt();
		}
		B = new int[M+1];
		for (int i = 1; i <= M; i++) {
			B[i] = scan.nextInt();
		}
	}

	static void pro() {
		int ans = 0;
		Arrays.sort(B, 1, M+1);
		for (int i = 1; i <= N; i++) {
			ans += binarySearch(B, A[i]);
		}
		System.out.println(ans);
	}

	static int binarySearch(int[] B, int target) {
		int left = 1, right = M;
		int idx = 0;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (B[mid] < target) {
				idx = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return idx;
	}

	public static void main(String[] args) {
		T = scan.nextInt();
		for (int i = 0; i < T; i++) {
			input();
			pro();
		}
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
