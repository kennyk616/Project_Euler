import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * prime pair sets
 * http://projecteuler.net/problem=60
 * @author ken
 *
 */
public class Problem060 {
	static int upperLimit = 30000;
	static List<Integer> primes = Util.generatePrime(upperLimit);		
	static List<Set<Integer>> canConcantenate = new ArrayList<Set<Integer>>();
	
	public static void makePairs(int i){
		
		for (int j = 0; j<primes.size(); j++){
			long concat1 = Util.concatInt(primes.get(i), primes.get(j));
			long concat2 = Util.concatInt(primes.get(j), primes.get(i));
			if (Util.isPrime(concat1) && Util.isPrime(concat2)){
				canConcantenate.get(i).add(j);
			}
		}
	}
	
	public static int sumPrimes(int a, int b, int c, int d, int e){
		return primes.get(a) + primes.get(b) + primes.get(c) 
				+ primes.get(d)+ primes.get(e);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i<primes.size(); i++) {
			canConcantenate.add(new HashSet<Integer>());
		}
		int lowestSum = Integer.MAX_VALUE;
		int[] lowestFive = new int[5];
		
		for (int a = 1; a<primes.size(); a++) {
			if (sumPrimes(a,a,a,a,a)> lowestSum) break;
			if (canConcantenate.get(a).isEmpty()) makePairs(a);
			for (int b = a+1; b<primes.size(); b++) {
				if (sumPrimes(a,b,b,b,b) > lowestSum ) break;
				if (!canConcantenate.get(a).contains(b)) continue;
				if (canConcantenate.get(b).isEmpty()) makePairs(b);
				for (int c = b+1; c<primes.size(); c++) {
					if (sumPrimes(a,b,c,c,c) > lowestSum) break;
					if (!canConcantenate.get(a).contains(c) || !canConcantenate.get(b).contains(c)) continue;
					if (canConcantenate.get(c).isEmpty()) makePairs(c);
					for (int d = c+1; d<primes.size(); d++) {
						if (sumPrimes(a,b,c,d,d)> lowestSum) break;
						if (!canConcantenate.get(a).contains(d) 
								|| !canConcantenate.get(b).contains(d)
								|| !canConcantenate.get(c).contains(d)) continue;
						
						if (canConcantenate.get(d).isEmpty()) makePairs(d);
						
						for (int e = d+1; e<primes.size(); e++) {
							if (sumPrimes(a,b,c,d,e)> lowestSum) {
								break;
							}
							if (!canConcantenate.get(a).contains(e) 
									|| !canConcantenate.get(b).contains(e)
									|| !canConcantenate.get(c).contains(e)
									|| !canConcantenate.get(d).contains(e)) continue;
							
							if (canConcantenate.get(e).isEmpty()) makePairs(e);
							lowestFive = new int[]{a,b,c,d,e};
							lowestSum = sumPrimes(a,b,c,d,e);
						}
					}
				}
			}
		}
		
		for (int i = 0; i<lowestFive.length; i++){
			System.out.println(primes.get(lowestFive[i]));
		}
		
		System.out.println(lowestSum);
		System.exit(0);
		
	}

}
