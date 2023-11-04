import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ13144 {

    static FastReader scan = new FastReader();

    static int N;
    static int[] nums, cnt;

    static void input() {
        N = scan.nextInt();
        nums = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            nums[i] = scan.nextInt();
        }
        cnt = new int[100000 + 1];
    }

    static void prod() {
        long ans = 0;

        for (int L = 1, R = 0; L <= N; L++) {
            // R이 이동가능한곳까지 이동
            while (R + 1 <= N && cnt[nums[R + 1]] == 0) {
                R++;
                cnt[nums[R]]++;
            }

            ans += R - L + 1;
            cnt[nums[L]]--;
        }
    }


    public static void main(String[] args) {
        input();
        prod();
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
