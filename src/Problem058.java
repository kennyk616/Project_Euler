/**
 * spiral primes
 * http://projecteuler.net/problem=57
 * @author ken
 *
 */

public class Problem058 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double percentage = 1;
		int length = 1;
		double nPrimes = 0;
		long [] corners = new long[]{1, 1, 1};
		long add = 2;
		
		while (percentage > 0.1){
			for (int i = 0; i<corners.length; i++){
				corners[i] += add;
				add += 2;
				if (Util.isPrime(corners[i])){
					nPrimes ++;
				}
			}
			add += 2;
			length += 2;
			percentage = nPrimes/(length*2 - 1);
		}
		
		
		System.out.println(length);
		System.exit(0);
	}

}
