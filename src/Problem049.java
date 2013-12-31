import java.util.ArrayList;

/**
 * prime permutations
 * http://projecteuler.net/problem=49
 * @author ken
 *
 */
public class Problem049 {
	public static int[] countDigits (int a) {
		int[] count = new int[10];
		int val = a;
		while (val > 0) {
			count[val%10]++;
			val = val/10;
		}
		return count;
	}
	
	
	public static boolean isPermutation(int a, int b, int c) {
		int[] countA = countDigits(a);
		int[] countB = countDigits(b);
		int[] countC = countDigits(c);
		for (int i = 0; i<10; i++) {
			if (!(countA[i]==countB[i] && countB[i]==countC[i])){
				return false;
			}
		}
		return true;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> fullPrimes = Util.generatePrime(10000);
		ArrayList<Integer> primes = new ArrayList<Integer>();
		for (int prime : fullPrimes) {
			if (prime > 1000){
				primes.add(prime);
			}
		}
		String result = null;
		for (int i = 1; i<primes.size(); i++) {
			int mid = primes.get(i);
			for (int j = 0; j<i; j++) {
				int lower = primes.get(j);
				
				if (lower==1487 && mid == 4817){
					continue;
				}
				
				int upper = mid + mid - lower;
				if (primes.contains(upper)){
					if (isPermutation(lower, mid, upper)){
						result = Integer.toString(lower)
								+ Integer.toString(mid)
								+ Integer.toString(upper);
					}
				}
			}
		}
		
		System.out.println(result);
		
		System.exit(0);
	}

}
