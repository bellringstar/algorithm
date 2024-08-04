package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ1920ver2 {

    static FastReader scan = new FastReader();
    static int N, M;
    static Set<Integer> numbers = new HashSet<>();

    static void input() {
        N = scan.nextInt();
        for (int i = 0; i < N; i++) {
            numbers.add(scan.nextInt());
        }
        M = scan.nextInt();
    }

    static void logic() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int target = scan.nextInt();
            if (numbers.contains(target)) {
                sb.append("1\n");
            } else {
                sb.append("0\n");
            }
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        input();
        logic();
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

