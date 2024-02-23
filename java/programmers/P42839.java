package programmers;

import java.util.HashSet;
import java.util.Set;

public class P42839 {

	/*
	만들수있는 소수의 개수
	ex) numbers = "011" -> 0, 1, 1 을 조합 해 만들 수 있는 소수는 몇개인가
	11, 101 -> 2개
	numbers는 1이상 7이하의 길이
	0~9사이 숫자

	7개 -> 최대 7!경우의수 전부 반복하며 확인해도 무제없다.

	재귀를 통해 모든 조합을 찾는다.
	1. 상태 : 지금까지 만든 숫자, 거기에 이어붙일 numbers (acc, numbers)
	2. 종료조건 : (acc, 0) 모든 numbers를 사용  -> acc가 소수 혹은 아니다
	3. 점화식
	 */
	class Solution {
		public int solution(String nums) {
			Set<Integer> primes = new HashSet<>();
			int[] numbers = nums.chars().map(c -> c - '0').toArray();
			getPrimes(0, numbers, primes, new boolean[numbers.length]);
			return primes.size();
		}

		private void getPrimes(int acc, int[] numbers, Set<Integer> primes, boolean[] isUsed) {

			if (isPrime(acc))
				primes.add(acc);

			for (int i = 0; i < numbers.length; i++) {
				if (isUsed[i])
					continue;
				int nextAcc = acc * 10 + numbers[i];
				isUsed[i] = true;
				getPrimes(nextAcc, numbers, primes, isUsed);
				isUsed[i] = false;
			}

		}

		private boolean isPrime(int n) {
			if (n <= 1)
				return false;
			for (int i = 2; i * i <= n; i++) {
				if (n % i == 0)
					return false;
			}
			return true;
		}
	}
}
