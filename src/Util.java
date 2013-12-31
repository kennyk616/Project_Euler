import java.util.ArrayList;
import java.util.Collection;


public class Util {

	public static boolean isPandigital(String s, int digit){
		if (s.length()!=digit){
			return false;
		}
		for (int i = 0; i<s.length(); i++) {
			if(s.charAt(i)=='0' || s.charAt(i)> '0'+digit){	//cannot have 0, cannot exceed digit
				return false;
			}
			for (int j = 0; j<s.length(); j++) {
				if (s.charAt(i)==s.charAt(j) && i!=j) {
					return false;
				}
			}
		}
		return true;
		
	}
	
	public static ArrayList<Integer> generatePrime(int n) {
		int[] numbers = new int[n+1];
		for (int i = 2; i<=n; i++) {
			numbers[i] = 1;
		}
		int factor = 2;
		while(true){
			if (factor*factor > n){
				break;
			}
			for (int i = factor*2; i<=n; i+=factor) {
				numbers[i] = 0;
			}
			int i = factor+1;
			while(true){
				if (numbers[i]==1){
					factor = i;
					break;
				}else{
					i++;
				}
			}
		}
		
		ArrayList<Integer> primes = new ArrayList<Integer>();
		for (int i = 2; i<=n; i++){
			if (numbers[i]==1){
				primes.add(i);
			}
		}
		return primes;
	}
	
	public static long largestPrimeFactor(long n, Collection<Integer> primes) {
		long val = n;
		long divisor = 2L;
		long largestDivisor = 2L;
		while (val >1) {
			if(primes.contains(divisor)){
				if (val%divisor == 0L) {
					largestDivisor = Math.max(largestDivisor, divisor);
					val = val/divisor;
				}else{
					divisor++;
				}
			}else{
				divisor++;
			}
		}

		return largestDivisor;
	}
	
	public static boolean isPalindrome(int n){
		String s = Integer.toString(n);
		for (int i = 0; i<s.length()/2; i++){
			if (s.charAt(i)!=(s.charAt(s.length()-1-i))){
				return false;
			}
		}
		return true;
	}
	
	public static boolean isPentagon(long p) {
		double n = (Math.sqrt(24*p+1)+1)/6.0;
		if ((int)n == n) {
			return true;
		}
		return false;
	}
	
}
