package rhs.bruteforce;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJO15651 {

	static StringBuilder sb = new StringBuilder();
	static FastReader scan = new FastReader();

	static int N, M;
	static int[] selected;

	static void input() {
		N = scan.nextInt();
		M = scan.nextInt();
		selected = new int[M + 1];
	}

	static void recFunc(int k) {
		if (k == M+1) {
			for (int i = 1; i <= M; i++) {
				sb.append(selected[i]).append(" ");
			}
			sb.append("\n");
		} else {
			for (int cand = 1; cand <= N; cand++) {
				selected[k] = cand;
				recFunc(k+1);
				selected[k] = 0;
			}
		}
	}

	public static void main(String[] args) {
		input();
		recFunc(1);
		System.out.println(sb);
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		public FastReader(String s) throws FileNotFoundException {
			br = new BufferedReader(new FileReader(new File(s)));
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
