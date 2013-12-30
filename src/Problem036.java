/**
 * double-based palindromes
 * http://projecteuler.net/problem=36
 * @author ken
 *
 */
public class Problem036 {
	
	public static boolean isPalindrome(String s){
		if (s.charAt(0)=='0'){
			return false;
		}
		char[] arr = s.toCharArray();
		for (int i = 0; i<arr.length/2; i++){
			if (arr[i]!=arr[arr.length-1-i]){
				return false;
			}
		}
		return true;
	}
	
	public static String convertBase2(int n) {
		StringBuilder builder = new StringBuilder();
		int val = n;
		while (val >0) {
			int rem = val %2;
			builder.append(rem);
			val = val/2;
		}
		return builder.reverse().toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 1000000;
		int sum = 0;
		for (int i = 1; i<n; i++){
			if (isPalindrome(Integer.toString(i))){
				String base2 = convertBase2(i);
				if (isPalindrome(base2)){
					sum += i;
				}
			}
		}
		
		System.out.println(sum);
		System.exit(0);
		
	}

}
