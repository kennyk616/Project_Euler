/**
 * sum of even fib numbers <= 4 million
 * http://projecteuler.net/problem=2
 * @author ken
 *
 */
public class Problem002 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int sum = 0;
		int fibPrev = 1;
		int fibCur = 2;
		while (fibCur <= 4000000) {
			if (fibCur%2 ==0) {
				sum += fibCur;
			}
			int fibNext = fibCur + fibPrev;
			fibPrev = fibCur;
			fibCur = fibNext;
		}
		System.out.println(sum);
		System.exit(0);
	}

}
