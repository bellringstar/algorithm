package bruteforce;
import java.io.*;
import java.util.*;
public class boj15649 {

    static int N, M;
    static int[] selected;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        M = scan.nextInt();
        selected = new int[M+1];
        visited = new boolean[N+1];
    }

    static void rec_func(int k) {
        if (k == M+1) {
            for (int i = 1; i < M+1; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
        } else {
            //중복은 허용하지 않는다 => 방문 기록을 저장하자.
            for (int cand = 1; cand < N+1; cand++) {
                if (visited[cand]) {
                    continue;
                }
                selected[k] = cand;
                visited[cand] = true;
                rec_func(k+1);
                visited[cand] = false;
            }
        }
    }


    public static void main(String[] args){
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

        public FastReader(String s) throws FileNotFoundException{
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try{
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
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
