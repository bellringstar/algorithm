package rhs.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ20291 {

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

	static int N;
	static String[] files;
	static Map<String, Integer> fileCounter;

	static void input() {
		N = scan.nextInt();
		files = new String[N];
		for (int i = 0; i < N; i++) {
			files[i] = scan.next().split("\\.")[1];
		}
		fileCounter = new LinkedHashMap<>();
	}

	static void pro() {
		Arrays.sort(files);
		for (String extend : files) {
			fileCounter.put(extend, fileCounter.getOrDefault(extend, 0) + 1);
		}
		for (Map.Entry<String, Integer> entry : fileCounter.entrySet()) {
			sb.append(entry.getKey()).append(" ").append(entry.getValue()).append('\n');
		}
		System.out.println(sb);
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
