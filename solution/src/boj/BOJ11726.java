package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11726 {

    static FastReader scan = new FastReader();
    static int N;
    static int[] mem;

    static void input() {
        N = scan.nextInt();
        mem = new int[1002];
    }

    public static void main(String[] args) {
        input();
        mem[1] = 1;
        mem[2] = 2;
        for (int i = 3; i <= N; i++) {
            mem[i] = (mem[i-1] + mem[i-2]) % 10007;
        }
        System.out.println(mem[N]);
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
