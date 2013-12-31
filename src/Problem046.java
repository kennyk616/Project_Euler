import java.util.List;

/**
 * goldbach
 * http://projecteuler.net/problem=46
 * @author ken
 *
 */
public class Problem046 {
	
	public static boolean isGold(int comp, List<Integer> primes){
		for (int j = 0; j<primes.size(); j++){
			if (primes.get(j)>=comp){
				return false;
			}
			int diff = comp - primes.get(j);
			double val = Math.sqrt(diff/2.0);
			if (val==(int)val){
				return true;
			}
		}
		return false;
	}

	public static int findException(int n, List<Integer> primes){
		for (int i = 1; i<n; i++) {
			int comp = 2*i + 1;
			if (!primes.contains(comp)){
				if(!isGold(comp, primes)){
					return comp;
				}
			}
			
		}
		return 0;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 1000000;
		List<Integer> primes = Util.generatePrime(n*2);
		int exception = findException(n, primes);
		
		System.out.println(exception);
		System.exit(0);
	}

}
