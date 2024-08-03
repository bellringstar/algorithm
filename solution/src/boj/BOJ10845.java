package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ10845 {

    static FastReader scan = new FastReader();

    static int N;
    static String[] queries;
    static Deque<Integer> q = new ArrayDeque<>();

    static void input() {
        N = scan.nextInt();
        queries = new String[N];
        for (int i = 0; i < N; i++) {
            queries[i] = scan.nextLine();
        }
    }

    static void logic() {
        for (String query : queries) {
            String[] commands = query.split(" ");
            String command = commands[0];
            switch (command) {
                case "push":
                    q.addLast(Integer.parseInt(commands[1]));
                    break;

                case "pop":
                    if (q.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(q.pollFirst());
                    }
                    break;

                case "size":
                    System.out.println(q.size());
                    break;

                case "empty":
                    if (q.isEmpty()) {
                        System.out.println(1);
                    } else {
                        System.out.println(0);
                    }
                    break;

                case "front":
                    if (q.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(q.peekFirst());
                    }
                    break;

                case "back":
                    if (q.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(q.peekLast());
                    }
                    break;
            }
        }
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

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
