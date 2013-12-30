
/**
 * digit factorials
 * http://projecteuler.net/problem=34
 * @author ken
 *
 */
public class Problem034 {
	public static long factorial(int n){
		if (n==0 || n == 1) return 1;
		long prod = 1L;
		for (int i = 2; i<=n; i++){
			prod = prod * i;
		}
		return prod;
	}
	
	public static boolean isDigitFactorial(long i) {
		long div = i;
		long sum = 0;
		while (div >0) {
			int remainder = (int)(div%10);
			sum += factorial(remainder);
			div = div/10;
		}
		
		return (sum == i);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = 0;
		long limit = factorial(9)*7;	//limit because 9999999 is 7 digits. 9! * 8 is also 7 digits.
		
		for (long i = 3; i<=limit; i++) {
			if (isDigitFactorial(i)) {
				sum += i;
			}
		}
		System.out.println(sum);
		System.exit(0);
	}

}
