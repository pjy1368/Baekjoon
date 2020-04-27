package no.jam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
	int x;
	int y;
	int d;

	Point(int x, int y, int d) {
		this.x = x;
		this.y = y;
		this.d = d;
	}
}

public class Main {
	static int N, M;
	static int[][] map;
	static int[] rangeX = { -1, 0, 1, 0 };
	static int[] rangeY = { 0, 1, 0, -1 };
	static boolean[][] cleaned;
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken()); // 북 -> 동 -> 남 -> 서 (0 -> 1 -> 2 -> 3)

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		cleaned = new boolean[N][M];
		ans = 1;
		BFS(r, c, d);

		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	public static int position(int d) {
		if (d == 0) {
			return 3;
		} else if (d == 1) {
			return 0;
		} else if (d == 2) {
			return 1;
		} else {
			return 2;
		}
	}

	public static int backPosition(int d) {
		if (d == 0) {
			return 2;
		} else if (d == 1) {
			return 3;
		} else if (d == 2) {
			return 0;
		} else {
			return 1;
		}
	}

	public static void BFS(int x, int y, int d) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(x, y, d));
		cleaned[x][y] = true;

		while (!q.isEmpty()) {
			Point p = q.poll();
			d = p.d;

			int dx, dy, pos;
			int cleanNot = 0;

			// 네 방향 검사
			for (int i = 0; i < 4; i++) {
				pos = position(d);
				d = pos;

				dx = p.x + rangeX[pos];
				dy = p.y + rangeY[pos];

				if (dx >= 0 && dy >= 0 && dx < N && dy < M) {
					if (map[dx][dy] == 0 && !cleaned[dx][dy]) {
						cleaned[dx][dy] = true;
						ans++;
						q.offer(new Point(dx, dy, pos));
						break;
					}
				}
				cleanNot++;
			}

			if (cleanNot == 4) {
				pos = backPosition(p.d);
				dx = p.x + rangeX[pos];
				dy = p.y + rangeY[pos];

				if (dx >= 0 && dy >= 0 && dx < N && dy < M) {
					if (map[dx][dy] == 0) {
						q.offer(new Point(dx, dy, p.d));
					}
				}
			}

		}
	}

}