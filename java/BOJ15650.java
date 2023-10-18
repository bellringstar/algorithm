import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15650 {

	static int N, M;
	static StringBuilder sb = new StringBuilder();
	static int[] selected;
	static boolean[] used;

	static void input() {
		FastReader scan = new FastReader();
		N = scan.nextInt();
		M = scan.nextInt();
		selected = new int[M+1];
		used = new boolean[N+1];
	}

	static void rec_func(int k) {
		if (k == M+1) {
			for(int x = 1; x <=M; x++) {
				sb.append(selected[x]).append(' ');
			}
			sb.append('\n');
		}
		else {
			int start = selected[k-1];
			if (selected[k-1] == 0) start = 0;
			for (int cand = start + 1; cand <= N; cand++) {
				if (used[cand]) continue;
				selected[k] = cand;
				used[k] = true;
				rec_func(k+1);
				selected[k] = 0;
				used[k] = false;
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

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
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
