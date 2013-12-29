import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * non-abundant sums
 * http://projecteuler.net/problem=23
 * @author ken
 *
 */
public class Problem023 {

	public static int d(int n) {
		int sqrt = (int)(Math.sqrt(n));
		int d = 0;
		for (int i =1; i<=sqrt; i++){
			if (n%i == 0){
				d += i;
				if(n/i != i){
					d += n/i;
				}
			}
		}
		return d-n;
	}
	
	public static boolean canBeSum(Set<Integer> abundantNums, int n) {
		Iterator<Integer> iter = abundantNums.iterator();
		while (iter.hasNext()){
			int val = iter.next();
			if (val < n){
				int diff = n - val;
				if (abundantNums.contains(diff)){
					return true;
				}
			}
		}
		return false;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		int n = 28123;
		Set<Integer> abundantNums = new HashSet<Integer>();
		for (int i = 1; i<=n; i++){
			if (d(i) > i) {
				abundantNums.add(i);
			}
		}
		
		int sum = 0;
		
		for (int i = 1; i<=n; i++){
			if (!canBeSum(abundantNums, i)){
				sum += i;
			}
		}
		System.out.println(sum);
		System.exit(0);
	}

}
