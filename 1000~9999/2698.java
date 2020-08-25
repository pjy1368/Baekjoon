import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int[][][] dp = new int[101][101][2];
		dp[1][0][0] = 1;
		dp[1][0][1] = 1;

		for (int k = 0; k <= 100; k++) {
			for (int n = 2; n <= 100; n++) {
				if (k == 0) {
					dp[n][k][1] = dp[n - 1][k][0];
				} else {
					dp[n][k][1] = dp[n - 1][k - 1][1] + dp[n - 1][k][0];
				}
				dp[n][k][0] = dp[n - 1][k][0] + dp[n - 1][k][1];
			}
		}

		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			sb.append(dp[N][K][0] + dp[N][K][1] + "\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}