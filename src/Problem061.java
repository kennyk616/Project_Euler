import java.util.ArrayList;

/**
 * cyclical figurate numbers 
 * http://projecteuler.net/problem=61
 * @author ken
 *
 */
public class Problem061 {
	
	public static int[] generateFigurateNumbers(int n){
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		
		int i = 1;
		while (true){
			int val = 0;
			if (n==0) val = i*(i+1)/2;
			if (n==1) val = i*i;
			if (n==2) val = i*(3*i-1)/2;
			if (n==3) val = i*(2*i-1);
			if (n==4) val = i*(5*i-3)/2;
			if (n==5) val = i*(3*i-2);
			i++;
			if (val<1000){
				continue;
			}
			if (val >9999) {
				break;
			}
			numbers.add(val);
		}
		
		
		
		int[] ret = new int[numbers.size()];
		for (int j = 0; j<numbers.size(); j++){
			ret[j] = numbers.get(j);
		}
		return ret;
	}
	
	public static boolean findNext(int[][] figurateNumbers, int last, int length){
		for (int i = 0; i<6; i++){
			if (solutions[i]>0){
				continue;
			}
			for (int j = 0; j<figurateNumbers[i].length; j++){
				boolean unique = true;
				for (int k = 0; k<solutions.length; k++){
					if (figurateNumbers[i][j]==solutions[k]){
						unique = false;
						break;
					}
				}
				if (unique && figurateNumbers[i][j]/100 == solutions[last]%100){
					solutions[i] = figurateNumbers[i][j];
					if (length==5) {
						if (solutions[5]/100 == solutions[i]%100){
							return true;
						}
					}
					if (findNext(figurateNumbers, i, length+1)) return true;
				}
			}
			solutions[i] = 0;
		}
		return false;
		
		
	}

	static int solutions[] = new int[6];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] figurateNumbers = new int[6][];
		for (int i = 0; i<6; i++){
			figurateNumbers[i] = generateFigurateNumbers(i);
		}
		
		for (int i = 0; i<figurateNumbers[5].length; i++) {
			solutions[5] = figurateNumbers[5][i];
			if (findNext(figurateNumbers, 5, 1)){
				break;
			}
		}
		int sum = 0;
		for (int i = 0; i<6; i++){
			sum += solutions[i];
			System.out.println(solutions[i]);
		}
		System.out.println("sum = " + sum);
		System.exit(0);
		
	}

}
