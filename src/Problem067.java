import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class Problem067 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int n = 100;
		BufferedReader br = new BufferedReader(new FileReader("triangle.txt"));
		int [][] grid = new int[n][n];
		for (int i = 0; i<n; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j<=i; j++){
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] sumGrid = new int[n][n];
		sumGrid[0][0] = grid[0][0];
		
		for (int i = 1; i<n; i++){
			for (int j = 0; j<=i; j++){
				int sum1 = 0;
				if (j>0){
					sum1 = sumGrid[i-1][j-1] + grid[i][j];
				}
				int sum2 = sumGrid[i-1][j] + grid[i][j];
				sumGrid[i][j] = Math.max(sum1, sum2);
			}
		}
		
		int maxSum = 0;
		for (int i = 0; i<n; i++){
			maxSum = Math.max(maxSum, sumGrid[n-1][i]);
		}
		
		
		System.out.println(maxSum);
		br.close();
		System.exit(0);

	}

}
