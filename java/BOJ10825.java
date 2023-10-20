import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ10825 {

	static class Student {
		private String name;
		private int korean;
		private int english;
		private int math;

		public Student(String name, int korean, int english, int math) {
			this.name = name;
			this.korean = korean;
			this.english = english;
			this.math = math;
		}

	}

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();
	static int N;
	static List<Student> studentList;

	static void input() {
		N = scan.nextInt();
		studentList = new ArrayList<>(N);
		for (int i = 0; i < N; i++) {
			String[] s = scan.nextLine().split(" ");
			Student student = new Student(s[0], Integer.parseInt(s[1])
				, Integer.parseInt(s[2]), Integer.parseInt(s[3]));
			studentList.add(student);
		}
	}

	static void sortingList(List<Student> studentList) {
		studentList.sort((s1, s2) -> {
			if (s1.korean != s2.korean) {
				return s2.korean - s1.korean; // 내림차순
			}
			if (s1.english != s2.english) {
				return s1.english - s2.english; // 오름차순
			}
			if (s1.math != s2.math) {
				return s2.math - s1.math; // 내림차순
			}
			return s1.name.compareTo(s2.name);
		});
	}

	public static void main(String[] args) {
		input();
		sortingList(studentList);
		for (Student s : studentList) {
			sb.append(s.name).append('\n');
		}
		System.out.println(sb.toString());

	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		public FastReader(String s) throws FileNotFoundException {
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
