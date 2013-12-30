import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * pandigital products http://projecteuler.net/problem=32
 * 
 * @author ken
 * 
 */
public class Problem032 {

	public static boolean isPandigital(int a, int b, int c) {
		String concat = Integer.toString(a) + Integer.toString(b) + Integer.toString(c);
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
	 * has to be a 3 digit number multiplied by a 2 digit number, or a 4 digit
	 * multiplied by a 1 digit number so we have a total of 9 digits
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Integer> allValues = new HashSet<Integer>();
		for (int a = 12; a <= 98; a++) {
			for (int b = 123; b <=10000; b++) {
				int c = a * b;
				if (isPandigital(a, b, c)) {
					allValues.add(c);
				}
			}
		}
		
		for (int a = 1; a<=9; a++) {
			for (int b = 1234; b<=10000; b++) {
				int c = a * b;
				if (isPandigital(a, b, c)) {
					allValues.add(c);
				}
			}
		}

		Iterator<Integer> iter = allValues.iterator();
		int sum = 0;
		while (iter.hasNext()) {
			sum += iter.next();
		}
		System.out.println(allValues.size());
		System.out.println(sum);
		System.exit(0);

	}

}
