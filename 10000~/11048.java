package no.jam1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int[] rangeX = { 0, 1, 1 };
	static int[] rangeY = { 1, 0, 1 };
	static int N, M;
	static int[][] map, dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				dp[i][j] = -1;
			}
		}

		bw.write(DFS(1, 1) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	public static int DFS(int x, int y) {
		if (dp[x][y] != -1) {
			return dp[x][y];
		}

		if (x == N && y == M) {
			return map[N][M];
		}

		dp[x][y] = map[x][y];

		for (int i = 0; i < 3; i++) {
			int dx = x + rangeX[i];
			int dy = y + rangeY[i];

			if (dx < 1 || dy < 1 || dx > N || dy > M) {
				continue;
			}

			dp[x][y] = Math.max(dp[x][y], map[x][y] + DFS(dx, dy));
		}

		return dp[x][y];
	}

}
