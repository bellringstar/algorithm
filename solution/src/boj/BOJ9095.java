package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9095 {

	static FastReader scan = new FastReader();
	static int T;
	static int[] mem;

	static void dp() {
		mem = new int[12];
		mem[1] = 1; // 1
		mem[2] = 2; // 1+1, 2
		mem[3] = 4; // 1+1+1, 1+2, 2+1, 3
		for (int i = 4; i < 12; i++) {
			mem[i] = mem[i - 1] + mem[i - 2] + mem[i - 3];
		}
	}

	public static void main(String[] args) {
		T = scan.nextInt();
		dp();
		for (int i = 0; i < T; i++) {
			int num = scan.nextInt();
			System.out.println(mem[num]);
		}
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
	}

}
