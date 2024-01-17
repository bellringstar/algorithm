package rhs.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9663 {

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

	static int N,cnt;
	static int[] columns;

	static void input() {
		N = scan.nextInt();
		columns = new int[N+1];
	}

	static void recFunc(int row) {
		if (row == N+1) {
			cnt++;
		} else {
			for (int col = 1; col <= N; col++) {
				boolean possible = true;
				for (int k = 1; k < row; k++) {
					if (attackable(k, columns[k], row, col)) {
						possible = false;
						break;
					}
				}
				if (possible) {
					columns[row] = col;
					recFunc(row+1);
					columns[row] = 0;
				}
			}
		}
	}

	static boolean attackable(int r1, int c1, int r2, int c2) {
		if (r1+c1 == r2+c2) {
			return true;
		}
		if (r1-c1 == r2-c2) {
			return true;
		}
		if (c1 == c2) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		input();
		recFunc(1);
		System.out.println(cnt);
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
