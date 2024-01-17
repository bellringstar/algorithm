package rhs.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
C개를 설치, 한집에 하나, 인접한 두 집 거리 최대
C개의 공유기를 N개의 집에 적당히 설치해서 가장 인접한 두 공유기 사이의 거리를 최대로 하는 프로그램
 */

public class BOJ2110 {

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

	static int N,C;
	static int[] position;

	static void input() {
		N = scan.nextInt();
		C = scan.nextInt();
		position = new int[N];
		for (int i = 0 ; i < N; i++) {
			position[i] = scan.nextInt();
		}
	}

	static void pro() {
		Arrays.sort(position);
		
	}

	public static void main(String[] args) {

	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		public String next() {
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
	}
}
