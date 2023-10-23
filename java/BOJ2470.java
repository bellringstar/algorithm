import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2470 {

    //합을 0에 가깝게 -> 범위 아니 왜 틀린거냐고
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] values;
    static int sum;
    static int[] answer;

    static void input() {
        sum = Integer.MAX_VALUE;
        N = scan.nextInt();
        values = new int[N+1];
        for (int i = 1; i <= N; i++) {
            values[i] = scan.nextInt();
        }
        Arrays.sort(values,1, N+1);
        answer = new int[2];
    }


    // target미만인 것 중 가장 큰 것의 인덱스를 찾고 그 idx, idx+1 중 target에 가까운 것을 리턴.
    static int find(int[] values, int l, int r, int target) {
        int lastIdx = l+1;
        while (l <= r){
            int mid = (l + r) / 2;
            if (target >= values[mid]) {
                lastIdx = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        if (lastIdx > 0 && lastIdx + 1 <= N && Math.abs(values[lastIdx+1] - target) < Math.abs(values[lastIdx] - target)) {
            lastIdx++;
        }

        return lastIdx;
    }

    static void pro() {
        for (int i = 1; i <= N-1; i++) {
            int target = -values[i];
            int idx = find(values, i, N, target);
            if (Math.abs(values[idx] + values[i]) < sum) {
                sum = Math.abs(values[idx] + values[i]);
                answer[0] = values[i];
                answer[1] = values[idx];
            }
        }
    }




    public static void main(String[] args) {
        input();
        pro();
        Arrays.sort(answer);
        sb.append(answer[0]).append(" ").append(answer[1]);
        System.out.println(sb.toString());
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
