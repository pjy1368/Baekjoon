package noj.am;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		long[] dp = new long[N];
		for (int i = 0; i < N; i++) {
			dp[i] = Integer.parseInt(st.nextToken());
		}

		long max = dp[0];
		for (int i = 1; i < N; i++) {
			if (dp[i - 1] > 0 && dp[i] + dp[i - 1] > 0) {
				dp[i] += dp[i - 1];
			}

			max = Math.max(max, dp[i]);
		}

		bw.write(max + "\n");
		bw.flush();
		bw.close();
		br.close();

	}
}