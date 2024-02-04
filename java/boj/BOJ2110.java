package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2110 {

	static FastReader scan = new FastReader();
	static int N, C;
	static int[] homes;

	static void input() {
		N = scan.nextInt();
		C = scan.nextInt();
		homes = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			homes[i] = scan.nextInt();
		}
		Arrays.sort(homes, 1, N);
	}

	static boolean possible(int len) {
		int cnt = 1, last = homes[1];
		for (int i = 2; i <= N; i++) {
			if (homes[i] - last < len)
				continue; // 최소 len만큼 떨어진 곳까지 이동
			last = homes[i];
			cnt++;
		}
		return cnt >= C;
	}

	static void pro(int left, int right) {
		// 1번집은 무조건 설치
		int maxLength = 1; // 최악의 상황 1
		while (left <= right) {
			int mid = (left + right) / 2;
			// 최대거리 mid만큼 떨어진 집에 공유기 설치하고 나머지도 다 설치가능?
			if (possible(mid)) {
				maxLength = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		System.out.println(maxLength);
	}

	public static void main(String[] args) {
		input();
		pro(1, 1000000000);
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
