package bruteforce;
import java.util.*;
import java.io.*;
public class boj15652 {

    /*
    1~N까지 자연수 중에서 M개를 고른 수열
    중복 가능
    비내림차순 -> a[i] <= a[i+1]
     */
    static int N, M;
    static int[] selected;

    static StringBuilder sb = new StringBuilder();
    static void input(){
        FastReader scan = new FastReader();
        N = scan.nextInt();
        M = scan.nextInt();
        selected = new int[M+1];
    }

    static void rec_func(int k) {
        // depth가 M이다 = 완성
        if (k == M+1) {
            for (int i = 1; i < M+1; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
        } else {
            // 중복허용하면서 오름차순
            for (int cand = 1; cand < N+1; cand++) {
                selected[k] = cand;
                if (selected[k-1] > selected[k]){
                    continue;
                }
                rec_func(k+1);
                selected[k] = 0;
            }
        }
    }

    static void rec_func_solution(int k) {
        if (k == M + 1) {
            for (int i = 1; i < M+1; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
        } else {
            int start = selected[k-1];
            if (start == 0) {
                start = 1;
            }
            for (int cand = start; cand <= N; cand++) {
                selected[k] = cand;
                rec_func_solution(k + 1);
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

        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException{
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next(){
            while(st == null || !st.hasMoreElements()){
                try{
                    st = new StringTokenizer(br.readLine());
                } catch(IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt(){
            return Integer.parseInt(next());
        }

        long nextLong(){
            return Long.parseLong(next());
        }

        double nextDouble(){
            return Double.parseDouble(next());
        }

        String nextLine(){
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
