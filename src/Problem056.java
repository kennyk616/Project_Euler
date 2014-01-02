import java.math.BigInteger;

/**
 * powerful digit sum 
 * http://projecteuler.net/problem=56
 * @author ken
 *
 */
public class Problem056 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int max = 100;
		int maxSum = 0;

		for (int a = max-1; a>0; a--){
			for (int b = max-1; b>0; b--){
				BigInteger bi = BigInteger.valueOf(a).pow(b);
				if (bi.toString().length()*9 < maxSum) {
					break;
				}
				maxSum = Math.max(maxSum, Util.sumOfDigits(bi));
			}
		}
		
		
		System.out.println(maxSum);
		System.exit(0);
	}

}
