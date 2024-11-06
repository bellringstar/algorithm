package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2749 {

    static final int MOD = 1_000_000;
    static final int PISANO_PERIOD = 1_500_000;
    static FastReader scan = new FastReader();
    static long N;

    static void input() {
        N = scan.nextLong();
    }

    static void solve() {
        N %= PISANO_PERIOD;
        long fibo = fibo(N);
        System.out.println(fibo);
    }

    static long fibo2(long n) {
        if (n <= 1) {
            return n;
        }

        Matrix base = new Matrix();
        base.arr = new long[][]{{1, 1}, {1, 0}};

        Matrix result = pow(base, n - 1);

        return result.arr[0][0];
    }

    static Matrix pow(Matrix base, long exp) {
        if (exp == 1) {
            return base;
        }

        Matrix half = pow(base, exp / 2);
        Matrix ret = half.multiply(half);

        if (exp % 2 == 1) {
            ret = ret.multiply(base);
        }

        return ret;
    }

    static long fibo(long n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        long prev = 0, curr = 1;
        for (long i = 2; i <= n; i++) {
            long tmp = curr;
            curr = (prev + curr) % MOD;
            prev = tmp;
        }
        return curr;
    }

    public static void main(String[] args) {
        input();
        solve();
    }

    static class Matrix {
        long[][] arr = new long[2][2];

        Matrix multiply(Matrix o) {
            Matrix ret = new Matrix();
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    for (int k = 0; k < 2; k++) {
                        ret.arr[i][j] += arr[i][k] * o.arr[k][j];
                        ret.arr[i][j] %= MOD;
                    }
                }
            }
            return ret;
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

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
