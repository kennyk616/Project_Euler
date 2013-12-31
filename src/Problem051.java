import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * prime digit replacements
 * http://projecteuler.net/problem=51
 * @author ken
 *
 */
public class Problem051 {
	
	public static int[][] generateFiveDigitPattern(){
		int[][] fiveDigitPattern = new int[4][5];
		
		for (int i = 0; i<fiveDigitPattern.length; i++){
			fiveDigitPattern[i][i] = 1;
			fiveDigitPattern[i][4] = 1;
		}
 		
		return fiveDigitPattern;
	}
	
	public static int[][] generateSixDigitPattern(){
		int[][] sixDigitPattern = new int[10][6];
		int idx = 0;
		for (int i = 0; i<sixDigitPattern[0].length-2; i++){
			for (int j = i+1; j<sixDigitPattern[0].length-1; j++) {
				sixDigitPattern[idx][i] = 1;
				sixDigitPattern[idx][j] = 1;
				sixDigitPattern[idx][5] = 1;
				idx++;
			}
		}
		
		return sixDigitPattern;
	}
	static int[] lastDig = new int[]{1, 3, 7, 9};
	static int[] firstDig = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
	static int[] allDig = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 0};

	public static int[] fillPattern(int[] pattern, int nDigits, int[] fixDigits) {
		int [] value = new int[nDigits];
		int idx = 0;
		for (int i = 0; i<nDigits; i++){
			if (pattern[i]==1){
				value[i] = fixDigits[idx];
				idx++;
			}
		}
		return value;
	}
	
	public static int smallestPrime(int[] value, Set<Integer> primes){
		for (int i = 0; i<10; i++){
			int[] curVal = Arrays.copyOf(value, value.length);
			for (int j = 0; j<curVal.length; j++) {
				if (curVal[j]==0){
					curVal[j] = i;
				}
			}
			if (curVal[0]==0) {
				continue;
			} else {
				int number = convertToInt(curVal);
				if (primes.contains(number)){
					return number;
				}
			}
		}
		return 0;
	}
	
	public static int numPrime(int[] value, Set<Integer> primes){
		int count = 0;
		for (int i = 0; i<10; i++){
			int[] curVal = Arrays.copyOf(value, value.length);
			for (int j = 0; j<curVal.length; j++){
				if (curVal[j]==0){
					curVal[j] = i;
				}
			}
			if (curVal[0]==0) {
				continue;
			} else{
				int number = convertToInt(curVal);
				if (primes.contains(number)){
					count++;
				}
			}
			
			
		}
		return count;
	}
	
	public static int[] convertToArr(int val) {
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		int div = val;
		while(div > 0){
			arrList.add(div%10);
			div /= 10;
		}
		int[] arr = new int[arrList.size()];
		for (int i = 0 ; i<arr.length; i++){
			arr[i] = arrList.get(arr.length-1-i);
		}
		return arr;
	}
	
	public static int convertToInt(int[] arr){
		int val  = 0;
		int pow = 1;
		for (int i = arr.length-1; i>=0; i--) {
			val += pow*arr[i];
			pow *=10;
		}
		return val;
	}
	
	public static int findSmallest(Set<Integer> primes){
		int[][] fiveDigits = generateFiveDigitPattern();
		int[][] sixDigits = generateSixDigitPattern();
		
		for (int fix = 11; fix<1000; fix+=2){
			if(fix%5==0){
				continue;
			}
			int[][] patterns = fix<100 ? fiveDigits : sixDigits;
			
			int [] fixDigits = convertToArr(fix);
			for (int i = 0; i<patterns.length; i++){
				if (patterns[i][0]==1 && fixDigits[0]==0){
					continue;
				}
				int[] value = fillPattern(patterns[i], patterns[i].length, fixDigits);
				if (value == null) continue;
				if (numPrime(value, primes)==8){
					return smallestPrime(value, primes);
				}
			}
		}
		
		return 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//five digit
		int limit = 999999;
		
		Set<Integer> primes = new HashSet<Integer>(Util.generatePrime(limit));
		
		int value = findSmallest(primes);
		System.out.println(value);
		System.exit(0);
		
	}

}
