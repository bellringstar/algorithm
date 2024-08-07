package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
// 모든 0이 1로 바뀌는 데 걸리는 시간
// 0을 +1 로 늘리면서 확인. 0인 곳으로만 이동가능
// 다 끝난 다음 0인 곳이 존재한다? -> -1 없다? -> 최대값
public class BOJ7576 {

    static FastReader scan = new FastReader();
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static int M, N;
    static int[][] box;
    static Queue<Point> queue = new LinkedList<>();

    static void input() {
        M = scan.nextInt(); // c
        N = scan.nextInt(); // r
        box = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                box[i][j] = scan.nextInt();
                if (box[i][j] == 1) {
                    queue.add(new Point(i, j));
                }
            }
        }
    }

    static void bfs() {
        while (!queue.isEmpty()) {
            Point currPoint = queue.poll();
            int r = currPoint.r;
            int c = currPoint.c;
            for (int i = 0; i < 4; i++) {
                int nr = currPoint.r + dr[i];
                int nc = currPoint.c + dc[i];

                if (nr < 0 || nc < 0 || nr >=N || nc >=M) {
                    continue;
                }

                if (box[nr][nc] == 0) {
                    box[nr][nc] = box[r][c] +1;
                    queue.add(new Point(nr, nc));
                }
            }
        }
    }

    public static void findAnswer() {
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] > maxValue) {
                    maxValue = box[i][j];
                }
                if (box[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(maxValue - 1);
    }

    public static void main(String[] args) {
        input();
        bfs();
        findAnswer();
    }

    static class Point {
        int r, c;

        public Point(int r, int c) {
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
