
/**
 * pandigital multiples
 * http://projecteuler.net/problem=38
 * @author ken
 *
 */
public class Problem038 {
	
	public static boolean isPandigital(int a, int b) {
		String concat = Integer.toString(a) + Integer.toString(b);
		if (concat.length()!=9) {
			return false;
		}
		for (int i = 0; i<concat.length(); i++) {
			if(concat.charAt(i)=='0'){	//cannot have 0 as digit
				return false;
			}
			for (int j = 0; j<concat.length(); j++) {
				if (concat.charAt(i)==concat.charAt(j) && i!=j) {
					return false;
				}
			}
		}
		return true;
	}
	
	
	
	/*
	 * candidate starts with 9 (our example starts with 9, so the value is larger or equal that)
	 * if n = 2, it's XXXX YYYYY
	 * if n = 5, it's A, BB, CC, DD, EE (given in the example)
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int largestA = 0;
		int largestB = 0;
		
		for (int i = 9123; i<=9876; i++){
			if (isPandigital(i, i*2)){
				largestA = i;
				largestB = i*2;
			}
		}
		
		long value = Math.max(largestA*100000 + largestB, 918273645L);
		
		
		System.out.println(value);
		System.exit(0);
	}

}
