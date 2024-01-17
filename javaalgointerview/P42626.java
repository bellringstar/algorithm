import java.util.PriorityQueue;

public class P42626 {
	/*
	모든 음식의 스코빌 지수를 K이상으로
	섞은 음식 스코빌 = 가장 낮은 스코빌 지수 + (두 번째로 낮은 스코빌 * 2)

	일단 scoville을 낮은 순으로 정렬
	앞의 두개를 꺼내서 조합 한 뒤 삽입 후 재정렬
	가장 작은게 K 이상인가? -> 횟수 리턴
	k이보다 낮다 -> 다시 반복
	남은 음식이 1개인데 k보다 낮은 상태 = -1 리턴
	 */
	class Solution {
		public int solution(int[] scoville, int K) {
			int answer = 0;
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			for (int point : scoville) {
				pq.add(point);
			}
			while (pq.size() > 1) {
				if (pq.peek() >= K) {
					return answer;
				}
				int lowestPoint = pq.poll();
				int secondLowPoint = pq.poll();
				int newScoville = lowestPoint + secondLowPoint *2;
				pq.add(newScoville);
				answer++;
			}
			if (pq.size() == 1 && pq.peek() >= K) {
				return answer;
			}

			return -1;
		}
	}
}
