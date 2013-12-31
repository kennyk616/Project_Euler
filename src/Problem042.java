import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * coded triangle numbers
 * http://projecteuler.net/problem=42
 * @author ken
 *
 */
public class Problem042 {

	public static Set<Integer> generateTriangleNumbers(int n) {
		Set<Integer> triangleNumbers = new HashSet<Integer>();
		
		int i = 1;
		int val;
		while ((val = i*(i+1)/2) <=n) {
			triangleNumbers.add(val);
			i++;
		}
		
		return triangleNumbers;
	}
	
	public static int calculateNameValue(String name) {
		int val = 0;
		for (char ch : name.toCharArray()){
			val += (ch-'A'+1);
		}
		return val;
	}

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new FileReader("words.txt"));
		String input = br.readLine().replace("\"", "");
		String [] names = input.split(",");
		
		int longestLength = 0;
		for (String name : names){
			longestLength = Math.max(name.length(), longestLength);
		}
		
		int maxValue = longestLength*26;
		
		Set<Integer> triangleNumbers = generateTriangleNumbers(maxValue);
		
		int count = 0;
		
		for (String name: names){
			if (triangleNumbers.contains(calculateNameValue(name))){
				count++;
			}
		}

		System.out.println(count);
		
		br.close();
		System.exit(0);

	}

}
