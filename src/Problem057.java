import java.math.BigInteger;

/**
 * square root convergents
 * http://projecteuler.net/problem=57
 * @author ken
 *
 */
public class Problem057 {

	/**
	 * pattern:
	 * n: numberator
	 * d = denominator
	 * we want n_i/d_i where i = 1 to 1000
	 * n_i+1 = n_i + 2*d_i
	 * d_i+1 = n_i + d_i
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n = 1000;
		int count = 0;
		BigInteger nPrev = BigInteger.valueOf(3);
		BigInteger dPrev = BigInteger.valueOf(2);
		for (int i = 1; i<n; i++){
			BigInteger nCur = nPrev.add(dPrev.multiply(BigInteger.valueOf(2)));
			BigInteger dCur = nPrev.add(dPrev);
			if (Util.numDigits(nCur) > Util.numDigits(dCur)){
				count++;
			}
			nPrev = nCur;
			dPrev = dCur;
		}
		
		System.out.println(count);
		
		System.exit(0);

	}

}
