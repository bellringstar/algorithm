package programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P67259 {
	/*
다익스트라.
1. 현재 위치에서 벽이 아닌 곳이면 상하좌우로 길을 놓는다.
2. 길을 놓은게 코너인지 직선인지 판단한다.
3. 그만큼 비용을 추가한다.
4. 도착지에 도달했을 때 최종 비용을 최소값으로 갱신한다.
도착지에 왼쪽에서 도달했는지 위쪽에서 도달했는지 경우가 나뉜다.
특정 지점으로 도착하는 방법은 총 4가지가 있다.
*/
	class Solution {

		static int[][][] distance;
		static int[] dx = {0, -1, 1, 0}; //상좌우하
		static int[] dy = {-1, 0, 0, 1};

		static class Point {
			int x;
			int y;
			int d;
			int cost;

			public Point(int x, int y, int d, int cost) {
				this.x = x;
				this.y = y;
				this.d = d;
				this.cost = cost;
			}
		}

		private int getCost(int d, int nd) {
			int cost = 100;
			if (d == -1) return cost;

			if (d == nd || d == 3-d) return cost;

			return cost + 500;
		}

		private void dijkstra(int[][] board) {

			PriorityQueue<Point> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
			pq.add(new Point(0, 0, -1, 0));
			for (int i = 0; i < 4; i++) {
				distance[i][0][0] = 0;
			}

			while (!pq.isEmpty()) {
				Point now = pq.poll();

				if (now.d != -1 && distance[now.d][now.y][now.x] < now.cost) continue;

				for (int d = 0; d < 4; d++) {
					int nx = now.x + dx[d];
					int ny = now.y + dy[d];
					if (ny < 0 || ny >= board.length || nx < 0 || nx >= board[ny].length) continue;
					if (board[ny][nx] == 1) continue;
					int cost = getCost(now.d, d);
					if (distance[d][ny][nx] > now.cost + cost) {
						distance[d][ny][nx] = now.cost + cost;
						pq.add(new Point(nx, ny, d, now.cost + cost));
					}
				}
			}
		}

		public int solution(int[][] board) {
			int N = board.length;
			int M = board[0].length;

			distance = new int[4][board.length][board[0].length];
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < board.length; j++) {
					Arrays.fill(distance[i][j], Integer.MAX_VALUE);
				}
			}
			dijkstra(board);
			int answer = Integer.MAX_VALUE;

			for (int d = 0; d < 4; d++) {
				answer = Math.min(answer, distance[d][N-1][M-1]);
			}
			return answer;
		}
	}
}
