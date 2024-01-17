package rhs.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ1759 {

	static StringBuilder sb = new StringBuilder();
	static FastReader scan = new FastReader();

	static int L, C;
	static String[] words;
	static int[] selected;

	static void input() {
		L = scan.nextInt();
		C = scan.nextInt();
		words = new String[C+1];
		for (int i = 1; i<= C; i++) {
			words[i] = scan.next();
		}
		Arrays.sort(words, 1, C+1);
		selected = new int[L+1];
	}

	static void recFunc(int k) {
		if (k == L+1) {
			int vowelCnt = 0, consoCnt = 0;
			String word = "";
			for (int i = 1; i <= L; i++) {
				word += words[selected[i]];
				if (isVowel(words[selected[i]])) {
					vowelCnt++;
				} else {
					consoCnt++;
				}
			}
			if (vowelCnt >= 1 && consoCnt >=2) {
				sb.append(word).append('\n');
			}
		} else {
			for (int cand = selected[k-1] + 1; cand <= C; cand++) {
				selected[k] = cand;
				recFunc(k+1);
				selected[k] = 0;
			}
		}
	}

	static boolean isVowel(String s) {
		List<String> vowel = Arrays.asList("a", "e", "i", "o", "u");
		return vowel.contains(s);
	}

	public static void main(String[] args) {
		input();
		recFunc(1);
		System.out.println(sb);
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
