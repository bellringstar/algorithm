package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ8958 {

    static FastReader scan = new FastReader();
    static int N;
    static String[] arr;
    static StringBuilder sb = new StringBuilder();

    static void input() {
        N = scan.nextInt();
        arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scan.next();
        }
    }

    static void logic() {
        for (int i = 0; i < N; i++) {
            int score = 0;
            char[] result = arr[i].toCharArray();
            int x = 0;
            for (char c : result) {
                if (c == 'O') {
                    x++;
                    score += x;
                } else {
                    x = 0;
                }
            }
            sb.append(score).append('\n');
        }
    }

    public static void main(String[] args) {
        input();
        logic();
        System.out.println(sb);
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
