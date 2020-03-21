package noj.am;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int[] rangeX = { -1, 0, 1, -1 };
	static int[] rangeY = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken()); // 가로
			int N = Integer.parseInt(st.nextToken()); // 세로
			int K = Integer.parseInt(st.nextToken()); // 배추의 개수

			int[][] map = new int[N][M];
			while (K-- > 0) {
				st = new StringTokenizer(br.readLine());
				int t = Integer.parseInt(st.nextToken());
				int f = Integer.parseInt(st.nextToken());

				map[f][t] = 1;
			}

			boolean[][] visited = new boolean[N][M];
			int ans = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (!visited[i][j] && map[i][j] == 1) {
						ans++;
						DFS(i, j, map, visited, N, M);
					}
				}
			}
			bw.write(ans + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}

	public static void DFS(int x, int y, int[][] map, boolean[][] visited, int N, int M) {
		visited[x][y] = true;

		int dx, dy;
		for (int i = 0; i < 4; i++) {
			dx = x + rangeX[i];
			dy = y + rangeY[i];

			if (dx < 0 || dy < 0 || dx >= N || dy >= M) {
				continue;
			}

			if (!visited[dx][dy] && map[dx][dy] == 1) {
				visited[dx][dy] = true;
				DFS(dx, dy, map, visited, N, M);
			}
		}
	}

}
