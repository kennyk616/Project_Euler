/**
 * number spiral diagonals
 * http://projecteuler.net/problem=28
 * @author ken
 *
 */
public class Problem028 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int length = 1001;
		int target = (length-1)/2;

		int [] sums = new int[target+1];
		sums[0] = 1;
		for (int n = 1; n<=target; n++) {
			sums[n] = 4*(2*n+1)*(2*n+1) - 12*n + sums[n-1];
		}
		
		System.out.println(sums[target]);
		System.exit(0);
	}

}
