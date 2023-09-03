import java.util.*;
import java.io.*;

public class Scan {

    BufferedReader br;
    StringTokenizer st;

   public Scan() {
       br = new BufferedReader(new InputStreamReader(System.in));
   }

   public Scan(String s) throws FileNotFoundException{
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