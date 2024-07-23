package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2562 {

    static FastReader scan = new FastReader();

    public static void main(String[] args) {
        int MAX = scan.nextInt();
        int idx = 0;

        for (int i = 1; i < 9; i++) {
            int input = scan.nextInt();
            if (input > MAX) {
                MAX = input;
                idx = i;
            }
        }

        System.out.println(MAX);
        System.out.println(idx + 1);
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
