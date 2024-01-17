package rhs.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
두개를 합쳐 0에 가장 가깝게 만들자
 */
public class BOJ2470 {

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

	static int N;
	static int[] A;

	static void input() {
		N = scan.nextInt();
		A = new int[N+1];
		for (int i = 1; i <= N; i++) {
			A[i] = scan.nextInt();
		}
	}

	static int lowerBound(int[] A, int L, int R, int X) {
		int res = R + 1;
		while (L <= R) {
			int mid = (L+R) / 2;
			if (A[mid] >= X) {
				res = mid;
				R = mid - 1;
			} else {
				L = mid + 1;
			}
		}
		return res;
	}

	static void pro() {
		Arrays.sort(A, 1, N+1);

		int bestSum = Integer.MAX_VALUE;
		int v1 = 0, v2 = 0;
		for (int left = 1; left <= N; left++) {
			int cand = lowerBound(A, left + 1, N, -A[left]);

			if (left < cand - 1 && Math.abs(A[left] + A[cand - 1]) < bestSum) {
				bestSum = Math.abs(A[left] + A[cand - 1]);
				v1 = A[left];
				v2 = A[cand - 1];
			}

			if (cand <= N && Math.abs(A[left] + A[cand]) < bestSum) {
				bestSum = Math.abs(A[left] + A[cand]);
				v1 = A[left];
				v2 = A[cand];
			}
		}
	}

	public static void main(String[] args) {

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
