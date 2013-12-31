/**
 * triangular, pentagonal, hexagonal
 * http://projecteuler.net/problem=45
 * @author ken
 *
 */
public class Problem045 {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int cur = 144;
		long p;
		while (!Util.isPentagon(p = cur*(2*cur-1))){
			cur++;
		}
		
		System.out.println(p);
		System.exit(0);
	}

}
