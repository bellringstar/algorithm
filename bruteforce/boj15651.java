package bruteforce;

import java.io.*;
import java.util.*;

//BOJ15651
/*
자연수 N과 M ( 1<=M<=N<=7) 길이가 M인 수열
1부터 N까지 자연수 중에서 M개를 고른 수열
같은 수를 여러번 골라도 된다.
=> 1~N 중 M개를 뽄는데 중복 가능 = 모든 경우의 수
1. 저장할 배열 필요 M 칸의 배열
2. 배열에 수를 삽입하는데 depth가 M이 된다 ? => 출력
3. M이 된 후는 이전 depth로 돌아가 다음 차례 수 진행.
 */
public class boj15651 {

    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] selected;

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        M = scan.nextInt();
        selected = new int[M+1];
    }

    // Recurrence Function
    // 만약 N개를 전부 고른다 -> 조건에 맞는 탐색을 한 가지 성공한 것
    // 앚기 M개를 고르지 않음 => k번째부터 M번째 원소를 조건에 맞게 고르는 모든 방법을 시도한다.

    static void rec_func(int k) {
        // M개를 골랐다. = 종료
        if (k == M + 1) {
            for (int i = 1; i <= M; i++){
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
        } else {
            for (int cand = 1; cand <= N; cand++) {
                selected[k] = cand;
                rec_func(k + 1);
                selected[k] = 0;
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

        public FastReader(String s) throws FileNotFoundException {
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
