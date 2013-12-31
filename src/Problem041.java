import java.util.ArrayList;


/**
 * pandigital prime
 * http://projecteuler.net/problem=41
 * @author ken
 *
 */
public class Problem041 {

	
	/**
	 * cannot be 8 or 9 digits, since 8 or 9 digit pandigital number is divisible by 3
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int largestPandigitalPrime = 0;
		
		ArrayList<Integer> primes = Util.generatePrime(7654321);
		for (int i = primes.size()-1; i>=0; i--) {
			String str = primes.get(i).toString();
			if (Util.isPandigital(str, str.length())){
				largestPandigitalPrime = primes.get(i);
				break;
			}
		}
		System.out.println(largestPandigitalPrime);
		System.exit(0);
	}

}
