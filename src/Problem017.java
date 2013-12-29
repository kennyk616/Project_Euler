import java.util.HashMap;
import java.util.Map;

/**
 * Number letter counts
 * http://projecteuler.net/problem=17
 * @author ken
 *
 */


public class Problem017 {
	
	static Map<Integer, Integer> numToString = new HashMap<Integer, Integer>();
	
	public static int numbers1_9(){
		int sum = "onetwothreefourfivesixseveneightnine".length();
		return sum;
	}
	
	public static int numbers10_19(){
		int sum = "teneleventwelvethirteenfourteenfifteensixteenseventeeneighteennineteen".length();
		return sum;
	}
	
	public static int numbers20_99(){
		int sum = "twentythirtyfortyfiftysixtyseventyeightyninety".length();
		sum = sum*10 + numbers1_9()*8;
		return sum;
		
	}
	
	public static int hundreds(){
		int hundred = "hundred".length();
		int and = "and".length();
		int sum = hundred*(900) + and*(900-9) + numbers1_9()*100;
		return sum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int numbers1_99 = numbers1_9() + numbers10_19() + numbers20_99();
		
		int count = numbers1_99*10 + hundreds() + "onethousand".length();

		System.out.println(count);
		System.exit(0);
		
	}
	
}
