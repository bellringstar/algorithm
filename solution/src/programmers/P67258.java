import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class P67258 {
	/*
	모든 종류의 보석을 포함하는 가장 짧은 구간
	윈도우의 크기를 줄여가며 해당 범위 set이 원본 set과 일치하는지 확인
	일치하면 해당 위치 갱신(해당 사이즈의 최초)
	윈도우 사이즈가 원본 set의 크기보다 작으면 더 이상 확인할필요가 없다.
	------------------------
	구간의 시작점과 끝점을 하나씩 옮겨가며 포함된 보석을 구한다.
	시작점이 이동 -> 구간이 작아진다 -> 이미 구간에 모든 보석이 포함된 상황에서 답을 찾기 위해\
	끝점이 이동 -> 구간이 넓ㅅ어진다 -> 구간에 모든 보석이 포함된게 아니다
	 */

	class Solution {
		public int[] solution(String[] gems) {

			int start = 0;
			int end = gems.length - 1;

			Set<String> gemSet = new HashSet<>(List.of(gems));

			Map<String, Integer> includes = new HashMap<>();

			int s = 0;
			int e = s;
			includes.put(gems[s], 1);

			while (s < gems.length) {
				if (includes.keySet().size() == gemSet.size()) {
					// 모두 포함 -> 갱신 및 s 증가
					if (e - s < end - start) {
						start = s;
						end = e;
					}

					includes.put(gems[s], includes.get(gems[s]) - 1);
					if (includes.get(gems[s]) == 0) {
						includes.remove(gems[s]);
					}
					s++;
				} else if (e < gems.length - 1) {
					// 부족 -> e 증가
					e++;
					includes.put(gems[e], includes.getOrDefault(gems[e], 0) + 1);
				} else {
					break;
				}
			}

			return new int[]{start + 1, end + 1};

		}
	}
}
