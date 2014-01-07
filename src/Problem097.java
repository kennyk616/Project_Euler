import java.math.BigInteger;

/**
 * large non-mersenne prime
 * http://projecteuler.net/problem=97
 * @author ken
 *
 */
public class Problem097 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BigInteger coeff = BigInteger.valueOf(28433);
		BigInteger exp = BigInteger.valueOf(2).modPow(BigInteger.valueOf(7830457), BigInteger.TEN.pow(10));
		BigInteger largePrime = coeff.multiply(exp).add(BigInteger.valueOf(1));
				
		
		
		
		String primeString = largePrime.toString();
		System.out.println(primeString.substring(primeString.length()-10));
		System.exit(0);
	}

}
