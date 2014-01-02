import java.math.BigInteger;

/**
 * lychrel number
 * http://projecteuler.net/problem=55
 * @author ken
 *
 */
public class Problem055 {
	
	
	public static boolean isLynchrel(int n, int maxIter){
		BigInteger sum = BigInteger.valueOf(n);
		for (int i = 0; i<maxIter; i++){
			sum = Util.reverseBigInteger(sum).add(sum);
			if (Util.isPanindromeBigInteger(sum)){
				return false;
			}
		}
		return true;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 10000;
		int maxIter = 50;
		int count = 0;
		for (int i = 10; i<n; i++){
			if (isLynchrel(i, maxIter)){
				count++;			
			}
		}
		
		System.out.println(count);
		System.exit(0);
		
	
	}

}
