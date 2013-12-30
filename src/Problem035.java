import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * circular prime
 * http://projecteuler.net/problem=35
 * @author ken
 *
 */
public class Problem035 {

	public static boolean isPrime(int n, Set<Integer> primes) {
		return primes.contains(n);
	}

	public static ArrayList<Integer> generatePrime(int n) {
		int[] numbers = new int[n+1];
		for (int i = 2; i<=n; i++) {
			numbers[i] = 1;
		}
		int factor = 2;
		while(true){
			if (factor*factor > n){
				break;
			}
			for (int i = factor*2; i<=n; i+=factor) {
				numbers[i] = 0;
			}
			int i = factor+1;
			while(true){
				if (numbers[i]==1){
					factor = i;
					break;
				}else{
					i++;
				}
			}
		}
		
		ArrayList<Integer> primes = new ArrayList<Integer>();
		for (int i = 2; i<=n; i++){
			if (numbers[i]==1){
				primes.add(i);
			}
		}
		return primes;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 1000000;
		
		Set<Integer> primes = new HashSet<Integer>(generatePrime(n));
		Set<Integer> circularPrimes = new HashSet<Integer>();
		for(int value : primes) {
			if (value<10){
				circularPrimes.add(value);
				continue;
			}
			String origVal = Integer.toString(value);
			String curVal = origVal.charAt(origVal.length()-1) + origVal.substring(0, origVal.length()-1);
			boolean isCircular = true;
			while(!origVal.equals(curVal)){
				if (!isPrime(Integer.valueOf(curVal), primes)){
					isCircular = false;
					break;
				}
				curVal = curVal.charAt(curVal.length()-1) + curVal.substring(0, curVal.length()-1);
			}
			if (isCircular){
				circularPrimes.add(value);
			}
		}
		System.out.println(circularPrimes.size());
		System.exit(0);
		
	}

}
