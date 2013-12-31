import java.util.List;

/**
 * consecutive prime sum
 * http://projecteuler.net/problem=50
 * @author ken
 *
 */
public class Problem050 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int limit = 1000000;
		List<Integer> primes = Util.generatePrime(limit);
		long[] primeSum = new long[primes.size()+1];
		primeSum[0] = 0;
		
		for (int i = 1; i<primeSum.length; i++) {
			primeSum[i] = primeSum[i-1] + primes.get(i-1);
		}
		
		int numPrimes = 0;
		int val = 0;
		for (int i = 0; i<primeSum.length; i++) {
			for (int j = i-numPrimes-1; j>=0; j--){
				long diff = primeSum[i] - primeSum[j];
				if (diff > limit){
					break;
				}
				if (primes.contains((int)(diff))){
					int n = i-j;
					if (n > numPrimes){
						numPrimes = n;
						val = (int)(diff);
					}
				}
			}
		}
		
		System.out.println(val);
		System.out.println(numPrimes);
		System.exit(0);
		
	}

}
