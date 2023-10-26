import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


public class BOJ1764 {
    static FastReader scan = new FastReader();
    static List<String> answer = new ArrayList<>();

    static int N, M, cnt;
    static String[] A;

    static void input() {
        cnt = 0;
        N = scan.nextInt();
        M = scan.nextInt();
        A = new String[N+1];
        for (int i =1 ; i<=N; i++) {
            A[i] = scan.next();
        }
        Arrays.sort(A, 1, N+1);
    }

    static void binarySearch(String[] A, int left, int right, String target) {
        while (left <= right) {
            int mid = (left + right) /2;
            if (A[mid].equals(target)){
                cnt++;
                answer.add(target);
                return;
            }
            if (A[mid].compareTo(target) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
     }

    public static void main(String[] args) {
        input();
        for (int i = 1; i <= M; i++) {
            String target = scan.next();
            binarySearch(A, 1, N, target);
        }
        Collections.sort(answer);
        System.out.println(cnt);
        for (String ans : answer) {
            System.out.println(ans);
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
