import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test {

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

	static int N, S;
	static int[] nums;

	static void input() {
		N = scan.nextInt();
		S = scan.nextInt();
		nums = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			nums[i] = scan.nextInt();
		}
	}

	static void pro() {
		
	}

	public static void main(String[] args) {
		input();
		pro();
	}

	static class FastReader {
		private BufferedReader br;
		private StringTokenizer st;

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
