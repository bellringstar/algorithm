package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2816 {

    static FastReader scan = new FastReader();
    static int N;
    static String[] channels;
    static StringBuilder answer = new StringBuilder();

    static void input() {
        N = scan.nextInt();
        channels = new String[N];
        for (int i = 0; i < N; i++) {
            channels[i] = scan.next();
        }
    }

    static void solve() {
        int kbs1 = findChannel("KBS1");
        moveChannel(kbs1, 0);

        int kbs2 = findChannel("KBS2");
        if (kbs2 < kbs1) {
            kbs2++;
        }
        moveChannel(kbs2, 1);

        System.out.println(answer);
    }

    static void moveChannel(int from, int to) {
        if (from == to) {
            return;
        }
        for (int i = 0; i < from; i++) {
            // from 까지 이동
            answer.append("1");
        }

        for (int i = from; i > to; i--) {
            answer.append("4");
        }
    }

    static int findChannel(String channel) {
        for (int i = 0; i < N; i++) {
            if (channels[i].equals(channel)) {
                return i;
            }
        }
        return -1;
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
