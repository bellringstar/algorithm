package boj;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2178 {

    static FastReader scan = new FastReader();

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int N, M;
    static int[][] graph;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        graph = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] rows = scan.next().split("");
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(rows[j]);
            }
        }
    }

    static void bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0));

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nr = point.r + dr[i];
                int nc = point.c + dc[i];
                if (nr < 0 || nc < 0 || nr >= N || nc >= M || graph[nr][nc] == 0) {
                    continue;
                }
                if (nr == N - 1 && nc == M - 1) {
                    System.out.println(graph[point.r][point.c] + 1);
                    return;
                }
                if (graph[nr][nc] == 1) {
                    queue.add(new Point(nr, nc));
                    graph[nr][nc] = graph[point.r][point.c] + 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        input();
        bfs();
    }

    static class Point {
        int r, c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
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
    }
}
