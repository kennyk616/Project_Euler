/**
 * sum of primes below 2 million
 * http://projecteuler.net/problem=10
 * @author ken
 *
 */
public class SumPrimes {

	public static boolean isPrime(int n) {
		int sqrt = (int)(Math.sqrt(n));
		for (int i = 2; i<=sqrt; i++) {
			if (n%i==0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n = 2000000;		
		long sum = 2;
		for (int i = 3; i<n; i+=2) {
			if (isPrime(i)){
				sum += i;
			}
		}
		System.out.println(sum);
		System.exit(0);

	}

}
