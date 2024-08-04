package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ10816 {
	static FastReader scan = new FastReader();
	static int N, M;
	static Map<Integer, Integer> A = new HashMap<>();

	static void input() {
		N = scan.nextInt();
		for (int i = 1; i <= N; i++) {
			int num = scan.nextInt();
			A.put(num, A.getOrDefault(num, 0) + 1);
		}
		M = scan.nextInt();
	}

	public static void main(String[] args) {
		input();
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= M; i++) {
			int target = scan.nextInt();
			sb.append(A.getOrDefault(target, 0));
			sb.append(" ");
		}
		System.out.println(sb);
	}

	static class FastReader {
		private BufferedReader br;
		private StringTokenizer st;

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
