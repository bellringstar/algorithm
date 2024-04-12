package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class P72411 {

	class Solution {
		public String[] solution(String[] orders, int[] course) {
			List<Set<String>> orderList = Arrays.stream(orders)
				.map(String::chars)
				.map(charStream ->
					charStream.mapToObj(menu -> String.valueOf((char) menu))
						.collect(Collectors.toSet())
				).collect(Collectors.toList());

			Map<Integer, List<Course>> courses = new HashMap<>();
			for (int length : course) {
				List<Course> list = new ArrayList<>();
				list.add(new Course("", 0));
				courses.put(length, list);
			}

			getCourses('A', new HashSet<>(), orderList, courses);

			return courses.values().stream()
				.filter(list -> list.get(0).occurrences > 0)
				.flatMap(List::stream)
				.map(c -> c.course)
				.sorted()
				.toArray(String[]::new);

		}


		private void getCourses(char nextMenu, Set<String> selectedMenus,List<Set<String>> orderList, Map<Integer, List<Course>> courses) {
			int occurrences = (int) orderList.stream()
				.filter(order -> order.containsAll(selectedMenus))
				.count();

			if (occurrences < 2) return;

			int size = selectedMenus.size();
			if (courses.containsKey(size)) {
				List<Course> courseList = courses.get(size);
				Course course = new Course(selectedMenus.stream()
					.sorted()
					.collect(Collectors.joining("")), occurrences);
				Course original = courseList.get(0);
				if (original.occurrences < occurrences) {
					courseList.clear();
					courseList.add(course);
				} else if (original.occurrences == occurrences) {
					courseList.add(course);
				}
			}

			if (size >= 10) return;
			for (char menuChar = nextMenu; menuChar <= 'Z'; menuChar++) {
				String menu = String.valueOf(menuChar);
				selectedMenus.add(menu);
				getCourses((char) (menuChar + 1), selectedMenus, orderList, courses);
				selectedMenus.remove(menu);
			}


		}

		private static class Course {
			public final String course;
			public final int occurrences;

			public Course(String course, int occurrences) {
				this.course = course;
				this.occurrences = occurrences;
			}
		}
	}

	/*
단품 메뉴들을 조합해 새로운 코스를 만들자, 코스는 최소 2개 이상의 단품으로/최소 2명 이상이 주문한 단품메뉴조합만 코스 후보
해당 조합이 2번 이상 주문됐는지 확인 필요
가장 많이 주문된 메뉴 구성을 저장. 여러개면 모두 -> List로 관리, 갱신

1. 모든 단품을 저장한다. [A, B, C, D, E, F, G, H];
2. 단품들의 조합을 재귀를 토해 만든다. A, AB, ABC...
3. orders를 순회하면서 해당 조합의 등장 횟수가 2번 이상인지 확인하다.
*/
	class Solution2 {

		static class Course {
			String course;
			int occurrence;

			public Course(String course, int occurrence) {
				this.course = course;
				this.occurrence = occurrence;
			}

			public String toString() {
				return course;
			}
		}

		private void generateCourse(int depth, Set<String> curr, List<String> menus, List<Set<String>> orderList, Map<Integer, List<Course>> courseMap) {
			// orderList를 순회하며 현재 curr 조합이 총 몇 번 나왔는가.
			int occurrence = (int)orderList.stream()
				.filter(orders -> orders.containsAll(curr))
				.count();

			if (occurrence < 2) return; //이미 2회 미만이면 더 추가해도 2보다 클 수 없다.
			int size = curr.size(); // 코스 길이
			if (size > 10) return;

			if (courseMap.containsKey(size)) {
				// 해당 코스 길이를 원한다.
				List<Course> courses = courseMap.get(size);
				String name = curr.stream().sorted().collect(Collectors.joining());
				Course course = new Course(name, occurrence);
				if (courses.size() == 0) {
					courses.add(course);
				} else {
					if (courses.get(0).occurrence < occurrence) {
						courses.clear();
						courses.add(course);
					} else if (courses.get(0).occurrence == occurrence) {
						courses.add(course);
					}
				}
			}

			// 다음 curr 생성;
			for (int i = depth; i < menus.size(); i++) {
				curr.add(menus.get(i));
				generateCourse(i + 1, curr, menus, orderList, courseMap);
				curr.remove(menus.get(i));
			}
		}

		public String[] solution(String[] orders, int[] course) {
			Set<String> menu = new HashSet<>();
			Map<Integer, List<Course>> courseMap = new HashMap<>();
			for (String order : orders) {
				for(String m : order.split("")) {
					menu.add(m);
				}
			}
			List<String> menus = menu.stream().sorted().collect(Collectors.toList());
			for (int c : course) {
				courseMap.put(c, new ArrayList<>());
			}

			List<Set<String>> orderList = Arrays.stream(orders)
				.map(m -> Arrays.stream(m.split("")).collect(Collectors.toSet()))
				.collect(Collectors.toList());

			generateCourse(0, new HashSet<>(), menus, orderList, courseMap);

			List<String> result = new ArrayList<>();

			for (List<Course> courses : courseMap.values()) {
				for (Course c : courses) {
					result.add(c.course);
				}
			}
			return result.stream().sorted().toArray(String[]::new);
		}
	}

	class Solution3 {
		private static  Map<Integer, Map<String, Integer>> courseMap;

		public String[] solution(String[] orders, int[] course) {
			courseMap = new HashMap<>();
			for (int i : course) {
				courseMap.put(i, new HashMap<>());
			}

			for (String order : orders) {
				char[] orderArray = order.toCharArray();
				Arrays.sort(orderArray);
				combination(0, orderArray, "");
			}

			List<String> answer = new ArrayList<>();
			for (Map<String, Integer> count : courseMap.values()) {
				count.values()
					.stream()
					.max(Comparator.comparingInt(o -> o))
					.ifPresent(cnt -> count.entrySet().stream()
						.filter(entry -> cnt.equals(entry.getValue()) && cnt > 1)
						.forEach(entry -> answer.add(entry.getKey())));
			}
			Collections.sort(answer);
			return answer.toArray(new String[0]);
		}

		public static void combination(int idx, char[] order, String result) {
			if (courseMap.containsKey(result.length())) {
				Map<String, Integer> map = courseMap.get(result.length());
				map.put(result, map.getOrDefault(result, 0) + 1);
			}

			for (int i = idx; i < order.length; i++) {
				combination(i + 1, order, result + order[i]);
			}
		}
	}
}
