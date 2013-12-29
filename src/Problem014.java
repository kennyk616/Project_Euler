
/**
 * longest collatz sequence
 * http://projecteuler.net/problem=14
 * @author ken
 *
 */
public class Problem014 {

	
	public static int calculateSequenceLength(long n, int[] cache) {
		long val = n;
		int count = 1;
		while (val !=1) {
			if(val < n){
				return count + cache[(int)(val-1)]-1;
			}
			if(val%2==0){
				val = val/2;
			}else {
				val = 3*val+1;
			}
			count ++;
		}		
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long longestSeq = 0;
		int seqLength = 0;
		int limit = 1000000;
		int[] cache = new int[limit];
		for (int i = 1; i<limit; i++){
			int length = calculateSequenceLength(i, cache);
			cache[i-1] = length;
			if (length > seqLength){
				seqLength = length;
				longestSeq = i;
			}
		}
		
		System.out.println(longestSeq);
		System.out.println(seqLength);
		
		System.exit(0);
		
	}

}
