/**
 * permuted multiples
 * http://projecteuler.net/problem=52
 * @author ken
 *
 */
public class Problem052 {

	/*
	 * first 3 digits: 100 - 166
	 * 100... - 166...
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean found = false;
		long start = 10;
		long value = 0;
		
		while (!found) {
			for (long i = start; i<=start*10/6; i++){
				boolean isPermutation = true;
				for (int j = 1; j<=6; j++) {
					isPermutation = isPermutation && Util.isPermutation(i, i*j);
					if (!isPermutation){
						break;
					}
				}
				if (isPermutation){
					found = true;
					value = i;
					break;
				}
			}
			start *= 10;
		}
		
		System.out.println(value);
		System.exit(0);
	}

}
