package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ10021 {

    static FastReader scan = new FastReader();
    static int N, C;
    static int[][] fields;
    static List<Edge>[] graph;

    static void input() {
        N = scan.nextInt();
        C = scan.nextInt();
        fields = new int[N][2];
        for (int i = 0; i < N; i++) {
            fields[i] = new int[]{scan.nextInt(), scan.nextInt()};
        }
    }

    static void initGraph() {
        graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 각 노드부터 출발한 거리 계산
        for (int i = 0; i < N; i++) {
            int[] from = fields[i];
            for (int j = i + 1; j < N; j++) {
                int[] to = fields[j];
                int cost = calcCost(from, to);
                graph[i].add(new Edge(i, j, cost));
            }
        }
    }

    static int calcCost(int[] from, int[] to) {
        return (int) (Math.pow((from[0] - to[0]), 2) + Math.pow((from[1] - to[1]), 2));
    }

    static void solve() {
        int totalCost = 0;
        int edgeCount = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.cost));
        for (int i = 0; i < N; i++) {
            for (Edge e : graph[i]) {
                if (e.cost < C) {
                    continue;
                }
                pq.add(e);
            }
        }
        int[] parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }
        while (!pq.isEmpty()) {
            Edge curr = pq.poll();
            int from = curr.from;
            int to = curr.to;
            int cost = curr.cost;

            if (isConnected(parent, from, to)) {
                continue;
            }

            union(parent, from, to);
            totalCost += cost;
            edgeCount++;
        }

        System.out.println(edgeCount == N - 1 ? totalCost : -1);
    }

    static boolean isConnected(int[] parent, int x, int y) {
        return find(parent, x) == find(parent, y);
    }

    static void union(int[] parent, int x, int y) {
        int rootX = find(parent, x);
        int rootY = find(parent, y);

        if (rootX < rootY) {
            parent[rootY] = rootX;
        } else {
            parent[rootX] = rootY;
        }
    }

    static int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

    public static void main(String[] args) {
        input();
        initGraph();
        solve();
    }

    static class Edge {
        int from;
        int to;
        int cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return from + "," + to + "," + cost;
        }
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
