package bruteforce;

import java.util.*;
import java.io.*;
/*
L개의 알파벳, 최소 1개의 모음, 최소 2개의 자음
암호는 정렬된 상태 즉 abc는 가능 bac 불가능
C개의 알파벳에서 암호의 가능성이 있는 모든 암호들
최대 15개 -> 15! 가능성 -> 약 20억가지
 */
public class boj1759 {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int L, C;
    static char[] alphabet;
    static int[] selected;

    static void input() {
        L = scan.nextInt();
        C = scan.nextInt();
        String[] token = scan.nextLine().split(" ");
        alphabet = new char[C+1];
        for (int i = 1; i <= C; i++) {
            alphabet[i] = token[i-1].charAt(0);
        }
        selected = new int[L+1];
        Arrays.sort(alphabet,1,C+1);
    }

    static boolean isVowel(char c) {
        return c == 'a' || c =='e' || c == 'i' || c == 'o' || c =='u';
    }

    static void rec_func(int k) {
        if (k == L+1) {
            int vowel = 0, consonant = 0;
            for (int i = 1; i <= L; i++) {
                if (isVowel(alphabet[selected[i]])) {
                    vowel++;
                } else {
                    consonant++;
                }
            }
            if (vowel >=1 && consonant >= 2) {
                for (int i = 1; i <= L; i++) {
                    sb.append(alphabet[selected[i]]);
                }
                sb.append('\n');
            }

        } else {
            for (int cand = selected[k-1]+1; cand <= C; cand++) {
                selected[k] = cand;
                rec_func(k+1);
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
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

}
