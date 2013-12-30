import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * truncate primes
 * http://projecteuler.net/problem=37
 * @author ken
 *
 */
public class Problem037 {

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
	
	public static boolean canTruncateLeftRight(Set<Integer> primes, int n) {
		String s = Integer.toString(n);
		for (int i = 1; i<s.length(); i++) {
			String substr = s.substring(i, s.length());
			int val = Integer.valueOf(substr);
			if (!isPrime(val, primes)){
				return false;
			}
		}
		
		for (int i = s.length()-1; i>0; i--) {
			String substr = s.substring(0, i);
			int val = Integer.valueOf(substr);
			if (!isPrime(val, primes)){
				return false;
			}
		}
		
		return true;
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int limit = 1000000;	//don't know what the upper limit is
				
		Set<Integer> primes = new HashSet<Integer>(generatePrime(limit));
		int sum = 0;
		int count = 0;
		for (int n : primes){
			if (n<10) continue;
			
			if(canTruncateLeftRight(primes, n)){
				sum += n;
				count++;
			}
		}
		System.out.println(count);
		System.out.println(sum);
		System.exit(0);

	}

}
