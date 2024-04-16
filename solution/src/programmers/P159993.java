package programmers;

import java.util.ArrayDeque;
import java.util.Queue;

public class P159993 {

	/*
1. 시작점에서 레버까지 bfs
2. 레버에서 출구까지 bfs
*/
	class Solution {

		static final int[] dr = {-1, 1, 0, 0};
		static final int[] dc = {0, 0, -1, 1};

		private int bfs(int[] start, int[] goal, String[] maps) {
			int N = maps.length;
			int M = maps[0].length();
			int[][] distance = new int[N][M];
			Queue<int[]> q = new ArrayDeque<>();
			q.add(start);
			distance[start[0]][start[1]] = 1;

			while(!q.isEmpty()) {
				int[] now = q.poll();
				if (now[0] == goal[0] && now[1] == goal[1]) {
					return distance[now[0]][now[1]];
				}
				for (int d = 0; d < 4; d++) {
					int nr = now[0] + dr[d];
					int nc = now[1] + dc[d];
					if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
					if (maps[nr].charAt(nc) == 'X') continue;
					if (distance[nr][nc] != 0) continue;
					q.add(new int[]{nr, nc});
					distance[nr][nc] = distance[now[0]][now[1]] + 1;
				}
			}
			return -1;
		}
		public int solution(String[] maps) {
			int[] start = {};
			int[] lever = {};
			int[] goal = {};
			for (int i = 0; i < maps.length; i++) {
				char[] row = maps[i].toCharArray();
				for (int j = 0; j < maps[i].length(); j++) {
					if (row[j] == 'S') {
						start = new int[]{i, j};
					} else if (row[j] == 'L') {
						lever = new int[]{i, j};
					} else if (row[j] == 'E') {
						goal = new int[]{i, j};
					}
				}
			}
			int startToLever = bfs(start, lever, maps);
			int leverToGoal = bfs(lever, goal, maps);
			if (startToLever == -1 || leverToGoal == -1) {
				return -1;
			}
			return startToLever + leverToGoal - 2;
		}
	}
}
