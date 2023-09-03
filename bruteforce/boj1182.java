package bruteforce;

import java.util.*;
import java.io.*;
/*
N개의 정수로 이루어진 수열 중 크기가 양수인 부분수열 중 원소의 합이 S가 되는 경우의 수
N 최대 20 -> 부분집합 개수 2^20 = 2^6 시간 문제 업음, int 21억 범위 내 값만 존재
*/
public class boj1182 {

    static FastReader scan = new FastReader();
    static int N, S, ans;
    static int[] nums;

    static void input() {
        N = scan.nextInt();
        S = scan.nextInt();
        nums = new int[N+1];
        for (int i = 1; i <= N; i++) {
            nums[i] = scan.nextInt();
        }
    }

    static void rec_func(int k, int sum) {
        if (k == N + 1) {
            if (sum == S) {
                ans++;
            }
        }
        else {
            rec_func(k+1, sum + nums[k]);
            rec_func(k+1, sum);
        }
    }

    public static void main(String[] args) {
        input();
        rec_func(1, 0);
        if (S == 0) {
            ans--;
        }
        System.out.println(ans);
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
                str = br. readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

    }

}