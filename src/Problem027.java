import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Quadratic Prime
 * http://projecteuler.net/problem=27
 * @author ken
 *
 */
public class Problem027 {
	
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
		
		int maxCount = 0;
		int optA = 0;
		int optB = 0;
		Set<Integer> primes = new HashSet<Integer>(generatePrime(1000000));
		for (int a = -999; a<1000; a++) {
			for (int b = -999; b<1000; b++) {
				int n = 0;
				while (true) {
					int val = (int)(Math.pow(n, 2))+a*n + b;
					if (isPrime(val, primes)){
						n++;
					}else {
						break;
					}
				}
				if (n > maxCount) {
					maxCount = n;
					optA = a;
					optB = b;
				}
			}
		}
		System.out.println("a = " + optA);
		System.out.println("b = " + optB);
		System.out.println("prod = " + optA*optB);
		
		System.exit(0);
		
	}

}
