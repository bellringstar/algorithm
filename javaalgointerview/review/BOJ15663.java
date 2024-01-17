package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15663 {

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

	static int N, M;
	static int[] nums, selected, used;

	static void input() {
		N = scan.nextInt();
		M = scan.nextInt();
		nums = new int[N+1];
		for (int i = 1; i <= N; i++) {
			nums[i] = scan.nextInt();
		}
		Arrays.sort(nums, 1, N+1);
		selected = new int[M+1];
		used = new int[N+1];
	}

	static void recFunc(int k) {
		if (k == M+1) {
			for (int i = 1; i <=M; i++) {
				sb.append(selected[i]).append(' ');
			}
			sb.append('\n');
		} else {
			int lastCand = 0;
			for (int cand = 1; cand <= N; cand++) {
				if (used[cand] == 1) continue;
				if (nums[cand] == lastCand) continue;

				lastCand = nums[cand];
				selected[k] = nums[cand];
				used[cand] = 1;
				recFunc(k+1);
				selected[k] = 0;
				used[cand] = 0;
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
