/**
 * Find largest Palindrome product
 * http://projecteuler.net/problem=4
 * @author ken
 *
 */
public class Problem4 {

	public static boolean isPalindrome(int n){
		String s = Integer.toString(n);
		for (int i = 0; i<s.length()/2; i++){
			if (s.charAt(i)!=(s.charAt(s.length()-1-i))){
				return false;
			}
		}
		return true;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int largestPal = 0;
		for (int i = 100; i<1000; i++) {
			for (int j = 100; j<1000; j++) {
				int prod = i*j;
				if (isPalindrome(prod)){
					largestPal = Math.max(largestPal, prod);
				}
			}
		}
		System.out.println(largestPal);
		System.exit(0);
		
	}

}
