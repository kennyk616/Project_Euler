/**
 * Highly divisible triangle number
 * http://projecteuler.net/problem=12
 * @author ken
 *
 */
public class Problem012 {
	
	public static int calculateNumDivisors(long n) {
		long sqrt = (long)(Math.sqrt(n));
		int numDivisors = 0;
		for (int i =1; i<=sqrt; i++){
			if (n%i == 0){
				numDivisors += 2;
				if(n/i == i) numDivisors--;
			}
		}
		return numDivisors;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int target = 500;
		int nDivisors = 0;
		long curVal = 0;
		long n = 1L;
		long triangle = curVal;
		
		while(nDivisors <= target) {
			curVal += n;
			int curDivisors = calculateNumDivisors(curVal);
			if (curDivisors > nDivisors) {
				nDivisors = curDivisors;
				triangle = curVal;
			}
			n++;
		}
		
		System.out.println(triangle);
		System.exit(0);
	}

}
