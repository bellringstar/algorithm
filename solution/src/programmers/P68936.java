package programmers;

public class P68936 {

	/*
	1. 상태변수
	사각형의 사이즈 -> 시작위치 + 가로세로 길이 -> offsetX, offsetY, size
	2. 종료조건
	모든 값이 1 혹은 0으로 동일 할 때
	3. 점화식
	(offsetX, offsetY, size) = (offsetX, offsetY, size/2) + (offsetX + size/2, offsetY, size/2)
	+ (offsetX, offsetY + size/2, size/2) + ((offsetX +size/2, offsetY + size/2, size/2)

	 */

	class Solution {

		static class Count {
			private final int zero;
			private final int one;

			public Count(int zero, int one) {
				this.zero = zero;
				this.one = one;
			}

			public Count add(Count other) {
				return new Count(zero + other.zero, one + other.one);
			}
		}

		public int[] solution(int[][] arr) {
			Count count = count(0, 0, arr.length, arr);
			return new int[] {count.zero, count.one};
		}

		public Count count(int offsetX, int offsetY, int size, int[][] arr) {

			int h = size / 2;

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

			if (arr[offsetY][offsetX] == 1) {
				return new Count(0, 1);
			}
			return new Count(1, 0);

		}
	}
}
