package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ6087 {

	static class Point {
		int r;
		int c;
		int d;
		int count;

		public Point(int r, int c, int d, int count) {
			this.r = r;
			this.c = c;
			this.d = d;
			this.count = count;
		}

		boolean isGoal() {
			return this.r == goal[0] && this.c == goal[1];
		}
	}
	static final int[][] DIRECTION = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static FastReader scan = new FastReader();
	static int W, H;
	static char[][] map;
	static int[] start;
	static int[] goal;
	static int[][] cPos;

    static void input() {
		W = scan.nextInt();
		H = scan.nextInt();
		map = new char[H][W];
		cPos = new int[2][2];
		int idx = 0;
		for (int i = 0; i < H; i++) {
			map[i] = scan.next().toCharArray();
			for (int j = 0; j < W; j++) {
				if (map[i][j] == 'C') {
					cPos[idx++] = new int[]{i, j};
				}
			}
		}
		start = cPos[0];
		goal = cPos[1];
    }

	static void bfs(int[] start) {
		Queue<Point> q = new ArrayDeque<>();
		int[][][] visited = new int[H][W][4];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				Arrays.fill(visited[i][j], Integer.MAX_VALUE);
			}
		}

		for (int d = 0; d < 4; d++) {
			q.add(new Point(start[0], start[1], d, 0));
			visited[start[0]][start[1]][0] = 0;
 		}

		int mirrorCount = Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			Point curr = q.poll();
			if (curr.isGoal()) {
				mirrorCount = Math.min(mirrorCount, curr.count);
				continue;
			}

			for (int d = 0; d < 4; d++) {
				int nr = curr.r + DIRECTION[d][0];
				int nc = curr.c + DIRECTION[d][1];

				if (!inRange(nr, nc)) continue;
				if (isWall(nr, nc)) continue;

				int nextCount = curr.count;
				if (!isStart(curr.r, curr.c) && isConner(curr.d, d)) {
					nextCount++;
				}

				if (visited[nr][nc][d] > nextCount) {
					visited[nr][nc][d] = nextCount;
					q.add(new Point(nr, nc, d, nextCount));
				}
			}
		}

		System.out.println(mirrorCount);
	}

	static boolean isStart(int r, int c) {
		return start[0] == r && start[1] == c;
	}

	static boolean isConner(int d1, int d2) {
		if (d1 == 0) {
			return d2 != 0 && d2 != 1;
		} else if (d1 == 1) {
			return d2 != 0 && d2 != 1;
		} else if (d1 == 2) {
			return d2 != 2 && d2 != 3;
		} else {
			return d2 != 2 && d2 != 3;
		}
	}

	static boolean inRange(int r, int c) {
		return r >= 0 && r < H && c >= 0 && c < W;
	}

	static boolean isWall(int r, int c) {
		return map[r][c] == '*';
	}


    public static void main(String[] args) {
		input();
		bfs(start);
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
    }
}
