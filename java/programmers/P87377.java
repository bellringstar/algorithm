package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P87377 {

	/*
	교점을 구한다. -> n^2의 시간 -> 최대 1000개 시간 문제 없다.
	별을 포함한 최소 크기만 나타낸다 -> 교점을 다 구하고 가장 바깥 위치를 파악
	 */
	class Solution {

		public String[] solution(int[][] line) {
			List<Point> points = new ArrayList<>();
			for (int i = 0; i < line.length; i++) {
				for (int j = i + 1; j < line.length; j++) {
					Point intersection = intersection(line[i], line[j]);
					if (intersection != null) {
						points.add(intersection);
					}
				}
			}

			Point minimumPoint = getMinimum(points);
			Point maximumPoint = getMaximum(points);

			int width = (int)(maximumPoint.x - minimumPoint.x + 1);
			int height = (int)(maximumPoint.y - minimumPoint.y + 1);

			char[][] arr = new char[height][width];
			for (char[] row : arr) {
				Arrays.fill(row, '.');
			}

			String[] result = new String[arr.length];

			for (Point p : points) {
				int x = (int)(p.x - minimumPoint.x);
				int y = (int)(maximumPoint.y - p.y);
				arr[y][x] = '*';
			}

			for (int i = 0; i < result.length; i++) {
				result[i] = new String(arr[i]);
			}

			return result;
		}

		private Point getMinimum(List<Point> points) {
			long x = Long.MAX_VALUE;
			long y = Long.MAX_VALUE;

			for (Point p : points) {
				if (p.x < x)
					x = p.x;
				if (p.y < y)
					y = p.y;
			}

			return new Point(x, y);
		}

		private Point getMaximum(List<Point> points) {
			long x = Long.MIN_VALUE;
			long y = Long.MIN_VALUE;

			for (Point p : points) {
				if (p.x > x)
					x = p.x;
				if (p.y > y)
					y = p.y;
			}

			return new Point(x, y);
		}

		private Point intersection(int[] line1, int[] line2) {
			long A = line1[0];
			long B = line1[1];
			long E = line1[2];

			long C = line2[0];
			long D = line2[1];
			long F = line2[2];

			double x = (double)(B * F - E * D) / (A * D - B * C);
			double y = (double)(E * C - A * F) / (A * D - B * C);

			if (x % 1 != 0 || y % 1 != 0)
				return null;

			return new Point((long)x, (long)y);
		}

		static class Point {
			public final long x;
			public final long y;

			public Point(long x, long y) {
				this.x = x;
				this.y = y;
			}
		}
	}
}
