import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		if (N == 0) {
			bw.write("0\n");
			bw.flush();
			bw.close();
			br.close();
			return;
		}

		if (N == 1 || N == 2) {
			bw.write("1\n");
			bw.flush();
			bw.close();
			br.close();
			return;
		}
		int[] dp = new int[N + 1];
		dp[0] = 0;
		dp[1] = dp[2] = 1;

		for (int i = 3; i <= N; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}

		bw.write(dp[N] + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}
