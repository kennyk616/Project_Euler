/**
 * Coin sums
 * http://projecteuler.net/problem=31
 * @author ken
 *
 */
public class Problem031 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] coinSizes = new int[]{1, 2, 5, 10, 20, 50, 100, 200};
		
		int target = 200;
		int[] combinations = new int[target+1];
		combinations[0] = 1;
		
		for (int i = 0; i <coinSizes.length; i++) {
			for (int j = coinSizes[i]; j<=target; j++) {
				combinations[j] += combinations[j-coinSizes[i]];
			}
		}
		
		System.out.println(combinations[target]);
		System.exit(0);
		
	}

}
