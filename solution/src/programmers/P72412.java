package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class P72412 {
	class Solution {
		public int[] solution(String[] info, String[] query) {

			Map<String, List<Integer>> scoresMap = buildScoresMap(info);
			int[] answer = new int[query.length];

			for (int i = 0; i < answer.length; i++) {
				answer[i] = count(query[i], scoresMap);
			}

			return answer;
		}

		private int count(String query, Map<String, List<Integer>> scoresMap) {
			String[] tokens = query.split(" (and )?");
			String key = String.join("", Arrays.copyOf(tokens, tokens.length - 1));

			if (!scoresMap.containsKey(key)) return 0;
			List<Integer> scores = scoresMap.get(key);

			int score = Integer.parseInt(tokens[tokens.length - 1]);

			return scores.size() - binarySearch(score, scoresMap.get(key));
		}

		private int binarySearch(int score, List<Integer> scores) {
			int start = 0;
			int end = scores.size() - 1;

			while (end > start) {
				int mid = (start + end) / 2;

				if (scores.get(mid) >= score) {
					end = mid;
				} else {
					start = mid + 1;
				}
			}

			if (scores.get(start) < score) {
				return scores.size();
			}
			return start;
		}

		private Map<String, List<Integer>> buildScoresMap(String[] info) {
			Map<String, List<Integer>> scoresMap = new HashMap<>();

			for (String s : info) {
				String[] tokens = s.split(" ");
				int score = Integer.parseInt(tokens[tokens.length - 1]);
				forEachKey(0, "", tokens, key -> {
					scoresMap.putIfAbsent(key, new ArrayList<>());
					scoresMap.get(key).add(score);
				});
			}

			for (List<Integer> list : scoresMap.values()) {
				Collections.sort(list);
			}



			return scoresMap;
		}

		private void forEachKey(int index, String prefix, String[] tokens, Consumer<String> action) {
			if (index == tokens.length - 1) {
				action.accept(prefix);
				return;
			}

			forEachKey(index + 1, prefix + tokens[index], tokens, action);
			forEachKey(index + 1, prefix + "-", tokens, action);
		}
	}

	/*
언어,직군,경력,소울푸드로 나올 수 있는 조합 = 3 * 2* 2 * 2 = 24개
거기에 이 분류들으 '-' 를 포함할 수 있음 -> 4 * 3 * 3 * 3 = 108개
=> 미리 조합을 만들어 놓고 거기에 점수를 넣는 형태
그 후 쿼리를 보며 해당 조합을 key로 하는 List<Integer> 점수 리스트에서
파라메트릭 서치
X점 이상인 사람 중 최소 점수 [start, end]

1. 조합을 생성 (현재조합, 다음선택지)
*/
	class Solution2 {

		static final Map<String, List<Integer>> infoMap = new HashMap<>();

		static class Query {
			String key;
			int score;

			public Query(String key, int score) {
				this.key = key;
				this.score = score;
			}
		}

		public int[] solution(String[] infos, String[] queries) {
			for (String info : infos) {
				recFunc(0, "", info.split(" "));
			}

			for (List<Integer> values : infoMap.values()) {
				Collections.sort(values);
			}

			int[] answer = new int[queries.length];
			// query에서 key를 꺼낸 뒤 파라메트릭 서치 후 answer에 정답 추가
			for (int i = 0; i < queries.length; i++) {
				Query query = getQuery(queries[i]);
				String key = query.key;
				int target = query.score;
				if (infoMap.getOrDefault(key, new ArrayList<>()).isEmpty()) {
					answer[i] = 0;
					continue;
				}
				List<Integer> scores = infoMap.get(key);
				int count = binarySearch(scores, target);
				answer[i] = count;
			}
			return answer;
		}

		private Query getQuery(String query) {
			String[] q = query.split(" "); // java, and, backend, and, junior, and, pizza, 100
			int score = Integer.parseInt(q[q.length - 1]);
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < q.length - 1; i++) {
				if (!q[i].equals("and")) {
					sb.append(q[i]);
				}
			}

			return new Query(sb.toString(), score);
		}


		private void recFunc(int depth, String curr, String[] info) {

			if (depth == info.length - 1) {
				infoMap.putIfAbsent(curr, new ArrayList<>());
				infoMap.get(curr).add(Integer.parseInt(info[info.length - 1]));
				return;
			}

			recFunc(depth+1, curr + info[depth], info);
			recFunc(depth+1, curr + "-", info);
		}

		private int binarySearch(List<Integer> scores, int target) {

			int start = 0;
			int end = scores.size() - 1;

			while (start < end) {
				int mid = (start + end) / 2;

				if (scores.get(mid) >= target) {
					end = mid;
				} else {
					start = mid + 1;
				}
			}
			if (scores.get(start) >= target) {
				return scores.size() - start;
			}
			return 0;
		}
	}
}
