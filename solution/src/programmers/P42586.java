package programmers;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P42586 {

	class Solution {
		public int[] solution(int[] progresses, int[] speeds) {
			Queue<Integer> q = new LinkedList<>();
			for (int i = 0; i < progresses.length; i++) {
				q.add(i);
			}
			int days = 0;
			int count = 0;
			List<Integer> results = new ArrayList<>();

			while (!q.isEmpty()) {
				int index = q.poll();
				int expiration = (int) Math.ceil((double) (100 - progresses[index] / speeds[index]));

				if (expiration > days) {
					if (days != 0) {
						results.add(count);
						count = 0;
					}
					days = expiration;
				}
				count++;
			}
			results.add(count);

			return results.stream().mapToInt(Integer::intValue).toArray();
		}
	}

	class Solution2 {
		public int[] solution(int[] progresses, int[] speeds) {
			Queue<Integer> answer = new ArrayDeque<>();

			int n = progresses.length;
			int[] daysLeft = new int[n];
			for (int i = 0; i < n; i++) {
				daysLeft[i] = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
			}

			int cnt = 0;
			int maxDay = daysLeft[0];

			for (int i = 0; i < n; i++) {
				if (daysLeft[i] <= maxDay) {
					cnt++;
				} else {
					answer.add(cnt);
					cnt = 1;
					maxDay = daysLeft[i];
				}
			}

			answer.add(cnt);
			return answer.stream().mapToInt(Integer::intValue).toArray();
		}
	}
}
