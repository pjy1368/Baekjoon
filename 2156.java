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
		int n = Integer.parseInt(bf.readLine());
		long[] wine = new long[10001];
		long[] dp = new long[10001];

		for (int i = 1; i <= n; i++) {
			wine[i] = Integer.parseInt(bf.readLine());
		}

		dp[1] = wine[1];
		if (n > 1) {
			dp[2] = wine[1] + wine[2];
		}

		for (int i = 3; i <= n; i++) {
			dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + wine[i], dp[i - 3] + wine[i - 1] + wine[i]));
		}

		bw.write(dp[n] + "\n");
		bw.flush();
		bw.close();
		bf.close();
	}

}
