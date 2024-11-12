package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10942 {
    static int N, M;
    static int[] nums;
    static int[][] queries;
    static FastReader scan = new FastReader();
    static boolean[][] dp;

    static void input() {
        N = scan.nextInt();
        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = scan.nextInt();
        }
        M = scan.nextInt();
        queries = new int[M][2];
        for (int i = 0; i < M; i++) {
            queries[i] = new int[]{scan.nextInt(), scan.nextInt()};
        }
        dp = new boolean[N][N];
    }

    static void solve() {
        for (int s = 0; s < N; s++) {
            // 홀수개 팰린드롬
            checkPalindrome(s, s);
            // 짝수개 팰린드롬
            checkPalindrome(s, s + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (int[] query : queries) {
            int s = query[0] - 1;
            int e = query[1] - 1;
            boolean result = dp[s][e];
            sb.append(result == true ? 1 : 0).append("\n");
        }
        System.out.println(sb);
    }

    static void checkPalindrome(int l, int r) {
        while (l >= 0 && r < N) {
            if (nums[l] == nums[r]) {
                dp[l][r] = true;
                l--;
                r++;
            } else {
                return;
            }
        }
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
