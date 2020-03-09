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

	Tomato(int y, int x) {
		this.x = x;
		this.y = y;
	}

}

public class Main {
	static int cnt = 0;
	static int[] rangeX = { 0, 1, 0, -1 };
	static int[] rangeY = { -1, 0, 1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken()); // 가로
		int N = Integer.parseInt(st.nextToken()); // 세로

		int[][] map = new int[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		BFS(map, M, N);

		int max = Integer.MIN_VALUE;

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (map[i][j] == 0) {
					bw.write("-1\n");
					bw.flush();
					br.close();
					bw.close();
					return;
				}

				max = Math.max(max, map[i][j]);
			}
		}

		bw.write((max - 1) + "\n");
		bw.flush();
		br.close();
		bw.close();
	}

	public static void BFS(int[][] map, int M, int N) {
		Queue<Tomato> q = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (map[i][j] == 1) {
					q.add(new Tomato(i, j));
				}
			}
		}

		while (!q.isEmpty()) {
			Tomato t = q.poll();
			int dx = 0;
			int dy = 0;

			for (int i = 0; i < 4; i++) {
				dx = t.x + rangeX[i];
				dy = t.y + rangeY[i];

				if (dx < 1 || dy < 1 || dx > M || dy > N) {
					continue;
				}

				if (map[dy][dx] != 0) {
					continue;
				}

				map[dy][dx] = map[t.y][t.x] + 1;
				q.add(new Tomato(dy, dx));
			}
		}

	}

}
