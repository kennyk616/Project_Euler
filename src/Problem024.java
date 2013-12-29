import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * lexicographic permutations
 * http://projecteuler.net/problem=24
 * @author ken
 *
 */
public class Problem024 {
	
	public static int factorial(int n){
		if (n==0) return 1;
		int prod = 1;
		for (int i = 2; i<=n; i++){
			prod = prod*i;
		}
		return prod;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 1000000;
		StringBuilder builder = new StringBuilder();
		List<Integer> digits = new LinkedList<Integer>(Arrays.asList(new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}));
		
		int val = n-1;
		int fixDigit = 9;
		while(fixDigit>=0) {
			int permFixDigit = factorial(fixDigit);
			int idx = val/permFixDigit;
			builder.append(digits.get(idx));
			digits.remove(idx);
			val = val %permFixDigit;
			fixDigit--;
		}
		
		System.out.println(new String(builder));
		System.exit(0);
	}

}
