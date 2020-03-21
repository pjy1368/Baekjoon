package noj.am;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Tomato {
	int x;
	int y;
	int z;

	Tomato(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
}

public class Main {
	static int M, N, H;
	static int[][][] map;
	static int[] rangeX = { 0, 0, 1, -1, 0, 0 };
	static int[] rangeY = { 0, -1, 0, 0, 0, 1 };
	static int[] rangeZ = { -1, 0, 0, 0, 1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken()); // 가로
		N = Integer.parseInt(st.nextToken()); // 세로
		H = Integer.parseInt(st.nextToken()); // 높이

		map = new int[H + 1][N + 1][M + 1];
		for (int i = 1; i <= H; i++) {
			for (int j = 1; j <= N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 1; k <= M; k++) {
					map[i][j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}

		BFS();

		int max = Integer.MIN_VALUE;
		for (int i = 1; i <= H; i++) {
			for (int j = 1; j <= N; j++) {
				for (int k = 1; k <= M; k++) {
					if (map[i][j][k] == 0) {
						bw.write("-1\n");
						bw.flush();
						bw.close();
						br.close();
						return;
					}

					max = Math.max(max, map[i][j][k]);
				}
			}
		}

		bw.write((max - 1) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	public static void BFS() {
		Queue<Tomato> q = new LinkedList<>();

		for (int i = 1; i <= H; i++) {
			for (int j = 1; j <= N; j++) {
				for (int k = 1; k <= M; k++) {
					if (map[i][j][k] == 1) {
						q.offer(new Tomato(i, j, k));
					}
				}
			}
		}

		while (!q.isEmpty()) {
			Tomato t = q.poll();
			int dx, dy, dz;

			for (int i = 0; i < 6; i++) {
				dx = t.x + rangeX[i];
				dy = t.y + rangeY[i];
				dz = t.z + rangeZ[i];

				if (dx <= 0 || dy <= 0 || dz <= 0 || dx > H || dy > N || dz > M) {
					continue;
				}

				if (map[dx][dy][dz] != 0) {
					continue;
				}

				map[dx][dy][dz] = map[t.x][t.y][t.z] + 1;
				q.offer(new Tomato(dx, dy, dz));
			}
		}
	}

}
