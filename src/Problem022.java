import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * name score
 * http://projecteuler.net/problem=22
 * @author ken
 *
 */
public class Problem022 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new FileReader("names.txt"));
		String input = br.readLine();
		System.out.println(input);
		String[] names = input.split(",");
		Arrays.sort(names);
		
		long sum = 0;
		for (int i = 0; i < names.length; i++){
			char[] name = names[i].substring(1, names[i].length()-1).toCharArray();
			int score = 0;
			for (int j = 0; j<name.length; j++) {
				score += name[j]-'A';
				score ++;
			}
			sum += (score*(i+1));
		}
		
		System.out.println(sum);
		
		br.close();
		System.exit(0);

	}

}
