package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10844 {

    static FastReader scan = new FastReader();
    static int N;
    static int[][] mem;

    static void input() {
        N = scan.nextInt();
        mem = new int[101][10]; // [길이][마지막 수 0~9]
    }

    static void pro() {
        for (int i = 1; i <= 9; i++) {
            mem[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            mem[i][0] = mem[i - 1][1];
            for (int j = 1; j <= 8; j++) {
                mem[i][j] = (mem[i - 1][j - 1] + mem[i - 1][j + 1]) % 1_000_000_000;
            }
            mem[i][9] = mem[i - 1][8];
        }

        long count = 0;
        for (int i = 0; i <= 9; i++) {
            count = (count + mem[N][i]) % 1_000_000_000;
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        input();
        pro();
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
