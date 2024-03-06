import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P49190 {

	class Solution {

		private static class Vertex {
			private final int x;
			private final int y;
			private final String id;
			private final Set<String> connectedVertices = new HashSet<>();

			public Vertex(int x, int y) {
				this.x = x;
				this.y = y;
				this.id = id(x, y);
			}

			private static String id(int x, int y) {
				return String.format("(%d, %d)", x, y);
			}
		}

		private final int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
		private final int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

		public int solution(int[] arrows) {
			int count = 0;

			Map<String, Vertex> vertices = new HashMap<>();
			Vertex v = new Vertex(0, 0);
			vertices.put(v.id, v);

			for (int d : arrows) {
				for (int i = 0; i < 2; i++) {
					int x = v.x + dx[d];
					int y = v.y + dy[d];
					String id = Vertex.id(x, y);

					if (!vertices.containsKey(id)) {
						vertices.put(id, new Vertex(x, y));
					} else if (!v.connectedVertices.contains(id)) {
						count++;
					}

					Vertex u = vertices.get(id);
					v.connectedVertices.add(u.id);
					u.connectedVertices.add(v.id);
					v = u;
				}
			}
			return count;
		}
	}
}
