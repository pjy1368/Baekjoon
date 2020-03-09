import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] coins = new int[n];
		int[] dp = new int[k + 1];

		for (int i = 0; i < n; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 1; i <= k; i++) {
			dp[i] = 100001;
		}

		for (int i = 0; i < n; i++) {
			int c = coins[i];
			if (c > k) {
				continue;
			}
			dp[c] = 1;
			for (int j = c + 1; j <= k; j++) {
				int temp = dp[j - c] + 1;
				dp[j] = Math.min(dp[j], temp);
			}
		}

		if (dp[k] == 100001) {
			dp[k] = -1;
		}

		bw.write(dp[k] + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}
