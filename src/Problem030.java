/**
 * sum fifth power
 * http://projecteuler.net/problem=30
 * @author ken
 *
 */
public class Problem030 {
	
	public static boolean sumFifthPower(int n){
		int div = n;
		int sum = 0;
		while(div>0) {
			int rem = div%10;
			sum += (int)(Math.pow(rem, 5));
			div = div/10;
		}
		if (sum == n) {
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = 0;
		int limit = 6*(int)(Math.pow(9, 5));
		for (int i = 2; i<=limit; i++){
			if (sumFifthPower(i)){
				sum += i;
			}
		}
		
		System.out.println(sum);
		System.exit(0);
	}

}
