import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * XOR deccryption
 * http://projecteuler.net/problem=59
 * @author ken
 *
 */
public class Problem059 {
	
	public static int[] encrypt(int[] message, int[] key) {
		int[] encrypted = new int[message.length];
		
		for (int i = 0; i<message.length; i++) {
			encrypted[i] = message[i] ^ key[i%key.length];
		}
		return encrypted;
	}
	
	static double[] targetFreq = new double[]{8.167, 1.492, 2.782, 4.253, 12.702, 2.228, 2.015,
		6.094, 6.966, 0.153, 0.772, 4.025, 2.406, 6.749, 7.507, 1.929, 0.095, 5.987, 6.327, 
		9.056, 2.758, 0.978, 2.360, 0.150, 1.974, 0.074};

	static double calculateDiff(int[] message){
		int[] count = new int[26];
		for (int i = 0; i<message.length; i++){
			char val = (char)(message[i]);
			if ((val <='z' && val >='a') || (val<='Z' && val >='A')){
				val = Character.toLowerCase(val);
				int idx = val - 'a';
				count[idx]++;
			}
		}
		
		double freqDiff = 0.0;
		for (int i =0; i<count.length; i++) {
			double curFreq = (double)count[i]/message.length*100;
			freqDiff += Math.abs(curFreq - targetFreq[i]);
		}
		return freqDiff;
		
	}
	
	
	static int[] getBestKey(int[] message){
		int[] bestKey = new int[3];
		double minDiff = 100;
		
		for (int i = (int)('a'); i<=(int)('z'); i++){
			for (int j = (int)('a'); j<=(int)('z'); j++){
				for (int k = (int)('a'); k<=(int)('z'); k++){
					int[] key = new int[]{i, j, k};
					int[] decrypted = encrypt(message, key);
					double diff = calculateDiff(decrypted);
					if (diff < minDiff){
						minDiff = diff;
						bestKey = key;
					}
				}
			}
		}
		
		return bestKey;
	}
	
	
	public static void printMessage(int[] message){
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i<message.length; i++){
			sb.append((char)(message[i]));
		}
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new FileReader("cipher1.txt"));
		String[] encryptedStrings = br.readLine().split(",");
		int[] encryptedMessage = new int[encryptedStrings.length];
		for (int i = 0; i<encryptedMessage.length; i++){
			encryptedMessage[i] = Integer.parseInt(encryptedStrings[i]);
		}
		
		int[] bestKey = getBestKey(encryptedMessage);
		int[] decryptedMessage = encrypt(encryptedMessage, bestKey);
		int sum = 0;
		for (int i = 0; i<decryptedMessage.length; i++) {
			sum += decryptedMessage[i];
		}
		printMessage(bestKey);
		printMessage(decryptedMessage);
		System.out.println(sum);
		br.close();
		System.exit(0);
	}

}
