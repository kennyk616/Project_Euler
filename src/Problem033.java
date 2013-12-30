import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * digit canceling fractions
 * http://projecteuler.net/problem=33
 * @author ken
 *
 */


public class Problem033 {
	
	public static boolean canReduce(int num1, int den1, int num2, int den2){
		if (den1<=num1 || den2<=num2){
			return false;
		}
		
		int largestCommonFactor1 = largestCommonFactor(num1, den1);
		int num1Red = num1/largestCommonFactor1;
		int den1Red = den1/largestCommonFactor1;
		
		int largestCommonFactor2 = largestCommonFactor(num2, den2);
		int num2Red = num2/largestCommonFactor2;
		int den2Red = den2/largestCommonFactor2;
		
		if(num1Red==num2Red && den1Red == den2Red){
			return true;
		}
		
		return false;
	}
	
	public static int largestCommonFactor(int a, int b) {
		Set<Integer> factorsA = calculateFactors(a);
		Set<Integer> factorsB = calculateFactors(b);
		factorsA.retainAll(factorsB);
		return Collections.max(factorsA);
	}
	
	public static Set<Integer> calculateFactors(int n) {
		Set<Integer> factors = new HashSet<Integer>();
		
		int sqrt = (int)(Math.sqrt(n));
		for (int i =1; i<=sqrt; i++){
			if (n%i == 0){
				factors.add(i);
				if (n/i !=i){
					factors.add(n/i);
				}
			}
		}
		return factors;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int numProd = 1;
		int denProd = 1;
		
		for (int a = 1; a<=9; a++) {
			for (int b = 1; b<=9; b++) {
				for (int c = 1; c<=9; c++){
					int num = 10*a+b;
					if (canReduce(num, 10*a+c, b, c)){
						numProd *= num;
						denProd *= (10*a+c);
					}
					
					if (canReduce(num, 10*b+c, a, c)){
						numProd *= num;
						denProd *= 10*b+c;
					}
					
					if (canReduce(num, 10*c+b, a, c)){
						numProd *= num;
						denProd *= 10*c+b;
					}
					
					if (canReduce(num, 10*c+a, b, c)){
						numProd *= num;
						denProd *= 10*c+a;
					}
				}
			}
		}
		
		int largestFactor = largestCommonFactor(numProd, denProd);
		System.out.println(denProd/largestFactor);
		System.exit(0);
		
	}

}
