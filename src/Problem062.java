import java.util.ArrayList;
import java.util.HashMap;

/**
 * cubic permutations http://projecteuler.net/problem=62
 * 
 * @author ken
 * 
 */
public class Problem062 {

	public static String calculateCount(long val) {
		char[] arr = Long.toString(val).toCharArray();
		int[] counts = new int[10];
		for (int i = 0; i < arr.length; i++) {
			counts[arr[i] - '0']++;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 10; i++) {
			sb.append(counts[i]);
		}

		return new String(sb);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		long base = 345;
		ArrayList<Long> solutions = null;
		HashMap<String, ArrayList<Long>> map = new HashMap<String, ArrayList<Long>>();
		while (true) {

			long value = (long) (Math.pow(base, 3));
			String counts = calculateCount(value);
			if (map.containsKey(counts)) {
				map.get(counts).add(value);
			} else {
				ArrayList<Long> list = new ArrayList<Long>();
				list.add(value);
				map.put(counts, list);
			}
			if (map.get(counts).size() == 5) {
				solutions = map.get(counts);
				break;
			}

			base++;
		}

		for (int i = 0; i < 5; i++) {
			System.out.println(solutions.get(i));
		}
		System.exit(0);
	}

}
