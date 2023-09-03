package bruteforce;

import java.util.*;
import java.io.*;

/*
N개의 자연수와 자연수 M 길이가 M인 수열
조건 : N개의 자연수 중에서 M개를 고른 수열 / 중복되는 수열은 여러번 출력하면 안된다. 수열은 공백으로 구분한다. 사전순 증가
 */

public class boj15663 {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] nums, selected;
    static boolean[] used;


    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        nums = new int[N+1];
        for (int i = 1; i <= N; i++) {
            nums[i] = scan.nextInt();
        }
        selected = new int[M+1];
        used = new boolean[N+1];
        Arrays.sort(nums, 1, N+1);
    }

    static void rec_func(int k) {
        if (k == M+1) {
            // selected 결정 (값 = nums의 index)
            for (int i = 1; i <= M; i++) {
                int index = selected[i];
                sb.append(nums[index]).append(" ");
            }
            sb.append('\n');

        } else {
            int lastCand = 0;
            for (int cand = 1; cand <=N; cand++ ) {
                // cand = 후보 인덱스
                if (used[cand]) {
                    continue;
                }
                if (nums[cand] == lastCand){
                    continue;
                }
                selected[k] = cand;
                lastCand = nums[cand];
                used[cand] = true;
                rec_func(k+1);
                selected[k] = 0;
                used[cand] = false;
            }
        }
    }

    public static void main(String[] args) {
        input();
        rec_func(1);
        System.out.println(sb.toString());
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException{
            br = new BufferedReader(new FileReader(new File(s)));
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

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
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


    }

}
