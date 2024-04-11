package boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 전부 리스트에 넣고 정렬 후 가장 많은 수를 갱신해간다.
// Map을 사용해 넣은 후 거기서 value의 최대인 key를 찾는다.

public class BOJ11652 {

	static FastReader scan = new FastReader();

	static int N;
	static long[] a;

	static void input() {
		N = scan.nextInt();
		a = new long[N + 1];
		for (int i = 1; i <= N; i++) {
			a[i] = scan.nextLong();
		}
	}

	static void pro() {
		Arrays.sort(a, 1, N + 1);
		long mode = a[1];
		int modeCnt = 1, currCnt = 1;

		for (int i = 2; i <= N; i++) {
			if (a[i] == a[i - 1]) {
				currCnt++;
			} else {
				currCnt = 1;
			}

			if (currCnt > modeCnt) {
				modeCnt = currCnt;
				mode = a[i];
			}
		}
		System.out.println(mode);
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
