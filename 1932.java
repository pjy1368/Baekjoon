import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(bf.readLine());
		int[][] dp = new int[501][501];
		
		int max = Integer.MIN_VALUE;
		for(int i = 1; i <= N; i++) {
			String input = bf.readLine();
			StringTokenizer st = new StringTokenizer(input);
			for(int j = 1; j <= i; j++) {
				dp[i][j] = Integer.parseInt(st.nextToken());
				if(j == 1) {
					dp[i][j] = dp[i - 1][j] + dp[i][j];
				} else if(j == i) {
					dp[i][j] = dp[i - 1][j - 1] + dp[i][j];
				} else {
					dp[i][j] = Math.max(dp[i][j] + dp[i - 1][j], dp[i][j] + dp[i - 1][j - 1]);
				}
				max = Math.max(max, dp[i][j]);
			}
		}
		
		bw.write(max + "\n");
		bw.flush();
		bf.close();
		bw.close();
	}

}
