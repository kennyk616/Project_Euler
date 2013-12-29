import java.math.BigInteger;

/**
 * factorial digit sum
 * http://projecteuler.net/problem=20
 * @author ken
 *
 */
public class Problem020 {

	public static BigInteger factorial(int n){
		BigInteger prod = new BigInteger("1");
		for (int i = 2; i<=n; i++){
			prod = prod.multiply(BigInteger.valueOf(i));
		}
		return prod;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 100;
		char[] value = factorial(n).toString().toCharArray();
		int sum = 0;
		for (int i = 0; i<value.length; i++){
			sum += Character.getNumericValue(value[i]);
		}
		System.out.println(sum);
		System.exit(0);
		
	}

}
