import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

/**
 * distinct powers
 * http://projecteuler.net/problem=29
 * @author ken
 *
 */
public class Problem029 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Set<BigInteger> distinctTerms = new HashSet<BigInteger>();
		int n = 100;
		for (int a = 2; a<=n; a++) {
			for (int b = 2; b <=n; b++) {
				 BigInteger val = BigInteger.valueOf(a).pow(b);
				 distinctTerms.add(val);
			}
		}
		
		System.out.println(distinctTerms.size());
		System.exit(0);
		
	}

}
