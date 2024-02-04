package boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15663 {

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static int[] nums, selected;
	static boolean[] used;

	static void input() {
		N = scan.nextInt();
		M = scan.nextInt();
		nums = new int[N + 1];
		for (int i = 1; i <= N; i++)
			nums[i] = scan.nextInt();
		Arrays.sort(nums, 1, N + 1);
		selected = new int[M + 1];
		used = new boolean[N + 1];
	}

	static void rec_func(int k) {
		if (k == M + 1) {
			for (int i = 1; i <= M; i++)
				sb.append(selected[i]).append(' ');
			sb.append('\n');
		} else {
			int last_cand = 0;
			for (int cand = 1; cand <= N; cand++) {
				if (used[cand] == true)
					continue;
				if (nums[cand] == last_cand)
					continue;

				last_cand = nums[cand];
				selected[k] = nums[cand];
				used[cand] = true;
				rec_func(k + 1);
				selected[k] = 0;
				used[cand] = false;

			}
		}
	}

	public static void main(String[] args) {
		input();
		rec_func(1);
		System.out.println(sb.toString());
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
