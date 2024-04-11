package boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1182 {
	// 크기가 양수인 부분수열 중 크기의 합이 S인 수열의 개수
	static FastReader scan = new FastReader();

	static int N, S, ans;
	static int[] nums, selected;

	static void input() {
		N = scan.nextInt();
		S = scan.nextInt();
		nums = new int[N + 1];
		selected = new int[N + 1];
		for (int i = 1; i <= N; i++)
			nums[i] = scan.nextInt();
	}

	static void rec_func(int k) {
		if (k == N + 1) {
			// 전부 선택 완료
			// 1. 합을 확인
			int sum = 0;
			for (int i = 1; i <= N; i++) {
				if (selected[i] == 1) {
					sum += nums[i];
				}
			}
			// 2. 합이 S과 같으면 ans 증가
			if (sum == S) {
				ans++;
			}
		} else {
			selected[k] = 1;
			rec_func(k + 1);
			selected[k] = 0;
			rec_func(k + 1);
		}
	}

	public static void main(String[] args) {
		input();
		rec_func(1);
		if (S == 0) {
			ans -= 1;
		}
		System.out.println(ans);
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
