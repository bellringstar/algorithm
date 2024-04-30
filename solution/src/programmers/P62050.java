package programmers;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class P62050 {
	/*
높이차 -> height -> cost += 높이차
최소 비용
1. 시작점을 정한다. -> 어디서 하던 결국 똑같다.
2. 방문 할 수 있는 곳은 전부 방문한다. bfs
3. 방문 도중 높이차 때문에 방문 못한 조합을 기록해 둔다.
4. 그 중 비용이 가장 저렴한 경우를 꺼내 이동 후 다시 가능한 곳 방문
5. 모든곳을 방문할 때 까지 반복
*/
	static class Solution {

		static class Point {
			int r;
			int c;
			int height;

			public Point(int r, int c, int height) {
				this.r = r;
				this.c = c;
				this.height = height;
			}
		}

		static class Edge {
			Point from;
			Point to;
			int gap;

			public Edge(Point from, Point to) {
				this.from = from;
				this.to = to;
				this.gap = Math.abs(from.height - to.height);
			}
		}

		static boolean[][] visited;
		static PriorityQueue<Edge> pq;
		static final int[] DR = {-1, 1, 0, 0};
		static final int[] DC = {0, 0, -1, 1};
		static int N;
		static int answer;

		private boolean isValid(int r, int c) {
			return r >=0 && r < N && c >= 0 && c < N;
		}

		private void bfs(Point start, int[][] land, int height) {

			Queue<Point> q = new ArrayDeque<>();
			q.add(start);
			visited[start.r][start.c] = true;

			while (!q.isEmpty()) {
				Point curr = q.poll();
				for (int d = 0; d < 4; d++) {
					int nr = curr.r + DR[d];
					int nc = curr.c + DC[d];
					if (!isValid(nr, nc)) continue;
					if (visited[nr][nc]) continue;
					if (Math.abs(land[nr][nc] - curr.height) <= height) {
						// 이동 가능 Q에 추가
						q.add(new Point(nr, nc, land[nr][nc]));
						visited[nr][nc] = true;
					} else {
						// 이동 불가능 PQ에 추가
						Point to = new Point(nr, nc, land[nr][nc]);
						pq.add(new Edge(curr, to));
					}
				}
			}
		}

		private boolean visitAll() {
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (!visited[r][c]) return false;
				}
			}
			return true;
		}

		public int solution(int[][] land, int height) {
			N = land.length;
			visited = new boolean[N][N];
			pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.gap));
			// 모든 지점이 방문처리 될 때까지
			Point start = new Point(0, 0, land[0][0]);
			while (!visitAll()) {
				bfs(start, land, height);
				if (visitAll()) break;
				Edge e = pq.poll();
				while (!pq.isEmpty() && visited[e.to.r][e.to.c]) {
					e = pq.poll();
				}
				start = e.to;
				answer += e.gap;
			}

			System.out.println("answer = " + answer);
			return answer;
		}
	}

	class Solution2 {
		// 현재 좌표 기준 주변 비용 정렬
		private static class Node {
			int i, j, cost;
			public Node(int i, int j, int cost) {
				this.i = i;
				this.j = j;
				this.cost = cost;
			}
		}

		public int solution(int[][] land, int height) {
			int answer = 0;
			int n = land.length;
			int[] di = {-1, 0, 1, 0};
			int[] dj = {0, 1, 0, -1};
			boolean[][] visited = new boolean[n][n];

			PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
			pq.add(new Node(0, 0, 0));

			while (!pq.isEmpty()) {
				Node now = pq.poll();
				if (visited[now.i][now.j]) {
					continue;
				}

				visited[now.i][now.j] = true;
				answer += now.cost;

				for (int i = 0; i < 4; i++) {
					int ni = now.i + di[i];
					int nj = now.j + dj[i];

					if (!(0 <= ni && ni < n && 0 <= nj && nj < n)) continue;

					int tempCost = Math.abs(land[now.i][now.j] - land[ni][nj]);
					int newCost = tempCost > height ? tempCost : 0;
					pq.add(new Node(ni, nj, newCost));
				}
			}
			return answer;
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solution(new int[][]{{1, 4, 8, 10},{5, 5, 5, 5}, {10, 10, 10, 10}, {10, 10, 10, 20}}, 3);
	}
}
