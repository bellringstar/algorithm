package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ10818 {

    static FastReader scan = new FastReader();
    static int N;
    static int[] arr;

    static void input() {
        N = scan.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scan.nextInt();
        }
    }

    public static void main(String[] args) {
        input();
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        sb.append(arr[0] + " " + arr[arr.length - 1]);
        System.out.println(sb);
    }

    public static void main2(String[] args) {
        input();
        int MAX = arr[0];
        int MIN = arr[0];
        for (int i = 0; i < N; i++) {
            if (arr[i] >= MAX) MAX = arr[i];
            if (arr[i] <= MIN) MIN = arr[i];
        }

        System.out.println(MIN + " " + MAX);
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
