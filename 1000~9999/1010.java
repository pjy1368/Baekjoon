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
		int T = Integer.parseInt(br.readLine());

		int[][] dp = new int[30][30];
		for (int i = 0; i < 30; i++) {
			for (int j = 0; j < 30; j++) {
				dp[i][j] = -1;
			}
		}

		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			bw.write(combination(dp, M, N) + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}

	public static int combination(int[][] dp, int n, int r) {
		if (r == 0 || n == r) {
			return 1;
		}

		if (dp[n][r] != -1) {
			return dp[n][r];
		}

		return dp[n][r] = combination(dp, n - 1, r - 1) + combination(dp, n - 1, r);
	}

}