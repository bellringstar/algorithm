import java.util.HashMap;

public class Test {

	static class MyObject {

		private int id;
		private String name;

		public MyObject(int id, String name) {
			this.id = id;
			this.name = name;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == this) {
				return true;
			}

			if (obj instanceof MyObject) {
				MyObject other = (MyObject)obj;

				return id == other.id && name.equals(other.name);
			}

			return false;
		}

		@Override
		public int hashCode() {
			return id;
		}

	}

	public static void main(String[] args) {
		MyObject object1 = new MyObject(1, "John Doe");
		MyObject object2 = new MyObject(1, "Jane Doe");

		System.out.println(object1.equals(object2));
		System.out.println(object1.hashCode() == object2.hashCode());

		HashMap<MyObject, String> map = new HashMap<>();

		map.put(object1, "value1");
		map.put(object2, "value2");

		System.out.println(map.get(object1));

	}

}
