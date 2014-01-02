import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;


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
	
	public static int numPrimeFactors(long n, List<Integer> primes) {
		int numPrimeFactors = 0;
		boolean bool;
		long remainder = n;
		
		for (int i = 0; i<primes.size(); i++) {
			if (primes.get(i)*primes.get(i) > n) {
				return numPrimeFactors+1;
			}
			
			bool = false;
			while (remainder %primes.get(i)==0) {
				bool = true;
				remainder = remainder/primes.get(i);
			}
			if (bool){
				numPrimeFactors++;
			}
			
			if (remainder == 1){
				return numPrimeFactors;
			}
		}
		return numPrimeFactors;
	}
	
	public static boolean isPalindrome(long n){
		String s = Long.toString(n);
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
	
	public static int[] countDigits (long a) {
		int[] count = new int[10];
		long val = a;
		while (val > 0) {
			count[(int)(val%10)]++;
			val = val/10;
		}
		return count;
	}
	
	public static boolean isPermutation(long a, long b){
		if (Long.toString(a).length()!=Long.toString(b).length()){
			return false;
		}
		int[] countA = countDigits(a);
		int[] countB = countDigits(b);
		return Arrays.equals(countA, countB);
		
	}
	
	public static BigInteger factorial(int n){
		if (n==0 || n==1){
			return BigInteger.valueOf(1);
		}
		BigInteger prod = BigInteger.valueOf(1);
		for (int i = 2; i<=n; i++){
			prod = prod.multiply(BigInteger.valueOf(i));
		}
		return prod;
	}
	
	
	public static boolean isPanindromeBigInteger(BigInteger bi) {
		char[] array = bi.toString().toCharArray();
		for (int i = 0; i<array.length/2; i++){
			if (array[i]!=array[array.length-1-i]){
				return false;
			}
		}
		return true;
	}
	
	public static BigInteger reverseBigInteger(BigInteger bi){
		char[] array = bi.toString().toCharArray();
		for (int i = 0; i<array.length/2; i++){
			char tmp = array[i];
			array[i] = array[array.length-1-i];
			array[array.length-1-i] = tmp;
		}
		return new BigInteger(new String(array));
	}
	
	public static long reverseInt(long l){
		long reverse = 0;
		long input = l;
		while (input != 0){
			reverse = reverse * 10 + input%10;
			input = input/10;
		}
		
		return reverse;
	}
	
	public static int numDigits(BigInteger bi) {
		return bi.toString().length();
	}
	
	public static int sumOfDigits(BigInteger bi){
		char[] array = bi.toString().toCharArray();
		int sum = 0;
		for (int i = 0; i<array.length; i++){
			sum += array[i]-'0';
		}
		return sum;
	}
}
