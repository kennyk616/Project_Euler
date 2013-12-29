import java.math.BigInteger;

/**
 * Lattice Patterns
 * http://projecteuler.net/problem=15
 * @author ken
 *
 */
public class Problem15 {
	
	public static BigInteger factorial(int n){
		BigInteger prod = new BigInteger("1");
		for (int i = 2; i<=n; i++){
			prod = prod.multiply(BigInteger.valueOf(i));
		}
		return prod;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 20;
		
		BigInteger combo = factorial(n+n).divide(factorial(n).multiply(factorial(n)));
		System.out.println(combo);
		System.exit(0);
		
	}

}
