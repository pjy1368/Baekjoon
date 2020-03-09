import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());

			int[][] dp = new int[k + 1][n];

			dp[0][0] = 1;
			for (int j = 1; j < n; j++) {
				dp[0][j] = j + 1;
			}

			for (int j = 1; j <= k; j++) {
				dp[j][0] = dp[j - 1][0];
				for (int z = 1; z < n; z++) {
					for (int w = 0; w <= z; w++) {
						dp[j][z] += dp[j - 1][w];
					}
				}
			}
			bw.write(dp[k][n - 1] + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}

}
