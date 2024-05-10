package programmers;

public class P68936 {

	/*
	압축 -> 동일 과정 반복
	범위 내의 값이 모두 동일하다 = 1개로 압축 ==> 종료조건
	변화하는 것 = offsetX, offsetY, size 각 사각형의 시작 좌표, 길이 => 이 때 0의 개수 및 1의 개수
	(offsetX, offsetY, size) = (offsetX, offsetY, size/2)+(offsetX + size/2, offsetY, size/2) + (offsetX, offsetY + size/2, size/2) + (offsetX + size/2, offsetY + size/2, size/2)
	*/
	class Solution {

		//0과 1의 개수를 저장할 클래스
		static class Count {
			int zero;
			int one;

			public Count(int zero, int one) {
				this.zero = zero;
				this.one = one;
			}

			//누적 합을 위한 메서드
			public Count add(Count o) {
				return new Count(zero + o.zero, one + o.one);
			}
		}

		private Count count(int offsetX, int offsetY, int size, int[][] arr) {
			// 내부에 다른 값이 있으면 쪼개서 더 들어가야한다.
			int h = size/2;
			for (int y = offsetY; y < offsetY + size; y++) {
				for (int x = offsetX; x < offsetX + size; x++) {
					if (arr[y][x] != arr[offsetY][offsetX]) {
						return count(offsetX, offsetY, h, arr)
							.add(count(offsetX + h, offsetY, h, arr))
							.add(count(offsetX, offsetY + h, h, arr))
							.add(count(offsetX + h, offsetY + h, h, arr));
					}
				}
			}

			// 내부 값이 전부 동일할 때
			if (arr[offsetY][offsetX] == 1) {
				return new Count(0, 1);
			}
			return new Count(1, 0);
		}

		public int[] solution(int[][] arr) {

			Count c = count(0, 0, arr.length, arr);

			int[] answer = {c.zero, c.one};
			return answer;
		}
	}
}
