/**
 * Smallest Multiple
 * http://projecteuler.net/problem=5
 * @author ken
 *
 */
public class Problem5 {
	
	public static boolean isPrime(int n) {
		int sqrt = (int)(Math.sqrt(n));
		for (int i = 2; i<=sqrt; i++) {
			if (n%i==0) {
				return false;
			}
		}
		return true;
	}
	
	public static int largestMult(int i, int max){
		int prod = i;
		while (true){
			if (prod * i > max){
				break;
			}else {
				prod *= i;
			}
		}
		return prod;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int prod = 1;
		int max = 20;
		for (int i =2; i<=max; i++){
			if (isPrime(i)){
				int mult = largestMult(i, max);
				prod *= mult;
			}
		}
		System.out.println(prod);
		System.exit(0);
	}

}
