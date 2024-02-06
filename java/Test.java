import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Test {

	public static void main(String[] args) {
		List<String> list = List.of("apple", "banana", "kiwi");

		Optional<String> a = list.stream()
			.filter(e1 -> {
				System.out.println("filter() was called");
				return e1.contains("a");
			})
			.map(e1 -> {
				System.out.println("map() was called");
				return e1.toUpperCase();
			}).findAny();

		System.out.println(a.get());
	}

	static Map<Integer, List<Integer>> graph = new HashMap<>();

	public List<Integer> recursiveDfs(int v, List<Integer> discovered) {
		discovered.add(v);
		for (Integer w : graph.get(v)) {
			if (!discovered.contains(w)) {
				recursiveDfs(w, discovered);
			}
		}

		return discovered;
	}
}
