package no.jam1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] cost;
	static int[] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		cost = new int[N + 1][2];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < 2; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp = new int[N + 1];
		Arrays.fill(dp, -1);

		int ans = 0;
		for (int i = 1; i < N; i++) {
			ans = Math.max(ans, recursion(i));
		}

		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	public static int recursion(int day) {
		if (dp[day] != -1) {
			return dp[day];
		}

		// 퇴사하는 날 넘어서까지 일을 해야하는 경우
		if (day + cost[day][0] > N + 1) {
			return 0;
		}

		dp[day] = cost[day][1];
		for (int i = day + cost[day][0]; i <= N; i++) {
			// 딱 퇴사하는 날까지만 일 가능하다고 가정.
			if (i + cost[i][0] <= N + 1) {
				dp[day] = Math.max(dp[day], cost[day][1] + recursion(i));
			}
		}

		return dp[day];
	}
}
