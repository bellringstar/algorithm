package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2292 {

    static FastReader scan = new FastReader();
    static int N;

    static void input() {
        N = scan.nextInt();
    }

    static void solve() {
        int level = 2;
        int end = 1;

        while (end < N) {
            end += 6 * (level - 1);
            level++;
        }

        System.out.println(level - 1);
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
