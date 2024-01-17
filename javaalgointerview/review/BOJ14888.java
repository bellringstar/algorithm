package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14888 {

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

	static int N,max,min;
	static int[] nums;
	static int[] operators;

	static void input() {
		N = scan.nextInt();
		nums = new int[N+1];
		operators = new int[5];
		for (int i = 1; i <= N; i++) {
			nums[i] = scan.nextInt();
		}
		for (int i = 1; i <= 4; i++) {
			operators[i] = scan.nextInt();
		}
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
	}

	static int calc(int operand1, int operator, int operand2) {
		if (operator == 1) {
			return operand1 + operand2;
		} else if (operator == 2) {
			return operand1 - operand2;
		} else if (operator == 3) {
			return operand1 * operand2;
		} else {
			return operand1 / operand2;
		}
	}

	static void recFunc(int k, int value) {
		if (k == N) {
			max = Math.max(max, value);
			min = Math.min(min, value);
		} else {
			for (int cand = 1; cand <=4; cand++) {
				if (operators[cand] >= 1) {
					operators[cand]--;
					recFunc(k+1, calc(value, cand, nums[k+1]));
					operators[cand]++;
				}
			}
		}
	}



	public static void main(String[] args) {
		input();
		recFunc(1, nums[1]);
		sb.append(max).append('\n').append(min);
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
