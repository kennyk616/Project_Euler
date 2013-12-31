
/**
 * substring divisibiliby
 * http://projecteuler.net/problem=43
 * @author ken
 *
 */
public class Problem043 {
	/*
	 * can be done by hand calculation.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long[] values = new long[]{1430952867, 4130952867L, 1460357289, 4160357289L, 1406357289, 4106357289L};
		long sum = 0;
		for (long val : values){
			sum += val;
		}
		
		System.out.println(sum);
		System.exit(0);
		
	}

}
