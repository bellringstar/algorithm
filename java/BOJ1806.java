import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1806 {

    static FastReader scan = new FastReader();
    static int N, S;
    static int[] nums;

    static void input() {
        N = scan.nextInt();
        S = scan.nextInt();
        nums = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            nums[i] = scan.nextInt();
        }
    }

    static void pro() {
        int sum = 0, j = 0, ans = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            sum -= nums[i - 1]; // 이전 숫자 제거

            while (j + 1 <= N && sum < S) {
                //j를 범위내에서 합이 S가 넘지 않느 동안 이동
                sum += nums[++j];
            }
            // j를 오른쪽으로 최대한 이동 후 합
            if (sum >= S) {
                ans = Math.min(ans, j - i + 1);
            }
        }
        if (ans == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(ans);
        }

    }


    public static void main(String[] args) {
        input();
        pro();
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
