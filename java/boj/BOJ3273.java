package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ3273 {

	static FastReader scan = new FastReader();
	static int n, x;
	static int[] A;

	static void input() {
		n = scan.nextInt();
		A = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			A[i] = scan.nextInt();
		}
		Arrays.sort(A, 1, n + 1);
		x = scan.nextInt();

	}

	static void twoPoint(int[] A, int left, int right, int target) {
		int cnt = 0;
		while (left < right) {
			int sum = A[left] + A[right];
			if (sum > target) {
				right--;
			} else if (sum < target) {
				left++;
			} else {
				cnt++;
				left++;
				right--;
			}
		}
		System.out.println(cnt);
	}

	static int binarySearch(int[] A, int left, int right, int target) {
		int cnt = 0;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (A[mid] == target) {
				return ++cnt;
			} else if (A[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		input();
		//        twoPoint(A, 1, n, x);
		int ans = 0;
		for (int i = 1; i <= n; i++) {
			int target = x - A[i];
			ans += binarySearch(A, i + 1, n, target);
		}
		System.out.println(ans);
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
