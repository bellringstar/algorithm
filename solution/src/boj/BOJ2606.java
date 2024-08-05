package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ2606 {

    static FastReader scan = new FastReader();
    static final int START = 1;
    static int N, M;
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        visited = new boolean[N + 1];
    }

    static void logic(int v) {
        visited[v] = true;

        for (int u : graph.get(v)) {
            if (!visited[u]) {
                logic(u);
            }
        }
    }

    public static void main(String[] args) {
        input();
        logic(START);
        int count = 0;
        for (int i = 2; i <= N; i++) {
            if (visited[i]) {
                count++;
            }
        }
        System.out.println(count);
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
