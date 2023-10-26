import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1920 {
    static FastReader scan = new FastReader();
    static int N, M;
    static int[] A, nums;

    static void input() {
        N = scan.nextInt();
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = scan.nextInt();
        }
        Arrays.sort(A,1,N+1);
        M = scan.nextInt();
        nums = new int[M + 1];
        for (int i = 1; i <= M; i++) {
            nums[i] = scan.nextInt();
        }
    }

    static void binarySearch(int[] A, int left, int right, int target) {
        int ans = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (A[mid] == target) {
                ans = 1;
                break;
            }
            if (A[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(ans);
    }


    public static void main(String[] args) {
        input();
        for (int i = 1; i<=M; i++) {
            int target= nums[i];
            binarySearch(A, 1, N, target);
        }
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

