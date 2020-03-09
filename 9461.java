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
		for (int i = 1; i <= T; i++) {
			int N = Integer.parseInt(bf.readLine());
			long[] dp = new long[101];
			dp[1] = dp[2] = dp[3] = 1;
			dp[4] = dp[5] = 2;
			dp[6] = 3;
			dp[7] = 4;
			dp[8] = 5;
			dp[9] = 7;

			for (int j = 10; j <= N; j++) {
				dp[j] = dp[j - 1] + dp[j - 5];
			}
			bw.write(dp[N] + "\n");
		}
		bw.flush();
		bw.close();
		bf.close();
	}

}
