import java.math.BigInteger;

/**
 * combinatoric selections
 * http://projecteuler.net/problem=53
 * @author ken
 *
 */
public class Problem053 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BigInteger limit = BigInteger.valueOf(1000000);
		
		int n = 100;
		int count = 0;
		
		BigInteger[] factorials = new BigInteger[n+1];
		for (int i = 0; i<=n; i++){
			factorials[i] = Util.factorial(i);
		}
		
		for (int i = 23; i<=n; i++){
			for (int j = 1; j<i; j++){
				BigInteger value = factorials[i].divide(factorials[j].multiply(factorials[i-j]));
				if (value.compareTo(limit)>0){
					count++;
				}
			}
			
		}
		
		System.out.println(count);
		System.exit(0);
		
	}

}
