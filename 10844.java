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
		final int MAX = 1000000000;
		int N = Integer.parseInt(bf.readLine());
		int[][] dp = new int[101][11];
		long sum = 0;

		for (int i = 0; i <= 9; i++) {
			dp[1][i] = 1;
		}

		for (int i = 2; i <= N; i++) {
			for (int j = 0; j <= 9; j++) {
				if (j == 0) {
					dp[i][j] = dp[i - 1][1] % MAX;
				} else if (j == 9) {
					dp[i][j] = dp[i - 1][8] % MAX;
				} else {
					dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % MAX;
				}
			}
		}
		for (int i = 1; i < 10; i++) {
			sum += dp[N][i];
		}

		bw.write(sum % MAX + "\n");
		bw.flush();
		bf.close();
		bw.close();

	}

}
