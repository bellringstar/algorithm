import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14888 {

	static StringBuilder sb = new StringBuilder();
	static int N, max, min;
	static int[] nums;
	static int[] operators;

	static void input() {
		FastReader scan = new FastReader();
		N = scan.nextInt();
		nums = new int[N+1];
		for (int i = 1; i<=N; i++) {
			nums[i] = scan.nextInt();
		}
		operators = new int[5];
		for (int i = 1; i<=4; i++) {
			operators[i] = scan.nextInt();
		}

		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
	}

	static int calc(int num1, int op, int num2) {
		if (op == 1) {
			return num1 + num2;
		}
		else if (op == 2) {
			return num1 - num2;
		} else if (op == 3) {
			return num1 * num2;
		} else {
			return num1 / num2;
		}
	}

	static void rec_func(int k, int value) {
		if (k == N) {
			max = Math.max(max, value);
			min = Math.min(min, value);
		} else {
			for (int cand = 1; cand <= 4; cand++) {
				// 연산자 선택
				if (operators[cand] >= 1) {
					operators[cand]--;
					rec_func(k+1, calc(value, cand, nums[k+1]));
					operators[cand]++;
				}
			}
		}
	}

	public static void main(String[] args) {
		input();
		rec_func(1, nums[1]);
		sb.append(max).append('\n').append(min);
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
