import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(bf.readLine());
		final int MAX = 10007;
		int[][] dp = new int[1001][10];
		int[] T = new int[1001];
		Arrays.fill(dp[1], 1);
		T[1] = 10;

		for (int i = 2; i <= N; i++) {
			for (int j = 0; j < 10; j++) {
				int num = 0;
				for (int k = 0; k < j; k++) {
					num += dp[i - 1][k];
				}
				dp[i][j] = (T[i - 1] - num) % MAX;
				T[i] += dp[i][j];
			}
		}

		long total = 0;
		for (int i = 0; i < 10; i++) {
			total += dp[N][i];
		}

		bw.write(total % MAX + "\n");
		bw.flush();
		bf.close();
		bw.close();

	}

}
