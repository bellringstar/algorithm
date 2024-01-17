package rhs.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1181 {

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

	static int N;
	static String[] words;

	static void input() {
		N = scan.nextInt();
		words = new String[N];
		for (int i = 0; i < N; i++) {
			words[i] = scan.next();
		}
	}

	static void pro() {
		Arrays.sort(words, (s1, s2) -> {
			if (s1.length() != s2.length()) {
				return s1.length() - s2.length();
			}
			return s1.compareTo(s2);
		});
		String prevWord = words[0];
		System.out.println(prevWord);
		for (String word : words) {
			if (word.equals(prevWord)) {
				continue;
			}
			System.out.println(word);
			prevWord = word;
		}
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
