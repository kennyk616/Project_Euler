/**
 * reciprocal cycles
 * http://projecteuler.net/problem=26
 * @author ken
 *
 */
public class Problem026 {
	
	public static int findRecurringCycle(int n) {
		int[] cycle = new int[n];
		int remainder = 1;
		for (int i = 0; i<n; i++) {
			remainder = (remainder*10) %n;
			if (remainder == 0) {
				return 0;
			}
			if (remainder == cycle[0]){
				return i;
			}
			cycle[i] = remainder;
		}
		
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 1000;
		int longestCycle = 0;
		int value = 0;
		
		for (int i = n-1; i>=1; i--) {
			if (i<longestCycle) {
				break;
			}
			int cycle = findRecurringCycle(i);
			if (cycle > longestCycle) {
				longestCycle = cycle;
				value = i;
			}
		}
		
		System.out.println(value);
		
	}

}
