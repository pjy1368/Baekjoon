import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		long[] dp = new long[31];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;

		for (int i = 3; i <= 30; i++) {
			long cnt = 0;

			for (int j = 0; j < i; j++) {
				cnt += dp[j] * dp[i - 1 - j];
			}

			dp[i] = cnt;
		}

		StringBuilder sb = new StringBuilder();
		while (true) {
			int N = Integer.parseInt(br.readLine());

			if (N == 0) {
				break;
			}

			sb.append(dp[N] + "\n");
		}

		bw.write(sb.toString());
		bw.close();
		br.close();
	}

}