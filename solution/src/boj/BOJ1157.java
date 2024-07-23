package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ1157 {

    static FastReader scan = new FastReader();

    static String s;

    static void input() {
        s = scan.next();
    }

    static void logic() {
        s = s.toUpperCase();
        Map<Character, Integer> map = new HashMap<>();
        int maxCount = 0;
        char answer = s.charAt(0);
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.get(c) > maxCount) {
                maxCount = map.get(c);
                answer = c;
            }
        }
        final int max = maxCount;
        long count = map.entrySet().stream()
                .filter(e -> e.getValue() == max)
                .count();
        if (count > 1) {
            System.out.println("?");
        } else {
            System.out.println(answer);
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

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
