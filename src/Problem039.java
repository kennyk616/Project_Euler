/**
 * integer right triangles
 * http://projecteuler.net/problem=39
 * @author ken
 *
 */
public class Problem039 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// max value of each side has to be <= 22. 
		int maxSideLength = 500;
		int n = 1000;
		int [] count = new int[n+1];
		
		for (int a = 1; a<maxSideLength; a++){
			for (int b = 1; b<maxSideLength; b++){
				double c = Math.sqrt(a*a + b*b);
				if (Math.floor(c)==c) {
					int sum = a + b + (int)c;
					if (sum<=n){
						count[sum]++;
					}
				}
			}
		}
		int maxCount = 0;
		int maxIdx = 0;
		for (int i= 0; i<=n; i++) {
			if (count[i]>maxCount){
				maxCount = count[i];
				maxIdx = i;
			}
		}
		
		System.out.println(maxIdx);
		System.exit(0);
	}

}
