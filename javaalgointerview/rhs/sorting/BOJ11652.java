package rhs.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ11652 {

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

	static int N, maxCnt;
	static long max;
	static Map<Long, Integer> cardCounter;

	static void input() {
		N = scan.nextInt();
		cardCounter = new HashMap<>();
		for (int i = 0; i < N; i++) {
			long cardNumber = scan.nextLong();
			cardCounter.put(cardNumber, cardCounter.getOrDefault(cardNumber, 0) + 1);
		}
		max = Long.MAX_VALUE;
	}

	static void pro() {
		for (Map.Entry<Long, Integer> entry : cardCounter.entrySet()) {
			if (maxCnt == entry.getValue()) {
				if (max > entry.getKey()) {
					max = entry.getKey();
				}
			} else if (maxCnt < entry.getValue()) {
				max = entry.getKey();
				maxCnt = entry.getValue();
			}
		}
		System.out.println(max);
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
