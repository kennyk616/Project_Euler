import java.math.BigInteger;

/**
 * 1000-digit Fib number
 * http://projecteuler.net/problem=25
 * @author ken
 *
 */
public class Problem025 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 1000;
		BigInteger prev = BigInteger.valueOf(1);
		BigInteger cur = BigInteger.valueOf(1);
		int count = 2;
		while(true) {
			int length = cur.toString().length();
			if (length ==n){
				break;
			}
			BigInteger next = cur.add(prev);
			prev = cur;
			cur = next;
			count ++;
		}
		System.out.println(count);
		System.exit(0);
		
	}

}
