package noj.am;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int[][] dp = new int[41][2];
		dp[0][0] = 1;
		dp[0][1] = 0;
		dp[1][0] = 0;
		dp[1][1] = 1;

		for (int i = 2; i <= 40; i++) {
			for (int j = 0; j < 2; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i - 2][j];
			}
		}

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			bw.write(dp[N][0] + " " + dp[N][1] + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}

}
