import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1806 {
    // 연속된 부분합 중 합이 S이상 이 되는 것 중 가장 짧은 것의 길이

    static FastReader scan = new FastReader();
    
    static int N, S;
    static int[] nums;
    
    static void input() {
        N = scan.nextInt();
        S = scan.nextInt();
        nums = new int[N+1];
        for (int i = 1; i <=N; i++) {
            nums[i] = scan.nextInt();
        }
    }

    public static void main(String[] args) {

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

        long nextLong() {
            return Long.parseLong(next());
        }

        String nextLind() {
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
