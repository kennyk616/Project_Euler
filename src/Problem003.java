/**
 * Find the largest prime factor of a value
 * http://projecteuler.net/problem=3
 * @author ken
 *
 */
public class Problem003 {

	public static long largestPrimeFactor(long n) {
		long val = n;
		long divisor = 2L;
		long largestDivisor = 2L;
		while (val >1) {
			if(isPrime(divisor)){
				if (val%divisor == 0L) {
					largestDivisor = Math.max(largestDivisor, divisor);
					val = val/divisor;
				}else{
					divisor++;
				}
			}else{
				divisor++;
			}
		}

		return largestDivisor;
	}
	
	public static boolean isPrime(long n) {
		long sqrt = (long)(Math.sqrt(n));
		for (long i = 2; i<=sqrt; i++) {
			if (n%i==0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long n = 600851475143L;
		System.out.println(largestPrimeFactor(n));
		System.exit(0);

	}

}
