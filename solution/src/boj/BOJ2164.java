package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2164 {

    static FastReader scan = new FastReader();

    static int N;
    static Queue<Integer> queue = new LinkedList<>();

    static void input() {
        N = scan.nextInt();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }
    }

    static void logic() {
        while (queue.size() > 1) {
            // 여기 들어왔다는건 queue size 최소 2개는 보장됨
            queue.poll(); //버리는 카드
            queue.add(queue.poll()); // 가장 위의 카드를 가장 뒤로
        }
        System.out.println(queue.peek());
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
