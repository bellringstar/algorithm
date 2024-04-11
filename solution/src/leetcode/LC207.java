package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC207 {
	/*
	prerequisites[i] = [ai, bi] a를 들으려면 b부터 들어야한다.
	numCourses개의 코스를 들을 수 있다면 true, 없다면 false
	 */

	public static void main(String[] args) {

		class Solution {
			public boolean canFinish(int numCourses, int[][] prerequisites) {
				Map<Integer, List<Integer>> courseMap = new HashMap<>();
				for (int[] course : prerequisites) {
					courseMap.putIfAbsent(course[0], new ArrayList<>());
					courseMap.get(course[0]).add(course[1]);
				}

				List<Integer> takes = new ArrayList<>();
				List<Integer> taken = new ArrayList<>();
				for (Integer finish : courseMap.keySet()) {
					if (!dfs(courseMap, finish, takes, taken)) {
						return false;
					}
				}
				return true;
			}

			public boolean dfs(Map<Integer, List<Integer>> courseMap, Integer finish, List<Integer> takes,
				List<Integer> taken) {

				if (takes.contains(finish)) {
					return false;
				}

				if (taken.contains(finish)) {
					return true;

				}

				if (courseMap.containsKey(finish)) {
					takes.add(finish);

					for (Integer take : courseMap.get(finish)) {
						if (!dfs(courseMap, take, takes, taken)) {
							return false;
						}
					}

					takes.remove(finish);

					taken.add(finish);
				}
				return true;
			}
		}

		class Solution2 {
			public boolean canFinish(int numCourses, int[][] prerequisites) {
				Map<Integer, List<Integer>> graph = buildGraph(numCourses, prerequisites);
				int[] visited = new int[numCourses];

				for (int course = 0; course < numCourses; course++) {
					if (visited[course] == 0 && hasCycle(graph, visited, course)) {
						return false;
					}
				}

				return true;
			}

			private Map<Integer, List<Integer>> buildGraph(int numCourses, int[][] prerequisites) {
				Map<Integer, List<Integer>> graph = new HashMap<>();

				for (int[] course : prerequisites) {
					graph.putIfAbsent(course[1], new ArrayList<>());
					graph.get(course[1]).add(course[0]);
				}

				return graph;
			}

			private boolean hasCycle(Map<Integer, List<Integer>> graph, int[] visited, int course) {
				if (visited[course] == 1) {
					return true;
				}

				if (visited[course] == 2) {
					return false;
				}

				visited[course] = 1;

				for (int neighbor : graph.getOrDefault(course, new ArrayList<>())) {
					if (hasCycle(graph, visited, neighbor)) {
						return true;
					}
				}

				visited[course] = 2;

				return false;
			}
		}

	}
}
