package programmers;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class P49191 {

	class Solution {
		public int solution(int n, int[][] results) {
			boolean[][] graph = new boolean[n][n];
			for (int[] edge : results) {
				int u = edge[0] - 1;
				int v = edge[1] - 1;
				graph[u][v] = true;
			}

			int count = 0;
			for (int u = 0; u < n; u++) {
				int wins = countForward(u, graph, new boolean[n]) - 1;
				int loses = countBackward(u, graph, new boolean[n]) - 1;

				if (wins + loses + 1 == n) count++;
			}

			return count;
		}

		private int countForward(int u, boolean[][] graph, boolean[] isVisited) {
			int count = 1;

			for (int v = 0; v < graph.length; v++) {
				if (!graph[u][v] || isVisited[v]) continue;
				isVisited[v] = true;
				count += countForward(v, graph, isVisited);
			}

			return count;
		}

		private int countBackward(int u, boolean[][] graph, boolean[] isVisited) {
			int count = 1;

			for (int v = 0; v < graph.length; v++) {
				if (!graph[v][u] || isVisited[v]) continue;
				isVisited[v] = true;
				count += countBackward(v, graph, isVisited);
			}

			return count;
		}
	}

	/*
순위를 매길 수 있다 = 내 위로 몇명인지 내 아래로 몇명인지 확정이 된 상태
1. 정방향, 역방향 그래프 구성
2-1. 정방향으로 탐색 방문 노드 개수 u
2-2. 역방향 탐색 방문 노드 개수 v
3. n - v - u = 1 => 순위 확정
*/
	class Solution2 {

		private int bfs(int start, List<Integer>[] edges) {
			boolean[] visit = new boolean[edges.length];


			Queue<Integer> q = new ArrayDeque<>();
			q.add(start);
			visit[start] = true;

			while (!q.isEmpty()) {
				int now = q.poll();

				for (int next : edges[now]) {
					if (visit[next]) continue;
					q.add(next);
					visit[next] = true;
				}
			}

			int count = 0;
			for (int i = 1; i < edges.length; i++) {
				if (visit[i] == true) count++;
			}
			return count - 1; //자기 자신 제외
		}
		public int solution(int n, int[][] results) {

			List<Integer>[] wins = new ArrayList[n + 1];
			List<Integer>[] loses = new ArrayList[n + 1];

			for (int i = 1; i <= n; i++) {
				wins[i] = new ArrayList<>();
				loses[i] = new ArrayList<>();
			}

			for (int[] result : results) {
				int from = result[0];
				int to = result[1];
				wins[from].add(to);
				loses[to].add(from);
			}

			int answer = 0;

			for (int i = 1; i <= n; i++) {
				int start = i;

				int win = bfs(start, wins);
				int lose = bfs(start, loses);

				if (n - win - lose == 1) {
					answer++;
				}
			}

			return answer;
		}
	}
}
