package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ4991 {

    static final int[][] DIRECTION = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static FastReader scan = new FastReader();
    static int W, H;
    static int[][] map;
    static int[] start;
    static Map<Integer, int[]> nodes;
    static int MIN;

    static int[][] calculateDistance() {
        int n = nodes.size();
        int[][] distances = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(distances[i], -1);
        }
        for (int start = 1; start <= nodes.size(); start++) {
            Queue<int[]> q = new LinkedList<>();
            boolean[][] visited = new boolean[H][W];
            int[] node = nodes.get(start);
            q.add(new int[]{node[0], node[1], 0});
            visited[node[0]][node[1]] = true;

            while (!q.isEmpty()) {
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];
                int cost = curr[2];

                if (map[r][c] > 0) {
                    distances[start][map[r][c]] = cost;
                    distances[map[r][c]][start] = cost;
                }

                for (int d = 0; d < 4; d++) {
                    int nr = r + DIRECTION[d][0];
                    int nc = c + DIRECTION[d][1];

                    if (!inRange(nr, nc)) {
                        continue;
                    }
                    if (map[nr][nc] == -1) {
                        continue;
                    }
                    if (visited[nr][nc]) {
                        continue;
                    }

                    q.add(new int[]{nr, nc, cost + 1});
                    visited[nr][nc] = true;
                }
            }
        }

        return distances;
    }

    static boolean inRange(int r, int c) {
        return r >= 0 && r < H && c >= 0 && c < W;
    }

    static void solve() {
        int[][] distances = calculateDistance();
        int n = nodes.size();
        permutate(0, n - 1, new int[n - 1], new boolean[n + 1], distances);
        System.out.println(MIN == Integer.MAX_VALUE ? -1 : MIN);
    }

    static void permutate(int depth, int n, int[] selected, boolean[] visited, int[][] distances) {
        if (depth == n) {
            int distance = 0;
            int start = 1;
            for (int node : selected) {
                if (distances[start][node] == -1) {
                    return;
                }
                distance += distances[start][node];
                start = node;
            }
            MIN = Math.min(MIN, distance);
            return;
        }

        for (int i = 2; i <= n + 1; i++) {
            if (visited[i]) {
                continue;
            }
            selected[depth] = i;
            visited[i] = true;
            permutate(depth + 1, n, selected, visited, distances);
            selected[depth] = 0;
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        while (true) {
            MIN = Integer.MAX_VALUE;
            W = scan.nextInt();
            H = scan.nextInt();
            if (W == 0 && H == 0) {
                return;
            }
            map = new int[H][W];
            nodes = new HashMap<>();
            int id = 1;
            for (int i = 0; i < H; i++) {
                char[] row = scan.next().toCharArray();
                for (int j = 0; j < W; j++) {
                    if (row[j] == 'o') {
                        map[i][j] = 1; // 시작점
                        start = new int[]{i, j};
                        nodes.put(1, start);
                    } else if (row[j] == '*') {
                        map[i][j] = ++id; // 더러운 칸 노드
                        nodes.put(id, new int[]{i, j});
                    } else if (row[j] == 'x') {
                        map[i][j] = -1; // 이동 불가능 칸
                    }
                }
            }

            solve();
        }
    }

    static class Edge {
        int from;
        int to;
        int cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return from + "," + to + "," + cost;
        }
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

        long nextLong() {
            return Long.parseLong(next());
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
