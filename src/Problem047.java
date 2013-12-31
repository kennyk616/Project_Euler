import java.util.List;

/**
 * distinct prime factors
 * http://projecteuler.net/problem=47
 * @author ken
 *
 */
public class Problem047 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 1000000;
		List<Integer> primes = Util.generatePrime(n);
		int val = 2*3*5*7;
		int consec = 1;
		int target = 4;
		
		while (consec < target){
			val++;
			if (Util.numPrimeFactors(val, primes)!=4){
				consec = 0;
			}else{
				consec++;
			}
		}
		
		

		System.out.println(val-3);
		
		System.exit(0);
	}

}
