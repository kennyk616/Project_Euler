
/**
 * powerful digit counts
 * http://projecteuler.net/problem=63
 * @author ken
 *
 */
public class Problem063 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int count = 0;
		int n = 1;
		double min = 0;
		while (min <10){
			min = (int)Math.ceil(Math.pow(10, (n-1.0)/n));
			count += (10-min);
			n++;
		}
		
		System.out.println(count);
		System.exit(0);
	}

}
