package programmers;

public class P42842 {

	class Solution {
		public int[] solution(int brown, int yellow) {

			for (int w = 3; w <= 5000; w++) {
				for (int h = 3; h <= w; h++) {
					int boundary = (w + h - 2) * 2;
					int center = w * h - boundary;
					if (brown == boundary && center == yellow) {
						return new int[] {w, h};
					}
				}
			}
			return null;
		}
	}
}
