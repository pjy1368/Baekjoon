import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] dp = new int[5001];
		dp[0] = dp[1] = 0;
		dp[2] = 1;

		boolean[] check = new boolean[16];
		for (int i = 3; i <= 5000; i++) {
			Arrays.fill(check, false);
			for (int j = 0; j <= i - 2; j++) {
				int temp = dp[j] ^ dp[i - 2 - j];
				check[temp] = true;
			}

			for (int j = 0; j < 16; j++) {
				if (!check[j]) {
					dp[i] = j;
					break;
				}
			}
		}

		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());

			sb.append(dp[N] != 0 ? "First\n" : "Second\n");
		}

		bw.write(sb.toString());
		bw.close();
		br.close();
	}

}