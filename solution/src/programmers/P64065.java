package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P64065 {
	/*
	원소의 개수 오름 차순 정렬 후 1개의 원소씩 넣는다.
	-> 원소의 개수로 나누려면 문자열s를 잘 조작해야한다.
	*/
	class Solution {
		public int[] solution(String s) {
			List<Integer> answer = new ArrayList<>();
			s = s.replaceAll("\\{", "");
			s = s.substring(0, s.length()-2);
			String[] arr = s.split("},");
			Arrays.sort(arr, (s1, s2) -> {
				return Integer.compare(s1.length(), s2.length());
			});
			Set<Integer> set = new HashSet<>();

			for (String tuple : arr) {
				String[] elements = tuple.split(",");
				for (String e : elements) {
					int v = Integer.parseInt(e);
					if (set.contains(v)) continue;
					set.add(v);
					answer.add(v);
				}
			}

			return answer.stream().mapToInt(Integer::intValue).toArray();
		}
	}
}
