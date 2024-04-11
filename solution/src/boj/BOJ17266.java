package boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ17266 {

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

	// 0~N을 모두 비출 수 있는 가로등의 최소 높이, 높이만큼 비출수있고 높이가 모두 같아야하는 정수다.
	// 높이 H -> 왼쪽 H 오른쪽 H만큼 -> 겹치는 공간이 존재

	static int N, M;
	static int[] positions;

	static void input() {
		N = scan.nextInt();
		M = scan.nextInt();
		positions = new int[M + 1];
		for (int i = 1; i <= M; i++) {
			positions[i] = scan.nextInt(); // 가로등 위치
		}
	}

	static boolean isPossible(int cand) {
		int last = 0; // 마지막으로 밝혀진 위치
		for (int i = 1; i <= M; i++) {
			if (positions[i] - last <= cand) { // 밝혀진 범위 내에 포함
				last = positions[i] + cand; // 오른쪽 까지 밝혀진 범위
			} else {
				return false;
			}
		}
		return last >= N;
	}

	static void pro() {
		int L = 1, R = 100000, ans = 0;
		Arrays.sort(positions, 1, M + 1);
		while (L <= R) {
			int mid = (L + R) / 2;
			if (isPossible(mid)) {
				ans = mid;
				R = mid - 1;
			} else {
				L = mid + 1;
			}
		}
		System.out.println(ans);
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
