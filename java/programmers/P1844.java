// import java.util.*;
//
// public class P1844 {
// 	/*
// 	 * bfs 최단거리
// 	 * n x m 크기
// 	 * 0은 벽 1은 자리
// 	 * 시작점 (1,1) 도착점(n,m)
// 	 * 시작점으로 부터 1인곳으로 이동, 상하좌우, 해당 위치 값 증가
// 	 * 더이상 이동이 볼가능 하거나 도착점에 도달했을 때 종료
// 	 * 도착점의 값이 1이다 -> -1 리턴 1이외의 값이면 그 값 리턴
// 	 */
//
// 	class Solution {
//
// 		private static final int[] dx = {0, 1, 0, -1};
// 		private static final int[] dy = {-1, 0, 1, 0};
//
// 		private static class State {
// 			public final int x;
// 			public final int y;
// 			public final int step;
//
// 			private State(int x, int y, int step) {
// 				this.x = x;
// 				this.y = y;
// 				this.step = step;
// 			}
// 		}
//
// 	    public int solution(int[][] maps) {
// 	        boolean[][] isVisited = new boolean[maps.length][maps[0].length];
//
// 	        Queue<State> queue = new LinkedList<>();
// 	        queue.add(new State(0,0,1));
// 	        isVisited[0][0] = true;
//
// 	        while (!queue.isEmpty()) {
// 	        	State state = queue.poll();
//
// 	        	if (state.y == maps.length - 1 && state.x == maps[state.y].length - 1) {
// 	        		return state.step;
// 	        	}
//
// 	        	for (int d = 0; d < 4; d++) {
// 	        		int nx = state.x + dx[d];
// 	        		int ny = state.y + dy[d];
//
// 	        		if (ny < 0 || ny >= maps.length || nx < 0 || nx >= maps[ny].length) {
// 	        			continue;
// 	        		}
//
// 	        		if (maps[ny][nx] != 1) {
// 	        			continue;
// 	        		}
//
// 	        		if (isVisited[ny][nx]) {
// 	        			continue;
// 	        		}
//
// 	        		isVisited[ny][nx] = true;
// 	        		queue.add(new State(nx, ny, state.step + 1));
// 	        	}
// 	        }
// 	        return -1;
//
// 	    }
// 	}
// }
