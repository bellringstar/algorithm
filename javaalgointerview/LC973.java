import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class LC973 {
	/*
	points[i] = [xi,yi], 원점으로 부터 가까운 순으로 k개 리턴
	int[][] : 거리 로 Map에 집어넣고 거리순으로 정렬. 그 후 앞에서부터 k개 리턴?
	 */
	class Solution {
		public int[][] kClosest(int[][] points, int k) {
			List<int[]> answer = new ArrayList<>();
			Map<int[], Double> distanceMap = new HashMap<>();
			for (int[] point : points) {
				distanceMap.put(point, calculateDistance(point));
			}
			List<Map.Entry<int[], Double>> entryList = new ArrayList<>(distanceMap.entrySet());
			Collections.sort(entryList, Map.Entry.comparingByValue());
			for (int i = 0; i < k; i++) {
				answer.add(entryList.get(i).getKey());
			}
			return answer.toArray(new int[0][0]);
		}

		private double calculateDistance(int[] point) {
			int x = point[0], y = point[1];
			return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
		}

		public int[][] kClosest2(int[][] points, int k) {
			PriorityQueue<Point> pq = new PriorityQueue<>(Comparator.comparingDouble(a -> a.distance));

			for (int[] point : points) {
				double distance = Math.pow(point[0], 2) + Math.pow(point[1], 2);
				pq.add(new Point(distance, point));
			}

			int[][] results = new int[k][];
			for (int i = 0; i < k; i++) {
				results[i] = pq.poll().point;
			}

			return results;
		}
	}

	static class Point {
		double distance;
		int[] point;

		public Point(double distance, int[] point) {
			this.distance = distance;
			this.point = point;
		}
	}
}
