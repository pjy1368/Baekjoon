package no.jam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int[] cost = new int[501];
		int[] sum = new int[501];
		int[][] dp = new int[501][501];

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			int K = Integer.parseInt(br.readLine());

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= K; i++) {
				cost[i] = Integer.parseInt(st.nextToken());
				sum[i] = sum[i - 1] + cost[i];
			}

			for (int i = 1; i < K; i++) {
				for (int j = 1; j + i <= K; j++) {
					int temp = j + i;
					dp[j][temp] = Integer.MAX_VALUE;

					for (int n = j; n < temp; n++) {
						dp[j][temp] = Math.min(dp[j][temp], dp[j][n] + dp[n + 1][temp] + sum[temp] - sum[j - 1]);
					}
				}
			}
			bw.write(dp[1][K] + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}