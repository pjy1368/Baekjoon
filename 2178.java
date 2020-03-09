import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] rangeX = { -1, 0, 1, 0 };
	static int[] rangeY = { 0, 1, 0, -1 };
	static int[][] map;
	static boolean[][] visit;
	static int N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 세로
		M = Integer.parseInt(st.nextToken()); // 가로
		map = new int[N + 1][M + 1];
		visit = new boolean[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			String str = br.readLine();
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(String.valueOf(str.charAt(j - 1)));
			}
		}

		BFS(1, 1);
		bw.write(map[N][M] + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	public static void BFS(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(x, y));

		while (!q.isEmpty()) {
			Point p = q.poll();
			visit[p.x][p.y] = true;

			for (int i = 0; i < 4; i++) {
				int dx = p.x + rangeX[i];
				int dy = p.y + rangeY[i];

				if (dx < 1 || dy < 1 || dx > N || dy > M) {
					continue;
				}

				if (map[dx][dy] == 0) {
					continue;
				}

				if (!visit[dx][dy]) {
					q.offer(new Point(dx, dy));
					map[dx][dy] = map[p.x][p.y] + 1;
					visit[dx][dy] = true;
				}
			}
		}
	}

}

class Point {
	int x, y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
