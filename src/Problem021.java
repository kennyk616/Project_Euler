/**
 * amicable numbers
 * http://projecteuler.net/problem=21
 * @author ken
 *
 */
public class Problem021 {

	public static int d(int n) {
		int sqrt = (int)(Math.sqrt(n));
		int d = 0;
		for (int i =1; i<=sqrt; i++){
			if (n%i == 0){
				d += i;
				if(n/i != i){
					d += n/i;
				}
			}
		}
		return d-n;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n = 10000;
		int [] cache = new int[n];
		for (int i = 1; i<n; i++){
			cache[i] = d(i);
			
		}
		
		int sum = 0;
		for (int i = 1; i<n; i++) {
			int val = cache[i];
			if (val <n && val > i) {
				if (i == cache[val]){
					sum += (i + val);
				}
			}
		}
		
		System.out.println(sum);
		System.exit(0);
	}

}
