package boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1759 {
	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static char[] letters;
	static int[] selected;

	static void input() {
		N = scan.nextInt();
		M = scan.nextInt();
		letters = new char[M + 1];
		for (int i = 1; i <= M; i++)
			letters[i] = scan.next().charAt(0);
		Arrays.sort(letters, 1, M + 1);
		selected = new int[N + 1];
	}

	static boolean isVowel(char x) {
		return x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u';
	}

	static void rec_func(int k) {
		if (k == N + 1) {
			int vowel = 0, consonant = 0;
			for (int i = 1; i <= N; i++) {
				char x = letters[selected[i]];
				if (isVowel(x))
					vowel++;
				else
					consonant++;
			}
			if (vowel >= 1 && consonant >= 2) {
				for (int i = 1; i <= N; i++)
					sb.append(letters[selected[i]]);
				sb.append('\n');
			}
		} else {
			for (int cand = selected[k - 1] + 1; cand <= M; cand++) {
				selected[k] = cand;
				rec_func(k + 1);
				selected[k] = 0;
			}
		}
	}

	public static void main(String[] args) {
		input();
		rec_func(1);
		System.out.println(sb.toString());
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
