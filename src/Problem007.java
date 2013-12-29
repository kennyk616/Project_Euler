/**
 * find 10001st prime number
 * http://projecteuler.net/problem=7
 * @author ken
 *
 */
public class Problem007 {

	
	public static boolean isPrime(int n) {
		int sqrt = (int)(Math.sqrt(n));
		for (int i = 2; i<=sqrt; i++) {
			if (n%i==0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int target = 10001;
		int n = 3;
		int count = 1;
		int prime = n;
		while (count <target) {
			if (isPrime(n)){
				count ++;
				prime = n;
			}
			n += 2;
		}
		
		System.out.println(prime);
		System.exit(0);
	}

}
