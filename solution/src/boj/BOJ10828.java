package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ10828 {

    static FastReader scan = new FastReader();
    static Stack stack;
    static int N;
    public static void input() {
        N = scan.nextInt();
        stack = new Stack(N);
    }

    public static void main(String[] args) {
        input();
        for (int i = 0; i < N; i++) {
            String command = scan.next();
            int num = 0;
            if (command.equals("push")) {
                num = scan.nextInt();
            }
            if (command.equals("push")) {
                stack.push(num);
            } else if (command.equals("pop")) {
                System.out.println(stack.pop());
            } else if (command.equals("size")) {
                System.out.println(stack.size());
            } else if (command.equals("empty")) {
                System.out.println(stack.empty());
            } else if (command.equals("top")) {
                System.out.println(stack.top());
            }
        }
    }

    static class Stack {
        private int top = -1;
        private int[] stack;

        public Stack(int n) {
            this.stack = new int[n];
        }

        public void push(int x) {
            stack[++top] = x;
        }

        public int pop() {
            if (top == -1) {
                return -1;
            }
            return stack[top--];
        }

        public int size() {
            return top + 1;
        }

        public int empty() {
            return top == -1 ? 1 : 0;
        }

        public int top() {
            if (top == -1) {
                return -1;
            }
            return stack[top];
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
    }
}
