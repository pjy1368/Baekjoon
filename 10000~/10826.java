import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		if (N == 0) {
			bw.write("0\n");
		} else if (N == 1) {
			bw.write("1\n");
		} else {
			BigInteger[] dp = new BigInteger[N + 1];

			dp[0] = BigInteger.ZERO;
			dp[1] = BigInteger.ONE;
			for (int i = 2; i <= N; i++) {
				dp[i] = dp[i - 2].add(dp[i - 1]);
			}

			bw.write(dp[N] + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}