package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2933 {

    static final int[][] DIRECTION = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; //상하좌우
    static FastReader scan = new FastReader();
    static int R, C, N;
    static char[][] initialMap;
    static int[] heights;

    static class Result {
        boolean isDown;
        List<int[]> cand;

        public Result(boolean isDown, List<int[]> cand) {
            this.isDown = isDown;
            this.cand = cand;
        }
    }

    static void input() {
        R = scan.nextInt();
        C = scan.nextInt();
        initialMap = new char[R][C];
        for (int i = 0; i < R; i++) {
            initialMap[i] = scan.next().toCharArray();
        }
        N = scan.nextInt();
        heights = new int[N];
        for (int i = 0; i < N; i++) {
            heights[i] = R - scan.nextInt(); // 높이
        }
    }

    static void print(char[][] map) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < map.length; i++) {
            sb.append(map[i]);
            if (i != map.length -1) {
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    static void solve(char[][] map) {
        for (int i = 0; i < N; i++) {
            int height = heights[i];
            int[] target;
            if (i % 2 == 0) {
                target = findMineral(map, height, 0);
            } else {
                // right to left
                target = findMineral(map, height, 1);
            }
            if (target == null) {
                continue; // 맞은 미네랄이 없다.
            }

            map[target[0]][target[1]] = '.';

            // 해당 타겟 기중 상하좌우를 보고 하강 클러스터 후보 찾기
            List<int[]> cand = new ArrayList<>();
            for (int d = 0; d < 4; d++) {
                int nr = target[0] + DIRECTION[d][0];
                int nc = target[1] + DIRECTION[d][1];
                if (!inRange(nr, nc)) {
                    continue;
                }
                if (map[nr][nc] == 'x') {
                    cand.add(new int[]{nr, nc});
                }
            }

            if (cand.isEmpty()) {
                // 상하좌우에 연결된 미네랄이 없다 -> 클러스터 후보가 없다.
                continue;
            }

            List<List<int[]>> clusters = new ArrayList<>();
            boolean[][] visited = new boolean[R][C];

            for (int[] mineral : cand) {
                if (!visited[mineral[0]][mineral[1]]) {
                    Result result = findDownCluster(map, mineral);
                    if (result.isDown) {
                        clusters.add(result.cand);
                    }
                    for (int[] pos : result.cand) {
                        visited[pos[0]][pos[1]] = true;
                    }
                }
            }

            for (List<int[]> cluster : clusters) {
                for (int[] pos : cluster) {
                    map[pos[0]][pos[1]] = '.';
                }

                int minHeight = calcDownHeight(cluster, map);

                for (int[] pos : cluster) {
                    map[pos[0] + minHeight][pos[1]] = 'x';
                }
            }
        }
        print(map);
    }

    static int calcDownHeight(List<int[]> cluster, char[][] map) {
        int minHeight = Integer.MAX_VALUE;
        for (int[] pos : cluster) {
            int r = pos[0];
            int c = pos[1];
            int h = 0;
            r++;
            while (inRange(r, c) && map[r][c] != 'x') {
                h++;
                r++;
            }
            minHeight = Math.min(minHeight, h);
        }
        return minHeight;
    }

    static Result findDownCluster(char[][] map, int[] start) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[R][C];
        q.add(start);
        visited[start[0]][start[1]] = true;
        List<int[]> cand = new ArrayList<>();
        boolean isBottom = false;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            cand.add(curr);
            int r = curr[0];
            int c = curr[1];
            if (r == R - 1) {
                // 밑바닥 도달
                isBottom = true;
            }

            for (int d = 0; d < 4; d++) {
                int nr = r + DIRECTION[d][0];
                int nc = c + DIRECTION[d][1];

                if (!inRange(nr, nc)) continue;
                if (visited[nr][nc]) continue;
                if (map[nr][nc] == 'x') {
                    q.add(new int[]{nr, nc});
                    visited[nr][nc] = true;
                }
            }
        }
        return isBottom ? new Result(false, List.of()) : new Result(true, cand);
    }

    static boolean inRange(int r, int c) {
        return r >= 0 && r < R && c >= 0 && c < C;
    }

    static int[] findMineral(char[][] map, int r, int dir) {
        if (dir == 0) {
            // left to right
            for (int i = 0; i < C; i++) {
                if (map[r][i] == 'x') {
                    return new int[]{r, i};
                }
            }
        } else {
            for (int i = C - 1; i >= 0; i--) {
                if (map[r][i] == 'x') {
                    return new int[]{r, i};
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        input();
        solve(copy(initialMap));
    }

    private static char[][] copy(char[][] initialMap) {
        return Arrays.stream(initialMap)
                .map(char[]::clone)
                .toArray(char[][]::new);
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
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
