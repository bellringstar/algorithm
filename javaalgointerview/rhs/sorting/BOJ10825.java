package rhs.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ10825 {

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

	static int N;
	static Student[] students;

	static class Student {
		String name;
		int korean;
		int english;
		int math;
	}

	static void input() {
		N = scan.nextInt();
		students = new Student[N];
		for (int i = 0; i < N; i++) {
			students[i] = new Student();
			students[i].name = scan.next();
			students[i].korean = scan.nextInt();
			students[i].english = scan.nextInt();
			students[i].math = scan.nextInt();
		}
	}

	static void pro() {
		Arrays.sort(students, (o1, o2) -> {
			if (o1.korean != o2.korean) {
				return o2.korean - o1.korean;
			}
			if (o1.english != o2.english) {
				return o1.english - o2.english;
			}
			if (o1.math != o2.math) {
				return o2.math - o1.math;
			}
			return o1.name.compareTo(o2.name);
		});

		for (Student s : students) {
			sb.append(s.name).append('\n');
		}
	}

	public static void main(String[] args) {
		input();
		pro();
		System.out.println(sb);
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
