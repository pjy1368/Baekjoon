package noj.am;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
	int x;
	int y;
	int ok; // 벽을 부쉈는지 여부.
	int cnt; // 이동 횟수.

	Point(int x, int y, int ok, int cnt) {
		this.x = x;
		this.y = y;
		this.ok = ok;
		this.cnt = cnt;
	}
}

public class Main {
	static int N, M, K;
	static int[][] arr;
	static int[] rangeX = { -1, 0, 1, 0 };
	static int[] rangeY = { 0, 1, 0, -1 };
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		arr = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			String str = br.readLine();
			for (int j = 1; j <= M; j++) {
				arr[i][j] = Character.getNumericValue(str.charAt(j - 1));
			}
		}

		BFS(1, 1);
		bw.write((ans == Integer.MAX_VALUE) ? "-1\n" : (ans + "\n"));
		bw.flush();
		bw.close();
		br.close();
	}

	public static void BFS(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(x, y, 0, 1));

		boolean[][][] visited = new boolean[N + 1][M + 1][K + 1];
		visited[x][y][0] = true;

		while (!q.isEmpty()) {
			Point p = q.poll();

			if (p.x == N && p.y == M) {
				ans = p.cnt;
				return;
			}

			int dx, dy;
			for (int i = 0; i < 4; i++) {
				dx = p.x + rangeX[i];
				dy = p.y + rangeY[i];

				if (dx <= 0 || dy <= 0 || dx > N || dy > M) {
					continue;
				}

				if (!visited[dx][dy][p.ok]) {
					if (arr[dx][dy] == 0) {
						visited[dx][dy][p.ok] = true;
						q.offer(new Point(dx, dy, p.ok, p.cnt + 1));
					} else {
						if (p.ok < K) {
							visited[dx][dy][p.ok + 1] = true;
							q.offer(new Point(dx, dy, p.ok + 1, p.cnt + 1));
						}
					}
				}
			}
		}
	}

}