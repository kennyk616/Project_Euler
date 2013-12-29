import java.math.BigInteger;

/**
 * power digit sum
 * http://projecteuler.net/problem=16
 * @author ken
 *
 */
public class Problem16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigInteger val = new BigInteger("2");
		int pow = 1000;
		val = val.pow(pow);
		char[] s = val.toString().toCharArray();
		long sum = 0L;
		for (int i = 0; i<s.length; i++){
			sum += Character.getNumericValue(s[i]);
		}
		System.out.println(sum);
		System.exit(0);
	}

}
