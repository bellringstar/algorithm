package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2675 {

    static FastReader scan = new FastReader();

    static int T;
    static void logic() {
        int N = scan.nextInt();
        String s = scan.next();
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            for (int i = 0; i < N; i++) {
                sb.append(c);
            }
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        T = scan.nextInt();
        for (int i = 0; i < T; i++) {
            logic();
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
