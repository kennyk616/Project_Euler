/**
 * Special Pythagorean Triplet
 * http://projecteuler.net/problem=9
 * @author ken
 *
 */
public class Problem009 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 1000;
		int prod = 0;
		for (int a = 1; a<n/3; a++){
			for (int b = a+1; b<n/2; b++){
				int c = n - b - a;
				if (c <= b) break;
				if (Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2)){
					prod = a*b*c;
				}
			}
		}
		System.out.println(prod);
		
	}

}
