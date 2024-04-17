package programmers;

import java.util.ArrayList;
import java.util.List;

public class P86971 {

	/*
트리 형태 -> 선을 하나만 끊어도 두 부분으로 나뉘어진다.
시작점을 정해 dfs로 탐색해간다. 전체 개수 - dfs깊이 = 나머지 그룹
*/
	class Solution {

		static boolean[] visited;
		static List<Integer>[] edges;
		static int N, answer;

		private int dfs(int now) {
			visited[now] = true;
			int sum = 0;
			for (int next : edges[now]) {
				if (visited[next]) continue;
				int cnt = dfs(next);
				answer = Math.min(answer, Math.abs(N - cnt * 2));
				sum += cnt;
			}
			return sum + 1;
		}

		public int solution(int n, int[][] wires) {
			N = n;
			answer = N - 1;

			edges = new ArrayList[n + 1];
			for (int i = 1; i <= n; i++) {
				edges[i] = new ArrayList<>();
			}

			for (int[] wire : wires) {
				edges[wire[0]].add(wire[1]);
				edges[wire[1]].add(wire[0]);
			}

			visited = new boolean[n + 1];
			dfs(1);

			return answer;
		}
	}
}
