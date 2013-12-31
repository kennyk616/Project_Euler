/**
 * pentagon numbers
 * http://projecteuler.net/problem=44
 * @author ken
 *
 */
public class Problem044 {
	
	public static boolean isPentagon(long p) {
		double n = (Math.sqrt(24*p+1)+1)/6.0;
		if ((int)n == n) {
			return true;
		}
		return false;
	}
	
	public static long calculatePentagon(int i){
		return i*(3*i-1)/2;
	}
	
	public static long getD(){
		int i = 1;
		while(i<10000) {
			long pi = calculatePentagon(i);
			for (int j = i-1; j>=1; j--){
				long pj = calculatePentagon(j);
				if (isPentagon(pi-pj) && isPentagon(pi+pj)){
					return pi-pj;
					
				}
			}
			i++;
		}
		return 0;
	}
	/**
	 * guessed what the upper limit is. Should be guaranteed that this is the right answer,
	 * because the larger the value, the larger the difference is. 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		long d = getD();
		System.out.println(d);
		System.exit(0);
		
	}

}
