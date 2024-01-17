package rhs.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ15970 {

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

	static int N,ans;
	static Map<Integer, List<Integer>> colorMap;

	static void input() {
		N = scan.nextInt();
		colorMap = new HashMap<>();
		for (int i = 0; i < N; i++) {
			int pos = scan.nextInt();
			int color = scan.nextInt();
			colorMap.putIfAbsent(color, new ArrayList<>());
			colorMap.get(color).add(pos);
		}
	}

	static void pro() {
		// 각 색별로 정리된 위치 리스트 정렬
		for (Map.Entry<Integer, List<Integer>> entry : colorMap.entrySet()) {
			Collections.sort(entry.getValue());
			for (int i = 0; i < entry.getValue().size(); i++) {
				ans += Math.min(toLeft(i, entry.getValue()), toRight(i, entry.getValue()));
			}
		}
		System.out.println(ans);

	}
	static int toLeft(int i, List<Integer> position) {
		if (i == 0) {
			return Integer.MAX_VALUE;
		}
		return position.get(i) - position.get(i-1);
	}

	static int toRight(int i, List<Integer> position) {
		if (i == position.size()-1) {
			return Integer.MAX_VALUE;
		}
		return position.get(i + 1) - position.get(i);
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
