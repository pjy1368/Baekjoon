import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(bf.readLine());

		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(bf.readLine());
			int[] dp = new int[11];
			dp[1] = 1;
			dp[2] = 2;
			dp[3] = 4;
			dp[4] = 7;
			
			for (int j = 5; j <= n; j++) {
				dp[j] = dp[j - 1] + dp[j - 2] + dp[j - 3];
			}
			
			bw.write(dp[n] + "\n");
		}
		bf.close();
		bw.flush();
		bw.close();
	}

}
