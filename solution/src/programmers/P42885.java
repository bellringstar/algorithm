package programmers;

import java.util.Arrays;

public class P42885 {
	/*
1회에 최대한 2명을 채워서 넣어야한다.
1. people 오름차순 정렬
2. 가장 가벼운 사람 + 가장 무거운 사람 <= limit == 태워 보낸다
3. >= limit 이면 가장 무거운 사람은 어차피 혼자 타야하며 다른 사람을 짝으로
*/
	class Solution {
		public int solution(int[] people, int limit) {
			Arrays.sort(people);
			int answer = 0;
			int l = 0;
			int r = people.length - 1;
			while (l <= r) {
				if (people[l] + people[r] <= limit) {
					l++;
				}
				r--;
				answer++;
			}
			return answer;
		}
	}
}
