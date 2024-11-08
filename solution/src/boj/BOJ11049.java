package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11049 {

    static FastReader scan = new FastReader();
    static int N;
    static int[][] matrices;

    static void input() {
        N = scan.nextInt();
        matrices = new int[N][2];
        for (int i = 0; i < N; i++) {
            matrices[i] = new int[]{scan.nextInt(), scan.nextInt()};
        }
    }

    static void solve() {
        int[][] dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(recFunc(0, N - 1, dp));
    }

    static int recFunc(int start, int end, int[][] dp) {
        if (start == end) {
            return 0;
        }

        if (dp[start][end] != -1) {
            return dp[start][end];
        }

        dp[start][end] = Integer.MAX_VALUE;
        for (int mid = start; mid < end; mid++) {
            int leftCost = recFunc(start, mid, dp);
            int rightCost = recFunc(mid + 1, end, dp);
            int mergeCost = matrices[start][0] * matrices[mid][1] * matrices[end][1];

            dp[start][end] = Math.min(dp[start][end], leftCost + rightCost + mergeCost);
        }
        return dp[start][end];
    }

    public static void main(String[] args) {
        input();
        solve();
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
