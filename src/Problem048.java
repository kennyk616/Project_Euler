import java.math.BigInteger;

/**
 * self powers
 * http://projecteuler.net/problem=48
 * @author ken
 *
 */
public class Problem048 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigInteger sum = BigInteger.valueOf(0);
		for (int i = 1; i<=1000; i++){
			BigInteger bi = BigInteger.valueOf(i);
			sum = sum.add(bi.pow(i));
		}
		String sumStr = sum.toString();
		String last10Digits = sumStr.substring(sumStr.length()-10);
		System.out.println(last10Digits);
		System.exit(0);
		
	}

}
