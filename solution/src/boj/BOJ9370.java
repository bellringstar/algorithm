package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class BOJ9370 {
    static int n, m, t;
    static int s, g, h;
    static List<List<Node>> graph;
    static int[] goalCandidates;
    static List<Integer> result;
    static int gh;
    static FastReader scan = new FastReader();

    static void solve() {
        int[] fromStart = dijkstra(s);
        int[] fromG = dijkstra(g);
        int[] fromH = dijkstra(h);

        for (int goal : goalCandidates) {
            int normalDist = fromStart[goal];

            int routeOne = fromStart[g] + gh + fromH[goal];
            int routeTwo = fromStart[h] + gh + fromG[goal];

            if (Math.min(routeOne, routeTwo) == normalDist) {
                result.add(goal + 1);
            }
        }
        printResult();
    }

    static int[] dijkstra(int start) {
        int[] distances = new int[n];
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.distance));

        for (int node = 0; node < n; node++) {
            distances[node] = Integer.MAX_VALUE;
        }
        distances[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (curr.distance > distances[curr.id]) {
                continue;
            }

            for (Node neighbor : graph.get(curr.id)) {
                int newDistance = distances[curr.id] + neighbor.distance;

                if (newDistance < distances[neighbor.id]) {
                    distances[neighbor.id] = newDistance;
                    pq.offer(new Node(neighbor.id, newDistance));
                }
            }
        }

        return distances;
    }

    static void printResult() {
        String answer = result.stream().sorted().map(String::valueOf).collect(Collectors.joining(" "));
        System.out.println(answer);
    }

    public static void main(String[] args) {
        int T = scan.nextInt();
        for (int i = 0; i < T; i++) {
            graph = new ArrayList<>();
            result = new ArrayList<>();

            n = scan.nextInt();
            m = scan.nextInt();
            t = scan.nextInt();
            s = scan.nextInt() - 1;
            g = scan.nextInt() - 1;
            h = scan.nextInt() - 1;

            goalCandidates = new int[t];
            for (int j = 0; j < n; j++) {
                graph.add(new ArrayList<>());
            }

            for (int j = 0; j < m; j++) {
                int node1 = scan.nextInt() - 1;
                int node2 = scan.nextInt() - 1;
                int cost = scan.nextInt();
                graph.get(node1).add(new Node(node2, cost));
                graph.get(node2).add(new Node(node1, cost));

                if ((node1 == g && node2 == h) || (node1 == h && node2 == g)) {
                    gh = cost;
                }
            }

            for (int j = 0; j < t; j++) {
                goalCandidates[j] = scan.nextInt() - 1;
            }

            solve();
        }
    }

    static class Node {
        int id;
        int distance;

        public Node(int id, int distance) {
            this.id = id;
            this.distance = distance;
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
