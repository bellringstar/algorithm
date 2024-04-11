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
}
