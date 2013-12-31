/**
 * champernowne's constant
 * http://projecteuler.net/problem=40
 * @author ken
 *
 */
public class Problem040 {
	
	public static int calculateDigit(int target) {
		int curVal = target;
		int curPow = 0;
		int digit = 0;
		while (true) {
			int limit = (curPow+1)*9*((int)(Math.pow(10, curPow)));
			if (limit >= curVal){
				int div = (curVal-1)/(curPow+1);
				int remainder = (curVal-1)%(curPow+1); 
				int number = (int)(Math.pow(10, curPow)) + div;
				String s = Integer.toString(number);
				digit = Character.getNumericValue(s.charAt(remainder));
				break;
			}
			curVal -= limit;
			curPow++;
		}
		
		return digit;
	}
	
	
	/**
	 * 1 - 9: 1 x 9
	 * 10 - 99: 2 x 90
	 * 100 - 999: 3 x 900
	 * 1000 - 9999: 4x9000
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] digits = new int[]{1, 10, 100, 1000, 10000, 100000, 1000000};
		
		int prod = 1;
		
		for (int i = 0; i < digits.length; i++) {
			int digit = calculateDigit(digits[i]);
			prod *= digit;
		}
		
		System.out.println(prod);
		System.exit(0);

	}

}
